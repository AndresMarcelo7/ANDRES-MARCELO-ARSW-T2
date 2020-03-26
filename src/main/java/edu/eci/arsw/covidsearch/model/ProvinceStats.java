package edu.eci.arsw.covidsearch.model;

/**
 * The type Province stats.
 */
public class ProvinceStats {

    private String province;
    private String city;
    private long confirmed;
    private long deaths;
    private long recovered;

    /**
     * Instantiates a new Province stats.
     *
     * @param province  the province
     * @param city      the city
     * @param confirmed the confirmed
     * @param deaths    the deaths
     * @param recovered the recovered
     */
    public ProvinceStats( String province,String  city, long confirmed, long deaths, long recovered) {
        this.city=city;
        this.province = province;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Gets confirmed cases .
     *
     * @return the confirmed cases
     */
    public long getConfirmed() {
        return confirmed;
    }

    /**
     * Sets confirmed cases .
     *
     * @param confirmed the confirmed cases
     */
    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Gets number of deaths.
     *
     * @return the deaths
     */
    public long getDeaths() {
        return deaths;
    }

    /**
     * Sets number of deaths.
     *
     * @param deaths the deaths
     */
    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    /**
     * Gets  people recovered.
     *
     * @return the recovered
     */
    public long getRecovered() {
        return recovered;
    }

    /**
     * Sets people recovered.
     *
     * @param recovered the recovered
     */
    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    /**
     * Gets province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets province.
     *
     * @param province the province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "ProvinceStats{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
