/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.rest;
import ch.heigvd.skeleton.exceptions.InvalidOperationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author komanda.phanzu
 */
public class InvalidOperationExceptionMapper implements ExceptionMapper<InvalidOperationException> {

    @Override
    public Response toResponse(InvalidOperationException exception) {
            return Response.status(Response.Status.BAD_REQUEST ).entity(exception).build();
    }
	
}
