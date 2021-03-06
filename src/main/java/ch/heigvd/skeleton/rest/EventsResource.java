package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.InvalidOperationException;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("events")
public class EventsResource extends AbstractResource {
        
    @EJB
    EventsManagerLocal eventsManager;
    
    @EJB
    EventsTOServiceLocal eventsTOService;

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
    public Response createResource(PublicEventTO newTO)
            throws LoginFailedException, InvalidOperationException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        
        Event event = new Event();
        eventsTOService.updateEventEntity(event, newTO);
        event.setApplication(application);
        
        long newEventId = eventsManager.create(event);
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
    public List<PublicEventTO> getResourceList() 
            throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        List<Event> events = eventsManager.findAll(application.getId());
        List<PublicEventTO> result = new LinkedList<PublicEventTO>();
        for (Event event : events) {
            result.add(eventsTOService.buildPublicEventTO(event));
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
    public PublicEventTO getResource(@PathParam("id") long id) 
            throws EntityNotFoundException, LoginFailedException, InvalidOperationException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        Event event = eventsManager.findById(id);
        
        if(event.getApplication() != application)
            throw new EntityNotFoundException();
            
        PublicEventTO eventTO = eventsTOService.buildPublicEventTO(event);
        return eventTO;
    }
}
