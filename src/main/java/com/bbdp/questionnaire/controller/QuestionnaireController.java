/*
This code is generated from JMMA (Java Microservice migration assistant).
JMMA is a tiny widget that helps with generating controller templates from existing models.
The users only need to add some annotations.
For more information and source code, you are able to find them on Github.
(https://github.com/570gina/JMMA)

Author: CHIAYU LI
National Taiwan Ocean University - SOSELab
*/
package com.bbdp.questionnaire.controller;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbdp.questionnaire.model.QuestionnaireServer;
import com.bbdp.questionnaire.model.callapi.DoctorService;
import com.bbdp.questionnaire.model.callapi.PatientService;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

// Source: QuestionnaireServer.java
@RestController
@RequestMapping(value = "/Questionnaire")
public class QuestionnaireController {
    @Autowired
    DataSource dataSource;

    //取得病患待填問卷
    // Original method: getQuestionnaireList
    @RequestMapping(value = "/getQuestionnaireList", method = RequestMethod.GET)
    public ArrayList getQuestionnaireList(@RequestParam String patientID) throws SQLException {
        return QuestionnaireServer.getQuestionnaireList(dataSource.getConnection(),patientID);
    }

    //搜尋全部醫院
    // Original method: searchHospital
    @RequestMapping(value = "/searchHospital", method = RequestMethod.GET)
    public String searchHospital() {
        return DoctorService.searchHospital();
    }

    //根據醫院選科別
    // Original method: searchDepartment
    @RequestMapping(value = "/searchDepartment", method = RequestMethod.GET)
    public String searchDepartment(@RequestParam String hospital) {
        return DoctorService.searchDepartment(hospital);
    }

    //根據科別選醫生
    // Original method: searchDoctor
    @RequestMapping(value = "/searchDoctor", method = RequestMethod.GET)
    public ArrayList searchDoctor(@RequestParam String hospital, @RequestParam String department) {
        return DoctorService.searchDoctor(hospital, department);
    }

    //根據醫生選症狀
    // Original method: searchSymptom
    @RequestMapping(value = "/searchSymptom", method = RequestMethod.GET)
    public ArrayList searchSymptom(@RequestParam String doctorID) throws SQLException {
        return QuestionnaireServer.searchSymptom(dataSource.getConnection(), doctorID);
    }

    //搜尋問卷編號(初診)
    // Original method: searchQuestionnaireID
    @RequestMapping(value = "/searchQuestionnaireID", method = RequestMethod.GET)
    public String searchQuestionnaireID(@RequestParam String doctorID, @RequestParam String symptom) throws SQLException {
        return QuestionnaireServer.searchQuestionnaireID(dataSource.getConnection(), doctorID, symptom);
    }

    //取得病患名字
    // Original method: getPatientName
    @RequestMapping(value = "/getPatientName", method = RequestMethod.GET)
    public String getPatientName(@RequestParam String patientID) {
        return PatientService.getPatientName(patientID);
    }

    //取得問卷資訊
    // Original method: getQuestionnaire
    //changed the name to "getQuestionnaireHeader"
    @RequestMapping(value = "/getQuestionnaireHeader", method = RequestMethod.GET)
    public ArrayList getQuestionnaireHeader(@RequestParam String doctorID, @RequestParam String questionnaireID) throws SQLException, JSONException {
        return QuestionnaireServer.getQuestionnaireHeader(dataSource.getConnection(), doctorID, questionnaireID);
    }

    //取得問卷題目
    // Original method: getQuestionList
    @RequestMapping(value = "/getQuestionList", method = RequestMethod.GET)
    public ArrayList getQuestionList(@RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireServer.getQuestionList(dataSource.getConnection(),  questionnaireID);
    }

    //取得問卷段落名稱
    // Original method: getPartName
    @RequestMapping(value = "/getPartName", method = RequestMethod.GET)
    public String getPartName(@RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireServer.getPartName(dataSource.getConnection(), questionnaireID);
    }

    //取的題目名稱及選項
    // Original method: getNameAndOption
    @RequestMapping(value = "/getNameAndOption", method = RequestMethod.GET)
    public ArrayList getNameAndOption(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        return QuestionnaireServer.getNameAndOption(dataSource.getConnection(), doctorID, questionID);
    }

    //取得題目圖片
    // Original method: getImage
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public FileInputStream getImage(@RequestParam String imagePath) {
        // TODO
        return null;
    }

    //移除待填問卷
    // Original method: removeUnfilledQuestionnaire
    @RequestMapping(value = "/removeUnfilledQuestionnaire", method = RequestMethod.POST)
    public void removeUnfilledQuestionnaire(@RequestParam String unfilledID) throws SQLException {
        QuestionnaireServer.removeUnfilledQuestionnaire(dataSource.getConnection(), unfilledID);
    }

    //新增問卷答案
    // Original method: newQuestionnaireAnswer
    @RequestMapping(value = "/newQuestionnaireAnswer", method = RequestMethod.POST)
    public String newQuestionnaireAnswer(@RequestParam String patientID, @RequestParam String questionnaireID, @RequestParam String answerArray, @RequestParam String describe) throws SQLException {
        return QuestionnaireServer.newQuestionnaireAnswer(dataSource.getConnection(), patientID, questionnaireID, answerArray, describe);
    }

    //問卷填寫紀錄
    // Original method: getQuestionnaireHistory
    @RequestMapping(value = "/getQuestionnaireHistory", method = RequestMethod.GET)
    public ArrayList getQuestionnaireHistory(@RequestParam String patientID) throws SQLException {
        return QuestionnaireServer.getQuestionnaireHistory(dataSource.getConnection(), patientID);
    }
}
