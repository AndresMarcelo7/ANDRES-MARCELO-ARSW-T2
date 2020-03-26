package edu.eci.arsw.covidsearch.CoronavirusStatsController;


@RestController
@RequestMapping("/stat")
public class CovidSearchAPIController {

    @RequestMapping(value="/allCases",method=RequestMethod.GET)
    public String start() {
        return "index";
    }


}
