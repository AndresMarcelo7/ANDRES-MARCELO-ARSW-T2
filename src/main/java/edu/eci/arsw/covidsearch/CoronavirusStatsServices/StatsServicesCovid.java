package edu.eci.arsw.covidsearch.CoronavirusStatsServices;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covidsearch.exception.CovidException;
import edu.eci.arsw.covidsearch.model.CountryStats;
import edu.eci.arsw.covidsearch.model.WorldStats;

public interface StatsServicesCovid {
    public WorldStats getAllStatistics() throws UnirestException;
    public CountryStats getStatisticsByCountry(String country) throws UnirestException, CovidException;
}
