/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.InvalidOperationException;
import ch.heigvd.skeleton.model.AbstractModel;
import ch.heigvd.skeleton.model.Application;
import ch.heigvd.skeleton.model.Player;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface AbstractManagerLocal<T extends AbstractModel> {

	void setApplication(Application app);
	long create(T player)throws InvalidOperationException;

	void update(T newState) throws EntityNotFoundException, InvalidOperationException;

	void delete(long id) throws EntityNotFoundException, InvalidOperationException;

	T findById(long id) throws EntityNotFoundException, InvalidOperationException;

	List<T> findAll();
        
        List<T> findAll(long applicationId);
}
