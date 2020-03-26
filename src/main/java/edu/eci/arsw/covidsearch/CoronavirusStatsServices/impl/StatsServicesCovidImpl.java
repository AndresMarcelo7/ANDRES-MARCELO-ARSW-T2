package edu.eci.arsw.covidsearch.CoronavirusStatsServices.impl;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covidsearch.CoronavirusStatsCache.CacheCovid;
import edu.eci.arsw.covidsearch.CoronavirusStatsCache.impl.Tuple;
import edu.eci.arsw.covidsearch.CoronavirusStatsServices.StatsServicesCovid;
import edu.eci.arsw.covidsearch.HttpConnectionServices.HttpConnectionCovid;
import edu.eci.arsw.covidsearch.exception.CovidException;
import edu.eci.arsw.covidsearch.model.CountryStats;
import edu.eci.arsw.covidsearch.model.Localization;
import edu.eci.arsw.covidsearch.model.ProvinceStats;
import edu.eci.arsw.covidsearch.model.WorldStats;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * The type Stats services covid.
 */
@Service
public class StatsServicesCovidImpl implements StatsServicesCovid {
    /**
     * The Httpservice.
     */
    @Autowired
    HttpConnectionCovid httpService;

    /**
     * The Cache.
     */
    @Autowired
    CacheCovid cacheCovid;


    @Override
    public WorldStats getAllStatistics() throws UnirestException {

        WorldStats data = new WorldStats();
        JSONObject info = httpService.getAllStatistics();
        JSONArray arr = info.getJSONArray("covid19Stats");
        for(int i=0;i<arr.length();i++) {
            JSONObject object = arr.getJSONObject(i);
            data.addProvince(object.getString("country"),
                    new ProvinceStats(object.getString("province"),
                            object.getString("city"),
                            object.getInt("confirmed"),
                            object.getInt("deaths"),
                            object.getInt("recovered")));
        }
        data.orderCountries();
        return data;
    }

    @Override
    public CountryStats getStatisticsByCountry(String country) throws UnirestException, CovidException {
        Tuple<CountryStats,Long> availableCache = null;
        availableCache = cacheCovid.getStatsStored(country);
        if(availableCache==null){
            CountryStats ct = requestAndSave(country);
            System.out.println("ESTOY ENTRANDO AQUI HPTA");
            return ct;
        }
        else{
            System.out.println("ESTOY ENTRANDO AQUI CATREHPTA");
            Long savedTime = availableCache.getElem2();
            Long timeUntilNow = System.nanoTime() - savedTime;
            //Toca convertir a MINUTOS
            Long convertedTime = TimeUnit.MINUTES.convert(timeUntilNow,TimeUnit.NANOSECONDS);
            if (convertedTime>5){
                CountryStats ct = requestAndSave(country);
                return ct;
            }
        }

        return availableCache.getElem1();
    }

    private CountryStats requestAndSave(String country) throws UnirestException {
        CountryStats ct =  getAllStatistics().getCountryByName(country);
        JSONArray cords = httpService.getCordsOfCountry(country);
        ct.setLocalization(new Localization(cords.getDouble(0),cords.getDouble(1)));
        cacheCovid.saveStatsinCache(country,ct);
        return ct;
    }
}
