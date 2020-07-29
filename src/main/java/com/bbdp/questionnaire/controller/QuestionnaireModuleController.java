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

import com.bbdp.questionnaire.model.QuestionnaireModuleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

// Source: QuestionnaireModuleServer.java
@RestController
@RequestMapping(value = "/QuestionnaireModule")
public class QuestionnaireModuleController {

    @Autowired
    DataSource dataSource;

    // Original method: searchType
    @RequestMapping(value = "/searchType", method = RequestMethod.GET)
    public ArrayList searchType(@RequestParam String doctorID) throws SQLException {
        return QuestionnaireModuleServer.searchType(dataSource.getConnection(), doctorID);
    }

    // Original method: addTempStorageQuestion
    @RequestMapping(value = "/addTempStorageQuestion", method = RequestMethod.POST)
    public ArrayList addTempStorageQuestion(@RequestParam String doctorID) throws SQLException {
        return QuestionnaireModuleServer.addTempStorageQuestion(dataSource.getConnection(), doctorID);
    }

    // Original method: newQuestionnaire
    @RequestMapping(value = "/newQuestionnaire", method = RequestMethod.POST)
    public int newQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireName, @RequestParam String questionnaireType, @RequestParam String partArray, @RequestParam String partName, @RequestParam String scoring) throws SQLException {
        return QuestionnaireModuleServer.newQuestionnaire(dataSource.getConnection(), doctorID, questionnaireName, questionnaireType, partArray, partName, scoring);
    }

    // Original method: searchAllQuestionnaire
    @RequestMapping(value = "/searchAllQuestionnaire", method = RequestMethod.GET)
    public ArrayList searchAllQuestionnaire(@RequestParam String doctorID) throws SQLException {
        return QuestionnaireModuleServer.searchAllQuestionnaire(dataSource.getConnection(), doctorID);
    }

    // Original method: searchQuestionnaire
    @RequestMapping(value = "/searchQuestionnaire", method = RequestMethod.GET)
    public ArrayList searchQuestionnaire(@RequestParam String doctorID, @RequestParam String type) throws SQLException {
        return QuestionnaireModuleServer.searchQuestionnaire(dataSource.getConnection(), doctorID, type);
    }

    // Original method: getQuestionnaire
    @RequestMapping(value = "/getQuestionnaire", method = RequestMethod.GET)
    public String getQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID, @RequestParam String item) throws SQLException {
        return QuestionnaireModuleServer.getQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID, item);
    }

    // Original method: getQuestionList
    @RequestMapping(value = "/getQuestionList", method = RequestMethod.GET)
    public ArrayList getQuestionList(@RequestParam String doctorID, @RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireModuleServer.getQuestionList(dataSource.getConnection(), doctorID, questionnaireID);
    }

    // Original method: searchQuestion
    @RequestMapping(value = "/searchQuestion", method = RequestMethod.GET)
    public ArrayList searchQuestion(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        return QuestionnaireModuleServer.searchQuestion(dataSource.getConnection(), doctorID, questionID);
    }

    // Original method: updateQuestionnaire
    @RequestMapping(value = "/updateQuestionnaire", method = RequestMethod.POST)
    public int updateQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID, @RequestParam String questionnaireName, @RequestParam String questionnaireType, @RequestParam String partArray, @RequestParam String partName, @RequestParam String scoring, @RequestParam String medicalRecord) throws SQLException {
        return QuestionnaireModuleServer.updateQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID, questionnaireName, questionnaireType, partArray, partName, scoring, medicalRecord);
    }

    // Original method: allowUpdateQuestionnaire
    @RequestMapping(value = "/allowUpdateQuestionnaire", method = RequestMethod.GET)
    public String allowUpdateQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireModuleServer.allowUpdateQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID);
    }

    // Original method: searchSymptom
    @RequestMapping(value = "/searchSymptom", method = RequestMethod.GET)
    public ArrayList searchSymptom(@RequestParam String doctorID) throws SQLException {
        return QuestionnaireModuleServer.searchSymptom(dataSource.getConnection(), doctorID);
    }

    // Original method: addFirstVisitQuestionnaire
    @RequestMapping(value = "/addFirstVisitQuestionnaire", method = RequestMethod.POST)
    public int addFirstVisitQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID, @RequestParam String symptom) throws SQLException {
        return QuestionnaireModuleServer.addFirstVisitQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID, symptom);
    }

    // Original method: updateFirstVisitQuestionnaire
    @RequestMapping(value = "/updateFirstVisitQuestionnaire", method = RequestMethod.POST)
    public int updateFirstVisitQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID, @RequestParam String symptom) throws SQLException {
        return QuestionnaireModuleServer.updateFirstVisitQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID, symptom);
    }

    // Original method: deleteQuestionnaire
    @RequestMapping(value = "/deleteQuestionnaire", method = RequestMethod.POST)
    public int deleteQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireModuleServer.deleteQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID);
    }

    // Original method: getFirstVisitQuestionnaire
    @RequestMapping(value = "/getFirstVisitQuestionnaire", method = RequestMethod.GET)
    public ArrayList getFirstVisitQuestionnaire(@RequestParam String doctorID) throws SQLException {
        return QuestionnaireModuleServer.getFirstVisitQuestionnaire(dataSource.getConnection(), doctorID);
    }

    // Original method: removeFirstVisitQuestionnaire
    @RequestMapping(value = "/removeFirstVisitQuestionnaire", method = RequestMethod.POST)
    public int removeFirstVisitQuestionnaire(@RequestParam String doctorID, @RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireModuleServer.removeFirstVisitQuestionnaire(dataSource.getConnection(), doctorID, questionnaireID);
    }

    // Original method: searchQuestionMedicalRecord
    @RequestMapping(value = "/searchQuestionMedicalRecord", method = RequestMethod.GET)
    public ArrayList searchQuestionMedicalRecord(@RequestParam String doctorID, @RequestParam String questionID) throws SQLException {
        return QuestionnaireModuleServer.searchQuestionMedicalRecord(dataSource.getConnection(), doctorID, questionID);
    }

    // Original method: checkID
    @RequestMapping(value = "/checkID", method = RequestMethod.GET)
    public String checkID(@RequestParam String doctorID, @RequestParam String questionnaireID) throws SQLException {
        return QuestionnaireModuleServer.checkID(dataSource.getConnection(), doctorID, questionnaireID);
    }
}
