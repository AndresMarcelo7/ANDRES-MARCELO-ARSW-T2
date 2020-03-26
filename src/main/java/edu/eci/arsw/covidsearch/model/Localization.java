package edu.eci.arsw.covidsearch.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Localization.
 */
public class Localization {
    /**
     * The Latlng Array keeyps in memory the iformation of an ubication.
     */
    List<Double> latlng = new ArrayList<Double>();

    /**
     * Instantiates a new Localization.
     *
     * @param lat the latitude
     * @param lon the lonngitude
     */
    public Localization(Object lat, Object lon){
        latlng.add((Double) lat);
        latlng.add((Double) lon);
    }

    /**
     * Gets latlng.
     *
     * @return the latlng
     */
    public List<Double> getLatlng() {
        return latlng;
    }

    /**
     * Sets latlng.
     *
     * @param latlng the latlng Array
     */
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }
}
