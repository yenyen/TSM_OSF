package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.LoginFailedException;
import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.services.crud.*;
import ch.heigvd.skeleton.services.to.*;
import ch.heigvd.skeleton.to.*;
import java.net.URI;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("applications")
public class ApplicationsResource  {

    @Context
    private UriInfo context;
    
    @EJB
    ApplicationsManagerLocal applicationsManager;

    @EJB
    ApplicationsTOServiceLocal applicationsTOService;

    /**
     * Creates a new instance of EmployeesResource
     */
    public ApplicationsResource() {
    }

    /**
     * Creates a new Employee resource from the provided representation
     *
     * @param newTO
     * @return an instance of PublicEmployeeTO
     */
    @POST
    @Consumes({"application/json"})
    public Response createResource(PublicApplicationTO newTO) {
        Application application = new Application();
        applicationsTOService.updateApplicationEntity(application, newTO);
        long newApplicationId = applicationsManager.create(application);
        URI createdURI = context.getAbsolutePathBuilder().path(Long.toString(newApplicationId)).build();
        return Response.created(createdURI).build();
    }


    /**
     * Retrieves representation of an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @GET
    @Path("{id}")
    @Produces({"application/json", "application/xml"})
    public PublicApplicationTO getResource(@PathParam("id") long id, 
            @HeaderParam(value = "apiKey") String apiKey, 
            @HeaderParam(value = "apiSecret") String apiSecret) 
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        if(application.getId() != id)
            throw new EntityNotFoundException();
            
        PublicApplicationTO applicationTO = applicationsTOService.buildPublicApplicationTO(application);
        return applicationTO;
    }

    /**
     * Updates an Employee resource
     *
	 * @param updatedApplicationTO
	 * @param id
     * @return an instance of PublicEmployeeTO
     */
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public Response Resource(PublicApplicationTO updatedApplicationTO, 
            @PathParam("id") long id,
            @HeaderParam(value = "apiKey") String apiKey, 
            @HeaderParam(value = "apiSecret") String apiSecret) 
            throws EntityNotFoundException, LoginFailedException {
        Application applicationToUpdate = applicationsManager.login(apiKey, apiSecret);

        if(id != applicationToUpdate.getId())
            throw new EntityNotFoundException();
            
        applicationsTOService.updateApplicationEntity(applicationToUpdate, updatedApplicationTO);
        applicationsManager.update(applicationToUpdate);
        return Response.ok().build();
    }

    /**
     * Deletes an Employee resource
     *
     * @return an instance of PublicEmployeeTO
     */
    @DELETE
    @Path("{id}")
    public Response deleteResource(@PathParam("id") long id,
            @HeaderParam(value = "apiKey") String apiKey, 
            @HeaderParam(value = "apiSecret") String apiSecret) 
            throws EntityNotFoundException, LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        if(id != application.getId())
            throw new EntityNotFoundException();
        
        applicationsManager.delete(id);
        return Response.ok().build();
    }

}
