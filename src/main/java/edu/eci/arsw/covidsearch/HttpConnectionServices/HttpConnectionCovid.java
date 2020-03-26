package edu.eci.arsw.covidsearch.HttpConnectionServices;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The interface Http connection covid.
 */
public interface HttpConnectionCovid {

    /**
     * Gets all statistics from the api.
     *
     * @return the all statistics
     * @throws UnirestException the unirest exception
     */
    public JSONObject getAllStatistics() throws UnirestException;

    /**
     * Gets statistics of country by its name from the api .
     *
     * @param country the country
     * @return the statistics of country
     * @throws UnirestException the unirest exception
     */
    public JSONObject getStatisticsOfCountry(String country) throws UnirestException;

    /**
     * Gets cords of any country.
     *
     * @param Country the country
     * @return the cords of the country
     * @throws UnirestException the unirest exception
     */
    public JSONArray getCordsOfCountry(String Country) throws UnirestException;

}
