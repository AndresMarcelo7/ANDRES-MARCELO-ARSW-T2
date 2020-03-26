package edu.eci.arsw.covidsearch.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Component
public class WorldStats {
    private int confirmed;
    private int recovered;
    private int dead;
    private ArrayList<CountryStats> countries;

    public WorldStats(){
        this.confirmed=0;
        this.recovered=0;
        this.dead=0;
        this.countries=new ArrayList<CountryStats>();
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public ArrayList<CountryStats> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<CountryStats> countries) {
        this.countries = countries;
    }

    public CountryStats getCountryByName(String name) {
        for (CountryStats c: countries){
            if(c.getCountryName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public void orderCountries(){
        Collections.sort(countries, Comparator.comparing(CountryStats::getTotalDeaths)
                .thenComparing(CountryStats::getTotalConfirmed)
                .thenComparing(CountryStats::getTotalRecovered).reversed());
    }

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
