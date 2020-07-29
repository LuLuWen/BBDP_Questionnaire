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

import java.sql.SQLException;
import java.util.ArrayList;

import com.bbdp.questionnaire.model.QuestionnairePoolServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

// Source: QuestionnairePoolServer.java
@RestController
@RequestMapping(value = "/QuestionModule")
public class QuestionModuleController {

    @Autowired
    DataSource dataSource;

    // Original method: newQuestion
    @RequestMapping(value = "/newQuestion", method = RequestMethod.POST)
    public int newQuestion(@RequestParam String doctorID, @RequestParam String questionID, @RequestParam String questionName, @RequestParam String questionType, @RequestParam String questionOptionType, @RequestParam String questionOption) throws SQLException {
        return QuestionnairePoolServer.newQuestion(dataSource.getConnection(), doctorID, questionID, questionName, questionType, questionOptionType, questionOption);
    }

    // Original method: getMaxQuestionID
    @RequestMapping(value = "/getMaxQuestionID", method = RequestMethod.GET)
    public String getMaxQuestionID(@RequestParam String doctorID) throws SQLException {
        return QuestionnairePoolServer.getMaxQuestionID(dataSource.getConnection(), doctorID);
    }

    // Original method: deleteQuestionIDList
    @RequestMapping(value = "/deleteQuestionIDList", method = RequestMethod.POST)
    public void deleteQuestionIDList(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        QuestionnairePoolServer.deleteQuestionIDList(dataSource.getConnection(), doctorID, questionID);
    }

    // Original method: searchType
    @RequestMapping(value = "/searchType", method = RequestMethod.GET)
    public ArrayList searchType(@RequestParam String doctorID) throws SQLException {
        return QuestionnairePoolServer.searchType(dataSource.getConnection(), doctorID);
    }

    // Original method: searchAllQuestion
    @RequestMapping(value = "/searchAllQuestion", method = RequestMethod.GET)
    public ArrayList searchAllQuestion(@RequestParam String doctorID) throws SQLException {
        return QuestionnairePoolServer.searchAllQuestion(dataSource.getConnection(), doctorID);
    }

    // Original method: searchQuestion
    @RequestMapping(value = "/searchQuestion", method = RequestMethod.GET)
    public ArrayList searchQuestion(@RequestParam String doctorID, @RequestParam String type) throws SQLException {
        return QuestionnairePoolServer.searchQuestion(dataSource.getConnection(), doctorID, type);
    }

    // Original method: getQuestion
    @RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
    public String getQuestion(@RequestParam String doctorID, @RequestParam String questionID, @RequestParam String item) throws SQLException {
        return QuestionnairePoolServer.getQuestion(dataSource.getConnection(), doctorID, questionID, item);
    }

    // Original method: getMedicalRecord
    @RequestMapping(value = "/getMedicalRecord", method = RequestMethod.GET)
    public String getMedicalRecord(@RequestParam String doctorID, @RequestParam String questionID, @RequestParam String item) throws SQLException {
        return QuestionnairePoolServer.getMedicalRecord(dataSource.getConnection(), doctorID, questionID, item);
    }

    // Original method: deleteQuestion
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
    public int deleteQuestion(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        return QuestionnairePoolServer.deleteQuestion(dataSource.getConnection(), doctorID, questionID);
    }

    // Original method: allowUpdateQuestion
    @RequestMapping(value = "/allowUpdateQuestion", method = RequestMethod.GET)
    public int allowUpdateQuestion(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        return QuestionnairePoolServer.allowUpdateQuestion(dataSource.getConnection(), doctorID, questionID);
    }

    // Original method: updateQuestion
    @RequestMapping(value = "/updateQuestion", method = RequestMethod.POST)
    public int updateQuestion(@RequestParam String doctorID, @RequestParam String questionID, @RequestParam String questionName, @RequestParam String questionType, @RequestParam String questionOptionType, @RequestParam String questionOption, @RequestParam String medicalRecord) throws SQLException {
        return QuestionnairePoolServer.updateQuestion(dataSource.getConnection(), doctorID, questionID, questionName, questionType, questionOptionType, questionOption, medicalRecord);
    }

    // Original method: addTempStorage
    @RequestMapping(value = "/addTempStorage", method = RequestMethod.POST)
    public int addTempStorage(@RequestParam String doctorID, @RequestParam String questionArray) throws SQLException {
        return QuestionnairePoolServer.addTempStorage(dataSource.getConnection(), doctorID, questionArray);
    }

    // Original method: searchTempStorageType
    @RequestMapping(value = "/searchTempStorageType", method = RequestMethod.GET)
    public ArrayList searchTempStorageType(@RequestParam String doctorID) throws SQLException {
        return QuestionnairePoolServer.searchTempStorageType(dataSource.getConnection(), doctorID);
    }

    // Original method: searchAllTempStorage
    @RequestMapping(value = "/searchAllTempStorage", method = RequestMethod.GET)
    public ArrayList searchAllTempStorage(@RequestParam String doctorID) throws SQLException {
        return QuestionnairePoolServer.searchAllTempStorage(dataSource.getConnection(), doctorID);
    }

    // Original method: searchTempStorageQuestion
    @RequestMapping(value = "/searchTempStorageQuestion", method = RequestMethod.GET)
    public ArrayList searchTempStorageQuestion(@RequestParam String doctorID, @RequestParam String type) throws SQLException {
        return QuestionnairePoolServer.searchTempStorageQuestion(dataSource.getConnection(), doctorID, type);
    }

    // Original method: removeTempStorage
    @RequestMapping(value = "/removeTempStorage", method = RequestMethod.POST)
    public int removeTempStorage(@RequestParam String doctorID, @RequestParam String questionArray) throws SQLException {
        return QuestionnairePoolServer.removeTempStorage(dataSource.getConnection(), doctorID, questionArray);
    }

    // Original method: checkID
    @RequestMapping(value = "/checkID", method = RequestMethod.GET)
    public String checkID(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        return QuestionnairePoolServer.checkID(dataSource.getConnection(), doctorID, questionID);
    }
}
