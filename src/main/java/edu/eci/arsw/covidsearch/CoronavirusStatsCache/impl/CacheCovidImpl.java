package edu.eci.arsw.covidsearch.CoronavirusStatsCache.impl;

import edu.eci.arsw.covidsearch.CoronavirusStatsCache.CacheCovid;
import edu.eci.arsw.covidsearch.model.CountryStats;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Cache covid.
 */
@Service
public class CacheCovidImpl implements CacheCovid {

    private ConcurrentHashMap<String,Tuple<CountryStats,Long>> cache;

    /**
     * Instantiates a new Cache Memory.
     */
    public CacheCovidImpl() {
        this.cache= new ConcurrentHashMap<String,Tuple<CountryStats,Long>>();
    }

    @Override
    public void saveStatsinCache(String name, CountryStats country) {
        cache.put(name,new Tuple<CountryStats,Long>(country,System.nanoTime()));
    }

    @Override
    public Tuple<CountryStats, Long> getStatsStored(String name) {
        return cache.get(name);
    }
}
