package edu.eci.arsw.covidsearch.model;

import java.util.ArrayList;
import java.util.List;

public class CountryStats {
    private String countryName;
    private int totalDeaths;
    private int totalConfirmed;
    private int totalRecovered;
    private List<ProvinceStats> provinceStatsList;
    private Localization localization;

    public CountryStats(String countryName) {
        this.countryName = countryName;
        this.provinceStatsList = new ArrayList<ProvinceStats>();
        this.totalDeaths = 0;
        this.totalConfirmed = 0;
        this.totalRecovered = 0;
        this.localization= new Localization(0.0,0.0);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public List<ProvinceStats> getProvinceStatsList() {
        return provinceStatsList;
    }

    public void setProvinceStatsList(List<ProvinceStats> provinceStatsList) {
        this.provinceStatsList = provinceStatsList;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public void addProvince(ProvinceStats province){
        provinceStatsList.add(province);
        this.totalRecovered+=province.getRecovered();
        this.totalConfirmed+=province.getConfirmed();
        this.totalDeaths+=province.getDeaths();
    }

    @Override
    public String toString() {
        return "CountryStats{" +
                "countryName='" + countryName + '\'' +
                ", totalDeaths=" + totalDeaths +
                ", totalConfirmed=" + totalConfirmed +
                ", totalRecovered=" + totalRecovered +
                ", provinceStatsList=" + provinceStatsList +
                ", localization=" + localization +
                '}';
    }
}
