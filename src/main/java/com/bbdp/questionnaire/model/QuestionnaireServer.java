package com.bbdp.questionnaire.model;

import com.bbdp.questionnaire.model.callapi.DoctorService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class QuestionnaireServer {
	public static ArrayList getQuestionnaireList(Connection conn, String patientID) {
		ArrayList questionList = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM unfilledquestionnaire join questionnaire where patientID='"+patientID+"' and questionnaire.questionnaireID = unfilledquestionnaire.questionnaireID and sendDate <= '"+sdf.format(now.getTime())+"' ORDER BY sendDate DESC");
		    while (rs.next()) {
				JSONObject doctor = DoctorService.getDoctorInfoByID(rs.getString("questionnaire.doctorID"));
				questionList.add(doctor.get("department"));//0
				questionList.add(rs.getString("questionnaire.doctorID"));//1
				questionList.add(doctor.get("name"));//2
				questionList.add(rs.getString("questionnaireID"));//3
				questionList.add(rs.getString("questionnaire.name"));//4
				questionList.add(rs.getString("sendDate"));//5
				questionList.add(rs.getString("unfilledID"));//6
		    }
			rs.close();
		    st.close();
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return questionList;
	}
	public static ArrayList searchSymptom(Connection conn, String doctorID) {
		ArrayList searchList = new ArrayList();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select symptom FROM questionnaire where doctorID = '"+doctorID+"' and symptom is not null");
		    while (rs.next()) {
		    	searchList.add(rs.getString("symptom"));
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return searchList;
	}
	public static String searchQuestionnaireID(Connection conn, String doctorID, String symptom) {
		String returnString = "";
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select questionnaireID FROM questionnaire where doctorID = '"+doctorID+"' and symptom = '"+symptom+"'");
		    while (rs.next()) {
		    	returnString = rs.getString("questionnaireID");
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return returnString;
	}
	public static ArrayList getQuestionnaireHeader(Connection conn, String doctorID, String questionnaireID) throws JSONException {
		ArrayList questionList = new ArrayList();
			try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM questionnaire where questionnaireID = '"+questionnaireID+"'");
		    while (rs.next()) {
				questionList.add(rs.getString("questionnaire.name"));//0
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		JSONObject doctor = DoctorService.getDoctorInfoByID(doctorID);
		questionList.add(doctor.get("hospital"));//1
		questionList.add(doctor.get("department"));//2
		questionList.add(doctor.get("name"));//3
		return questionList;
	}
	public static ArrayList getQuestionList(Connection conn, String questionnaireID) {
		ArrayList questionnaireList = new ArrayList();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM questionsort where questionnaireID = '"+questionnaireID+"' ORDER BY CAST(sortNumber AS UNSIGNED)");
		    while (rs.next()) {
		    	questionnaireList.add(rs.getString("partNumber"));
		    	questionnaireList.add(rs.getString("questionID"));
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return questionnaireList;
	}
	public static String getPartName(Connection conn, String questionnaireID) {
		String returnString = "";
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select partName FROM questionnaire where questionnaireID = '"+questionnaireID+"'");
		    while (rs.next()) {
		        returnString = rs.getString("partName");
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return returnString;
	}
	public static ArrayList getNameAndOption(Connection conn, String doctorID, String questionID) {
		ArrayList questionList = new ArrayList();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM question where doctorID='"+doctorID+"' and questionID = '"+questionID+"'");
		    while (rs.next()) {
		    	questionList.add(rs.getString("question"));
				questionList.add(rs.getString("option"));
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return questionList;
	}
	static public FileInputStream getImage(String imagePath){
		File downloadFile = new File("C:/apache-tomcat-8.0.44/webapps/BBDPDoctor/"+imagePath);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);		
		}
		catch (FileNotFoundException e) {
			System.out.println("發生FileNotFoundException : " + e);
		}
		
		return inputStream;
	}
	public static void removeUnfilledQuestionnaire(Connection conn, String unfilledID) {
		try {
			Statement st = conn.createStatement();
			int temp = st.executeUpdate("DELETE FROM unfilledquestionnaire where unfilledID ='"+unfilledID+"'");
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
	}
	synchronized public static String newQuestionnaireAnswer(Connection conn, String patientID, String questionnaireID, String answerArray, String describe) {
		int tempInt = 0;
		String returnString = "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance(); 		
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select ifNULL(max(answerID+0),0)+1 FROM answer");
		    if (rs.next()) {
		    	returnString = rs.getString("ifNULL(max(answerID+0),0)+1");
		    	tempInt = st.executeUpdate("INSERT INTO answer (answerID,questionnaireID,patientID,date,selfDescription,answer) select ifNULL(max(answerID+0),0)+1,'"+questionnaireID+"','"+patientID+"','"+sdf.format(now.getTime())+"','"+describe+"','"+answerArray+"'FROM answer");
		    }
		    rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return returnString;
	}
	public static ArrayList getQuestionnaireHistory(Connection conn, String patientID) {
		ArrayList questionnaireList = new ArrayList();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM answer join questionnaire where and answer.questionnaireID = questionnaire.questionnaireID and patientID='"+patientID+"' ORDER BY date DESC");
		    while (rs.next()) {
				JSONObject doctor = DoctorService.getDoctorInfoByID(rs.getString("questionnaire.doctorID"));
		    	questionnaireList.add(rs.getString("questionnaire.name"));//0
				questionnaireList.add(doctor.get("hospital"));//1
				questionnaireList.add(doctor.get("department"));//2
				questionnaireList.add(doctor.get("name"));//3
				questionnaireList.add(rs.getString("answer.date"));//4
		    }
			rs.close();
		    st.close();
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return questionnaireList;
	}
}
