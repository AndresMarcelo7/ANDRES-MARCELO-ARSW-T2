package edu.eci.arsw.covidsearch.CoronavirusStatsCache;

import edu.eci.arsw.covidsearch.CoronavirusStatsCache.impl.Tuple;
import edu.eci.arsw.covidsearch.model.CountryStats;


public interface CacheCovid {
    void saveStatsinCache(String name,CountryStats country);

    Tuple<CountryStats, Long> getStatsStored(String name);


}
