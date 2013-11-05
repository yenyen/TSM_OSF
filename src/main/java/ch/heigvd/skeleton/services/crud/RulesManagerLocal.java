/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Event;
import ch.heigvd.skeleton.model.Rule;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface RulesManagerLocal extends AbstractManagerLocal<Rule> {
    public void notifyEvent(Event event) throws EntityNotFoundException ;
}
