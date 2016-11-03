package hello;


import com.ironyard.dto.FifaTeam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
//        FifaTeam team = restTemplate.getForObject("http://worldcup.sfg.io/teams/", FifaTeam.class);
//        log.info(team.toString());

        // do array of objects
        FifaTeam[] teams = restTemplate.getForObject("http://worldcup.sfg.io/teams/", FifaTeam[].class);
        log.info(teams.toString());

    }

}