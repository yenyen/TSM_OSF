package ch.heigvd.skeleton.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author Olivier Liechti
 */
@ApplicationException(rollback = true)
public class EntityNotFoundException extends Exception {
	
	

}
