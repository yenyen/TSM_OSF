/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.AbstractModel;
import ch.heigvd.skeleton.model.Player;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface AbstractManagerLocal<T extends AbstractModel> {

	long create(T player);

	void update(T newState) throws EntityNotFoundException;

	void delete(long id) throws EntityNotFoundException;

	T findById(long id) throws EntityNotFoundException;

	List<T> findAll();
        
        List<T> findAll(long applicationId);
}
