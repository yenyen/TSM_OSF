package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("applications")
public class EventsResource {

    @Context
    private UriInfo context;

    @EJB
    EventsManagerLocal applicationsManager;

    @EJB
    EventsTOServiceLocal applicationsTOService;

    /**
     * Creates a new instance of EventsResource
     */
    public EventsResource() {
    }

    /**
     * Creates a new Event resource from the provided representation
     *
     * @param newTO
     * @return an instance of PublicEventTO
     */
    @POST
    @Consumes({"application/json"})
    public Response createResource(PublicEventTO newTO) {
        Event application = new Event();
        applicationsTOService.updateEventEntity(application, newTO);
        long newEventId = applicationsManager.create(application);
        URI createdURI = context.getAbsolutePathBuilder().path(Long.toString(newEventId)).build();
        return Response.created(createdURI).build();
    }

    /**
     * Retrieves a representation of a list of Event resources
     *
     * @return an instance of PublicEventTO
     */
    @GET
    @Produces({"application/json", "application/xml"})
    public List<PublicEventTO> getResourceList() {
        List<Event> applications = applicationsManager.findAll();
        List<PublicEventTO> result = new LinkedList<PublicEventTO>();
        for (Event application : applications) {
            result.add(applicationsTOService.buildPublicEventTO(application));
        }
        return result;
    }

    /**
     * Retrieves representation of an Event resource
     *
     * @return an instance of PublicEventTO
     */
    @GET
    @Path("{id}")
    @Produces({"application/json", "application/xml"})
    public PublicEventTO getResource(@PathParam("id") long id) throws EntityNotFoundException {
        Event application = applicationsManager.findById(id);
        PublicEventTO applicationTO = applicationsTOService.buildPublicEventTO(application);
        return applicationTO;
    }


    /**
     * Deletes an Event resource
     *
     * @return an instance of PublicEventTO
     */
    @DELETE
    @Path("{id}")
    public Response deleteResource(@PathParam("id") long id) throws EntityNotFoundException {
        applicationsManager.delete(id);
        return Response.ok().build();
    }

}
