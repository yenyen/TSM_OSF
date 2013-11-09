package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.LoginFailedException;
import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.services.crud.*;
import ch.heigvd.skeleton.services.to.*;
import ch.heigvd.skeleton.to.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("leaderboard")
public class LeaderboardResource extends AbstractResource {

    @EJB
    PlayersManagerLocal playersManager;
    

    @EJB
    LeaderboardTOServiceLocal leaderboardTOService;

    /**
     * Creates a new instance of EventsResource
     */
    public LeaderboardResource() {
    }

    /**
     * Retrieves a representation of the leaderboard
     *
     * @return an instance of PublicLeaderboardTO
     */
    @GET
    @Produces({"application/json", "application/xml"})
    public PublicLeaderboardTO getResourceList() 
            throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        List<Player> players = playersManager.findTopPlayers(application.getId(), 5);
        return leaderboardTOService.buildPublicLeaderboardTO("Top 5", "Top 5 players by points",  players);
    }

}
