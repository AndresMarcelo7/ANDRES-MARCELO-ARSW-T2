package edu.eci.arsw.covidsearch.CoronavirusStatsCache;

import edu.eci.arsw.covidsearch.model.CountryStats;
import edu.eci.arsw.covidsearch.CoronavirusStatsCache.impl.Tuple;

public interface CacheCovid {
    void saveStatsinCache(String name,CountryStats country);

    Tuple<CountryStats, Long> getStatsStored(String name);


}
