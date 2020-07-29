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

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bbdp.questionnaire.model.PatientQuestionnaireServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

// Source: PatientQuestionnaireServer.java
@RestController
@RequestMapping(value = "/PatientQuestionnaire")
public class PatientQuestionnaireController {

    @Autowired
    DataSource dataSource;

    // Original method: newPatientQuestionnaire
    @RequestMapping(value = "/newPatientQuestionnaire", method = RequestMethod.POST)
    public int newPatientQuestionnaire(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String questionnaireID, @RequestParam String times, @RequestParam String cycleType, @RequestParam String totalTimes, @RequestParam String today) throws SQLException {
        return PatientQuestionnaireServer.newPatientQuestionnaire(dataSource.getConnection(), doctorID, patientID, questionnaireID, times, cycleType, totalTimes,today);
    }

    // Original method: searchPatientQuestionnaireType
    @RequestMapping(value = "/searchPatientQuestionnaireType", method = RequestMethod.GET)
    public ArrayList searchPatientQuestionnaireType(@RequestParam String doctorID, @RequestParam String patientID) throws SQLException {
        return PatientQuestionnaireServer.searchPatientQuestionnaireType(dataSource.getConnection(), doctorID, patientID);
    }

    // Original method: selectQuestionnaire
    @RequestMapping(value = "/selectQuestionnaire", method = RequestMethod.GET)
    public ArrayList selectQuestionnaire(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String patientSelect) throws SQLException {
        if(patientSelect.equals("all"))
            return PatientQuestionnaireServer.searchPatientQuestionnaireType(dataSource.getConnection(),doctorID,patientID);
        else if(patientSelect.equals("not"))
            return PatientQuestionnaireServer.unfilledquestionnaire(dataSource.getConnection(),doctorID,patientID);
        else
            return PatientQuestionnaireServer.selectQuestionnaire(dataSource.getConnection(),doctorID,patientID,patientSelect);
      }

    // Original method: unfilledquestionnaire
    @RequestMapping(value = "/unfilledquestionnaire", method = RequestMethod.GET)
    public ArrayList unfilledquestionnaire(@RequestParam String doctorID, @RequestParam String patientID) throws SQLException {
        return PatientQuestionnaireServer.unfilledquestionnaire(dataSource.getConnection(), doctorID, patientID);
    }

    // Original method: selectQuestionnaireDate
    @RequestMapping(value = "/selectQuestionnaireDate", method = RequestMethod.GET)
    public ArrayList selectQuestionnaireDate(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String patientSelect, @RequestParam String type, @RequestParam String dateRange) throws SQLException {
        return PatientQuestionnaireServer.selectQuestionnaireDate(dataSource.getConnection(), doctorID, patientID, patientSelect, type, dateRange);
    }

    // Original method: getQuestionnaireList
    @RequestMapping(value = "/getQuestionnaireList", method = RequestMethod.GET)
    public ArrayList getQuestionnaireList(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String patientSelect, @RequestParam String type, @RequestParam String dateRange, @RequestParam String date) throws SQLException {
        return PatientQuestionnaireServer.getQuestionnaireList(dataSource.getConnection(), doctorID, patientID, patientSelect, type, dateRange, date);
    }

    // Original method: checkAnswerID
    @RequestMapping(value = "/checkAnswerID", method = RequestMethod.GET)
    public String checkAnswerID(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID) throws SQLException {
        return PatientQuestionnaireServer.checkAnswerID(dataSource.getConnection(), doctorID, patientID, answerID);
    }

    // Original method: checkUnfilledID
    @RequestMapping(value = "/checkUnfilledID", method = RequestMethod.GET)
    public String checkUnfilledID(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String unfilledID) throws SQLException {
        return PatientQuestionnaireServer.checkUnfilledID(dataSource.getConnection(), doctorID, patientID, unfilledID);
    }

    // Original method: getUnfilledQuestionnaire
    @RequestMapping(value = "/getUnfilledQuestionnaire", method = RequestMethod.GET)
    public ArrayList getUnfilledQuestionnaire(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String unfilledID) throws SQLException {
        return PatientQuestionnaireServer.getUnfilledQuestionnaire(dataSource.getConnection(), doctorID, patientID, unfilledID);
    }

    // Original method: cancelQuestionnaire
    @RequestMapping(value = "/cancelQuestionnaire", method = RequestMethod.POST)
    public int cancelQuestionnaire(@RequestParam Connection conn, @RequestParam String patientID, @RequestParam String unfilledID) throws SQLException {
        return PatientQuestionnaireServer.cancelQuestionnaire(dataSource.getConnection(), patientID, unfilledID);
    }

    // Original method: getQuestionnaireAnswer
    @RequestMapping(value = "/getQuestionnaireAnswer", method = RequestMethod.GET)
    public ArrayList getQuestionnaireAnswer(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID) throws SQLException {
        return PatientQuestionnaireServer.getQuestionnaireAnswer(dataSource.getConnection(), doctorID, patientID, answerID);
    }

    // Original method: getOptionAnswer
    @RequestMapping(value = "/getOptionAnswer", method = RequestMethod.GET)
    public String getOptionAnswer(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID) throws SQLException {
        return PatientQuestionnaireServer.getOptionAnswer(dataSource.getConnection(), doctorID, patientID, answerID);
    }

    // Original method: getPatientOptionAnswer
    @RequestMapping(value = "/getPatientOptionAnswer", method = RequestMethod.GET)
    public String getPatientOptionAnswer(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID) throws SQLException {
        return PatientQuestionnaireServer.getPatientOptionAnswer(dataSource.getConnection(), doctorID, patientID, answerID);
    }

    // Original method: getMedicalRecord
    @RequestMapping(value = "/getMedicalRecord", method = RequestMethod.GET)
    public ArrayList getMedicalRecord(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String questionnaireID) throws SQLException {
        return PatientQuestionnaireServer.getMedicalRecord(dataSource.getConnection(), doctorID, patientID, questionnaireID);
    }

    // Original method: getMoreButton
    @RequestMapping(value = "/getMoreButton", method = RequestMethod.GET)
    public String getMoreButton(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID) throws SQLException {
        return PatientQuestionnaireServer.getMoreButton(dataSource.getConnection(), doctorID, patientID, answerID);
    }

    // Original method: newAnswer
    @RequestMapping(value = "/newAnswer", method = RequestMethod.POST)
    public String newAnswer(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID, @RequestParam String questionnaireID, @RequestParam String doctorAnswer, @RequestParam String selfDescription) throws SQLException {
        return PatientQuestionnaireServer.newAnswer(dataSource.getConnection(), doctorID, patientID, answerID, questionnaireID, doctorAnswer,selfDescription);
    }

    // Original method: deleteDoctorAnswer
    @RequestMapping(value = "/deleteDoctorAnswer", method = RequestMethod.POST)
    public int deleteDoctorAnswer(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String answerID) throws SQLException {
        return PatientQuestionnaireServer.deleteDoctorAnswer(dataSource.getConnection(), doctorID, patientID, answerID);
    }

    // Original method: getNewestAnswer
    @RequestMapping(value = "/getNewestAnswer", method = RequestMethod.GET)
    public ArrayList getNewestAnswer(@RequestParam String doctorID, @RequestParam String patientID) throws SQLException {
        return PatientQuestionnaireServer.getNewestAnswer(dataSource.getConnection(), doctorID, patientID);
    }
}
