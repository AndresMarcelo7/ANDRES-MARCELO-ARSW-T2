package edu.eci.arsw.covidsearch.HttpConnectionServices.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covidsearch.HttpConnectionServices.HttpConnectionCovid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * The type Http connection covid.
 */
@Service
public class HttpConnectionCovidImpl implements HttpConnectionCovid {
    @Override
    public JSONObject getAllStatistics() {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "d434511647msh60dd9885f328ee6p143082jsnb260883bd254")
                    .asString();
            return new JSONObject(response.getBody()).getJSONObject("data");
        } catch (UnirestException e) {
            return null;
        }

    }

    @Override
    public JSONObject getStatisticsOfCountry(String country) {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "d434511647msh60dd9885f328ee6p143082jsnb260883bd254")
                    .asString();
            return new JSONObject(response.getBody()).getJSONObject("data");
        } catch (UnirestException e) {
            return null;
        }

    }

    @Override
    public JSONArray getCordsOfCountry(String country) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://restcountries-v1.p.rapidapi.com/name/"+country)
                .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "d434511647msh60dd9885f328ee6p143082jsnb260883bd254")
                .asString();
        JSONObject jarray = new JSONArray(response.getBody()).getJSONObject(0);
        JSONArray rta = jarray.getJSONArray("latlng");
        return rta;
    }

}
