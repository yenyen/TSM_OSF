package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.LoginFailedException;
import ch.heigvd.skeleton.model.Application;
import ch.heigvd.skeleton.model.Badge;
import ch.heigvd.skeleton.model.Player;
import ch.heigvd.skeleton.services.crud.PlayersManagerLocal;
import ch.heigvd.skeleton.services.to.BadgesTOServiceLocal;
import ch.heigvd.skeleton.services.to.PlayersTOServiceLocal;
import ch.heigvd.skeleton.to.PublicBadgeTO;
import ch.heigvd.skeleton.to.PublicPlayerTO;
import ch.heigvd.skeleton.to.PublicPlayerWithBadgesTO;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("players")
public class PlayersResource extends AbstractResource{
    @EJB
    PlayersManagerLocal playersManager;

    @EJB
    PlayersTOServiceLocal playersTOService;
    
    @EJB
    BadgesTOServiceLocal badgesTOService;

    /**
     * Creates a new instance of EmployeesResource
     */
    public PlayersResource() {
    }

    /**
     * Creates a new Employee resource from the provided representation
     *
     * @return an instance of PublicEmployeeTO
     */
    @POST
    @Consumes({"application/json"})
    public Response createResource(PublicPlayerTO newPlayerTO) throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        
        Player newPlayer = new Player();
        playersTOService.updatePlayerEntity(newPlayer, newPlayerTO);
        newPlayer.setApplication(application);
        long newEmployeeId = playersManager.create(newPlayer);
        URI createdURI = context.getAbsolutePathBuilder().path(Long.toString(newEmployeeId)).build();
        return Response.created(createdURI).build();
    }

    /**
     * Retrieves a representation of a list of Employee resources
     *
     * @return an instance of PublicEmployeeTO
     */
    @GET
    @Produces({"application/json", "application/xml"})
    public List<PublicPlayerTO> getResourceList() throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);

        List<Player> players = playersManager.findAll(application.getId());
        List<PublicPlayerTO> result = new LinkedList<PublicPlayerTO>();
        for (Player player : players) {
            result.add(playersTOService.buildPublicPlayerTO(player));
        }
        return result;
    }

    /**
     * Retrieves representation of an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @GET
    @Path("{id}")
    @Produces({"application/json", "application/xml"})
    public PublicPlayerWithBadgesTO getResource(@PathParam("id") long id) 
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
		playersManager.setApplication(application);
		
        Player player = playersManager.findById(id);
        PublicBadgeTO badgesTO[] = new PublicBadgeTO[player.getBadges().size()];
        int i = 0;
        for(Badge badge : player.getBadges()) {
            badgesTO[i] = badgesTOService.buildPublicBadgeTO(badge);
            i++;
        }
        
        return playersTOService.buildPublicPlayerWithBadgesTO(player, badgesTO);
    }

    /**
     * Updates an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public Response Resource(@PathParam("id") long id, PublicPlayerTO updatedPlayerTO) 
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        
        Player playerToUpdate = playersManager.findById(id);
        if(playerToUpdate.getApplication() != application)
            throw new EntityNotFoundException();
        
        playersTOService.updatePlayerEntity(playerToUpdate, updatedPlayerTO);
        playersManager.update(playerToUpdate);
        return Response.ok().build();
    }

    /**
     * Deletes an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @DELETE
    @Path("{id}")
    public Response deleteResource(@PathParam("id") long id)
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        if(playersManager.findById(id).getApplication() != application)
            throw new EntityNotFoundException();
        
        playersManager.delete(id);
        return Response.ok().build();
    }

}
