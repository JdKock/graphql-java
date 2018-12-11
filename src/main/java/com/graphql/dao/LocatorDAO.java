package com.graphql.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.domain.Atm;
import com.graphql.domain.Office;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LocatorDAO {

    private static final String LOCATOR_API = "https://www.ing.nl/api/locator";

    public List<Office> getOffices() throws Exception {

        HttpURLConnection con = createConnection(LOCATOR_API + "/offices/");
        String response = getResponse(con);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Office> offices = mapper.readValue(response.toString().substring(5), new TypeReference<List<Office>>(){});

        return offices;
    }

    public Office getOffice(String pir) throws Exception {

        HttpURLConnection con = createConnection(LOCATOR_API + "/offices/pir/ + pir");
        String response = getResponse(con);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Office office = mapper.readValue(response.toString().substring(5), new TypeReference<Office>(){});

        return office;
    }

    public List<Atm> getAtms() throws Exception {

        HttpURLConnection con = createConnection(LOCATOR_API + "/atms/");
        String response = getResponse(con);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Atm> atms = mapper.readValue(response.toString().substring(5), new TypeReference<List<Atm>>(){});

        return atms;
    }

    private HttpURLConnection createConnection(String url) throws Exception {

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        String USER_AGENT = "Mozilla/5.0";
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type","application/json");
        con.addRequestProperty("Accept", "application/json");
        con.addRequestProperty("Connection", "close");

        return con;
    }

    private String getResponse(HttpURLConnection con) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
