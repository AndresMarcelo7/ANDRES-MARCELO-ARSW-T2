package edu.eci.arsw.covidsearch.model;

import java.util.ArrayList;
import java.util.List;

public class Localization {
    List<Double> latlng = new ArrayList<Double>();

    public Localization(Object lat, Object lon){
        latlng.add((Double) lat);
        latlng.add((Double) lon);
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }
}
