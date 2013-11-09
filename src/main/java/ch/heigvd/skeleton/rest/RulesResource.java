package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.InvalidOperationException;
import ch.heigvd.skeleton.exceptions.LoginFailedException;
import ch.heigvd.skeleton.model.Application;
import ch.heigvd.skeleton.model.Rule;
import ch.heigvd.skeleton.services.crud.RulesManagerLocal;
import ch.heigvd.skeleton.services.to.RulesTOServiceLocal;
import ch.heigvd.skeleton.to.PublicRuleTO;
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
@Path("rules")
public class RulesResource extends AbstractResource {
    @EJB
    RulesManagerLocal rulesManager;

    @EJB
    RulesTOServiceLocal rulesTOService;

    /**
     * Creates a new instance of RulesResource
     */
    public RulesResource() {
    }

    /**
     * Creates a new Rule resource from the provided representation
     *
     * @return an instance of PublicRuleTO
     */
    @POST
    @Consumes({"application/json"})
    public Response createResource(PublicRuleTO newRuleTO)
            throws LoginFailedException, InvalidOperationException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        Rule newRule = new Rule();
        rulesTOService.updateRuleEntity(newRule, newRuleTO);
        newRule.setApplication(application);
        long newRuleId = rulesManager.create(newRule);
        URI createdURI = context.getAbsolutePathBuilder().path(Long.toString(newRuleId)).build();
        return Response.created(createdURI).build();
    }

    /**
     * Retrieves a representation of a list of Rule resources
     *
     * @return an instance of PublicRuleTO
     */
    @GET
    @Produces({"application/json", "application/xml"})
    public List<PublicRuleTO> getResourceList() 
            throws LoginFailedException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        List<Rule> rules = rulesManager.findAll(application.getId());
        List<PublicRuleTO> result = new LinkedList<PublicRuleTO>();
        for (Rule rule : rules) {
            result.add(rulesTOService.buildPublicRuleTO(rule));
        }
        return result;
    }

    /**
     * Retrieves representation of an Rule resource
     *
     * @return an instance of PublicRuleTO
     */
    @GET
    @Path("{id}")
    @Produces({"application/json", "application/xml"})
    public PublicRuleTO getResource(@PathParam("id") long id)
            throws EntityNotFoundException, LoginFailedException, InvalidOperationException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        Rule rule = rulesManager.findById(id);
        if(rule.getApplication() != application)
            throw new EntityNotFoundException();
        
        PublicRuleTO ruleTO = rulesTOService.buildPublicRuleTO(rule);
        return ruleTO;
    }

    /**
     * Updates an Rule resource
     *
     * @return an instance of PublicRuleTO
     */
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public Response Resource(PublicRuleTO updatedRuleTO, @PathParam("id") long id) 
            throws EntityNotFoundException, LoginFailedException, InvalidOperationException {
        Application application = applicationsManager.login(apiKey, apiSecret);
        Rule ruleToUpdate = rulesManager.findById(id);
        if(ruleToUpdate.getApplication() != application)
            throw new EntityNotFoundException();
            
        rulesTOService.updateRuleEntity(ruleToUpdate, updatedRuleTO);
        rulesManager.update(ruleToUpdate);
        return Response.ok().build();
    }

    /**
     * Deletes an Rule resource
     *
     * @return an instance of PublicRuleTO
     */
    @DELETE
    @Path("{id}")
    public Response deleteResource(@PathParam("id") long id) 
            throws EntityNotFoundException, LoginFailedException, InvalidOperationException{
        Application application = applicationsManager.login(apiKey, apiSecret);
        if(rulesManager.findById(id).getApplication() != application)
            throw new EntityNotFoundException();
        
        rulesManager.delete(id);
        return Response.ok().build();
    }

}
