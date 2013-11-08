package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Event;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class EventsManager extends AbstractManager<Event> implements EventsManagerLocal {

        @EJB
        RulesManagerLocal rulesManager;
        
	@Override
	public Event newEntity(Event m) {
		return new Event(m);
	}

	@Override
	public Class<Event> getEntityClass() {
		return Event.class;
	}

	@Override
	public TypedQuery<Event> createNamedQuery(NamedQuery argv) {
		if(argv==NamedQuery.findAll)
			return createNamedQuery("findAllEvents") ;

		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
        
        @Override
	public long create(Event m) {
            try {
                rulesManager.notifyEvent(m);
                return super.create(m);
            } catch (EntityNotFoundException ex) {
                return -1;
            }
	}

}
