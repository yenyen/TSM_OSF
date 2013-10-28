/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.model.Application;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface ApplicationsManagerLocal extends AbstractManagerLocal<Application> {
}
