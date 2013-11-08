/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author aurelien
 */
@Provider
public class LoginFailedExceptionMapper implements ExceptionMapper<LoginFailedException> {
    @Override
    public Response toResponse(LoginFailedException exception) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
