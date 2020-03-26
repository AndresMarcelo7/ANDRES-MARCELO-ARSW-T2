package edu.eci.arsw.covidsearch.CoronavirusStatsController;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covidsearch.CoronavirusStatsServices.StatsServicesCovid;
import edu.eci.arsw.covidsearch.exception.CovidException;
import edu.eci.arsw.covidsearch.model.CountryStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class CovidSearchAPIController {

    @Autowired
    private StatsServicesCovid services;


    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity<?> getAllCases() throws UnirestException {
        return new ResponseEntity<>(services.getAllStatistics(), HttpStatus.ACCEPTED);
    }


    @RequestMapping(value="/Country/{country}")
    public ResponseEntity<?> getCasesByCountry(@PathVariable String country) {

        try {
            CountryStats stats = services.getStatisticsByCountry(country);
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (UnirestException | CovidException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
}
