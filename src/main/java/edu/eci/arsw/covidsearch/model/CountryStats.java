package edu.eci.arsw.covidsearch.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Country stats.
 */
public class CountryStats {
    private String countryName;
    private int totalDeaths;
    private int totalConfirmed;
    private int totalRecovered;
    private List<ProvinceStats> provinceStatsList;
    private Localization localization;

    /**
     * Instantiates a new Country stats.
     *
     * @param countryName the country name
     */
    public CountryStats(String countryName) {
        this.countryName = countryName;
        this.provinceStatsList = new ArrayList<ProvinceStats>();
        this.totalDeaths = 0;
        this.totalConfirmed = 0;
        this.totalRecovered = 0;
        this.localization= new Localization(0.0,0.0);
    }

    /**
     * Gets country name.
     *
     * @return the country name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets country name.
     *
     * @param countryName the country name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Gets total deaths.
     *
     * @return the total deaths
     */
    public int getTotalDeaths() {
        return totalDeaths;
    }

    /**
     * Sets total deaths.
     *
     * @param totalDeaths the total deaths
     */
    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    /**
     * Gets total of confirmed cases .
     *
     * @return the total confirmed cases
     */
    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    /**
     * Sets total confirmed cases .
     *
     * @param totalConfirmed the total confirmed
     */
    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    /**
     * Gets total recovered people.
     *
     * @return the total recovered
     */
    public int getTotalRecovered() {
        return totalRecovered;
    }

    /**
     * Sets total recovered people.
     *
     * @param totalRecovered the total recovered people
     */
    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    /**
     * Gets province stats list of this country.
     *
     * @return the province stats list
     */
    public List<ProvinceStats> getProvinceStatsList() {
        return provinceStatsList;
    }

    /**
     * Sets province stats list of this country.
     *
     * @param provinceStatsList the province stats list
     */
    public void setProvinceStatsList(List<ProvinceStats> provinceStatsList) {
        this.provinceStatsList = provinceStatsList;
    }

    /**
     * Gets localization of this country.
     *
     * @return the localization
     */
    public Localization getLocalization() {
        return localization;
    }

    /**
     * Sets localization.
     *
     * @param localization the localization
     */
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    /**
     * Add province.
     *
     * @param province the province
     */
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
