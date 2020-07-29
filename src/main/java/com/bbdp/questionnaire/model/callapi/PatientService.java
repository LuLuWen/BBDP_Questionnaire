package com.bbdp.questionnaire.model.callapi;

import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class PatientService {
    public static String getPatientName(String patientID) {
        String uri = "http://140.121.197.130:8004/BBDPPatient/PatientAggregateAPI?operation=getPatientNameById&patientID="+patientID;
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate.getForObject(uri, String.class);
    }
}
