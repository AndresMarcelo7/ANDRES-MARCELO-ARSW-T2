package edu.eci.arsw.covidsearch.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The type World stats.
 */
@Component
public class WorldStats {
    private int confirmed;
    private int recovered;
    private int dead;
    private ArrayList<CountryStats> countries;

    /**
     * Instantiates a new World stats.
     */
    public WorldStats(){
        this.confirmed=0;
        this.recovered=0;
        this.dead=0;
        this.countries=new ArrayList<CountryStats>();
    }

    /**
     * Gets confirmed cases .
     *
     * @return the confirmed
     */
    public int getConfirmed() {
        return confirmed;
    }

    /**
     * Sets confirmed cases .
     *
     * @param confirmed the confirmed
     */
    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Gets recovered people cases.
     *
     * @return the recovered people cases
     */
    public int getRecovered() {
        return recovered;
    }

    /**
     * Sets recovered people cases.
     *
     * @param recovered the recovered people cases
     */
    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    /**
     * Gets number of deads.
     *
     * @return the number of deads
     */
    public int getDead() {
        return dead;
    }

    /**
     * Sets number of deads.
     *
     * @param dead the dead
     */
    public void setDead(int dead) {
        this.dead = dead;
    }

    /**
     * Gets countries.
     *
     * @return the countries
     */
    public ArrayList<CountryStats> getCountries() {
        return countries;
    }

    /**
     * Sets countries.
     *
     * @param countries the countries
     */
    public void setCountries(ArrayList<CountryStats> countries) {
        this.countries = countries;
    }

    /**
     * Gets country by name.
     *
     * @param name the name
     * @return the country by name
     */
    public CountryStats getCountryByName(String name) {
        for (CountryStats c: countries){
            if(c.getCountryName().equals(name)){
                return c;
            }
        }
        return null;
    }

    /**
     * Order countries in from deathts, then cases confirmed, then recover cases.
     */
    public void orderCountries(){
        Collections.sort(countries, Comparator.comparing(CountryStats::getTotalDeaths)
                .thenComparing(CountryStats::getTotalConfirmed)
                .thenComparing(CountryStats::getTotalRecovered).reversed());
    }

    /**
     * Add province.
     *
     * @param country  the country
     * @param province the province
     */
    public void addProvince(String country, ProvinceStats province){
        CountryStats p = getCountryByName(country);
        if (p== null){
            p = new CountryStats(country);
            countries.add(p);
        }
        p.addProvince(province);
        this.confirmed+=province.getConfirmed();
        this.dead+=province.getDeaths();
        this.recovered+=province.getRecovered();
    }




}
