package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.LoginFailedException;
import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.services.crud.*;
import ch.heigvd.skeleton.services.to.*;
import ch.heigvd.skeleton.to.*;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("applications/{apiKey}/{apiSecret}/badges")
public class BadgesResource {

    @Context
    private UriInfo context;

    @EJB
    ApplicationsManagerLocal applicationsManager;
    
    @EJB
    BadgesManagerLocal badgesManager;

    @EJB
    BadgesTOServiceLocal badgesTOService;

    /**
     * Creates a new instance of EmployeesResource
     */
    public BadgesResource() {
    }

    /**
     * Creates a new Employee resource from the provided representation
     *
     * @param newBadgeTO
     * @return an instance of PublicEmployeeTO
     */
    @POST
    @Consumes({"application/json"})
    public Response createResource(PublicBadgeTO newBadgeTO, @PathParam("apiKey") String apiKey, @PathParam("apiSecret") String apiSecret) 
            throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        
        Badge badge = new Badge();
        badgesTOService.updateBadgeEntity(badge, newBadgeTO);
        badge.setApplication(application);
        long newEmployeeId = badgesManager.create(badge);
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
    public List<PublicBadgeTO> getResourceList(@PathParam("apiKey") String apiKey, @PathParam("apiSecret") String apiSecret) 
            throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        List<Badge> badges = badgesManager.findAll(application.getId());
        List<PublicBadgeTO> result = new LinkedList<PublicBadgeTO>();
        for (Badge badge : badges) {
            result.add(badgesTOService.buildPublicBadgeTO(badge));
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
    public PublicBadgeTO getResource(@PathParam("id") long id, @PathParam("apiKey") String apiKey, @PathParam("apiSecret") String apiSecret) 
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        Badge badge = badgesManager.findById(id);
        
        if(badge.getApplication() != application)
            throw new EntityNotFoundException(); 
                
        PublicBadgeTO badgeTO = badgesTOService.buildPublicBadgeTO(badge);
        return badgeTO;
    }

    /**
     * Updates an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public Response Resource(PublicBadgeTO updatedBadgeTO, @PathParam("id") long id, 
            @PathParam("apiKey") String apiKey, @PathParam("apiSecret") String apiSecret) 
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        Badge badgeToUpdate = badgesManager.findById(id);
        
        if(badgeToUpdate.getApplication() != application)
            throw new EntityNotFoundException();
        
        badgesTOService.updateBadgeEntity(badgeToUpdate, updatedBadgeTO);
        badgesManager.update(badgeToUpdate);
        return Response.ok().build();
    }

    /**
     * Deletes an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @DELETE
    @Path("{id}")
    public Response deleteResource(@PathParam("id") long id, @PathParam("apiKey") String apiKey, @PathParam("apiSecret") String apiSecret)
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        if(badgesManager.findById(id).getApplication() != application)
            throw new EntityNotFoundException();
        
        badgesManager.delete(id);
        return Response.ok().build();
    }

}
