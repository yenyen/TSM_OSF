/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.services.crud.ApplicationsManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author komanda.phanzu
 */
public class AbstractResource {
	@HeaderParam(value = "apiKey")
	public String apiKey;
	@HeaderParam(value = "apiSecret")
	public String apiSecret;

    @Context
    public UriInfo context;
    
    @EJB
    public ApplicationsManagerLocal applicationsManager;
    
	
}
