package ch.heigvd.skeleton.services.to;


import ch.heigvd.skeleton.model.Application;
import ch.heigvd.skeleton.to.PublicApplicationTO;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti
 */
@Local
public interface ApplicationsTOServiceLocal {
	
	/**
	 * This method builds a TO instance from a JPA entity instance. In this particular
	 * case, the only thing that we do is get rid of the salary property (which is
	 * available in the JPA entity but should not be communicated to clients).
	 * 
	 * @param source the JPA entity
	 * @return the TO
	 */
	public PublicApplicationTO buildPublicApplicationTO(Application source);
	
	/**
	 * This method updates an existing JPA entity by merging the state of the
	 * provided TO instance. We do not touch the salary property, but replace
	 * the other properties.
	 * @param existingEntity the existing entity that we want to update
	 * @param newState a TO that contains new state (subset of the entity state)
	 * @return the updated employee entity
	 */
	public void updateApplicationEntity(Application existingEntity, PublicApplicationTO newState);
	
}
