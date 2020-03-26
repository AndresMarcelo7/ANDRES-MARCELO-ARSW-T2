package edu.eci.arsw.covidsearch.CoronavirusStatsController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat")
public class CovidSearchAPIController {

    @RequestMapping(value="/allCases",method= RequestMethod.GET)
    public String start() {
        return "index";
    }


}
