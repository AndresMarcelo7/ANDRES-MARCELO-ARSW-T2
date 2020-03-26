package edu.eci.arsw.covidsearch.CoronavirusStatsServices;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covidsearch.exception.CovidException;
import edu.eci.arsw.covidsearch.model.CountryStats;
import edu.eci.arsw.covidsearch.model.WorldStats;

/**
 * The interface Stats services covid.
 */
public interface StatsServicesCovid {
    /**
     * Gets all statistics.
     *
     * @return the all statistics
     * @throws UnirestException the unirest exception
     */
    public WorldStats getAllStatistics() throws UnirestException;

    /**
     * Gets statistics by country.
     *
     * @param country the country
     * @return the statistics by country
     * @throws UnirestException the unirest exception
     * @throws CovidException   the covid exception
     */
    public CountryStats getStatisticsByCountry(String country) throws UnirestException, CovidException;
}
