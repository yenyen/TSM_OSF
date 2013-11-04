package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.to.*;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti
 */
@Local
public interface EventsTOServiceLocal {
	
	/**
	 * This method builds a TO instance from a JPA entity instance. In this particular
	 * case, the only thing that we do is get rid of the salary property (which is
	 * available in the JPA entity but should not be communicated to clients).
	 * 
	 * @param source the JPA entity
	 * @return the TO
	 */
	public PublicEventTO buildPublicEventTO(Event source);
        
        public void updateEventEntity(Event existingEntity, PublicEventTO newState);
}
