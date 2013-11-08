/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author aurelien
 */
@ApplicationException(rollback = true)
public class LoginFailedException extends Exception {
    
}
