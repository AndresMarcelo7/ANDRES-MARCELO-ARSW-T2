package edu.eci.arsw.covidsearch.CoronavirusStatsCache;

import edu.eci.arsw.covidsearch.CoronavirusStatsCache.impl.Tuple;
import edu.eci.arsw.covidsearch.model.CountryStats;


/**
 * The interface Cache covid.
 */
public interface CacheCovid {
    /**
     * Save stats in cache.
     *
     * @param name    the name
     * @param country the country
     */
    void saveStatsinCache(String name,CountryStats country);

    /**
     * Gets all the  stats stored. with the time in memory Condition (5s)
     *
     * @param name the name
     * @return the stats stored
     */
    Tuple<CountryStats, Long> getStatsStored(String name);


}
