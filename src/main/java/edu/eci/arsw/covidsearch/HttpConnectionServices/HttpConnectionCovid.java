package edu.eci.arsw.covidsearch.HttpConnectionServices;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public interface HttpConnectionCovid {

    public JSONObject getAllStatistics() throws UnirestException;

    public JSONObject getStatisticsOfCountry(String country) throws UnirestException;

    public JSONArray getCordsOfCountry(String Country) throws UnirestException;

}
