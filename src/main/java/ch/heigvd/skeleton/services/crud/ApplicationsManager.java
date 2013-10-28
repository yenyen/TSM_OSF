package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Application;
import ch.heigvd.skeleton.model.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class ApplicationsManager extends AbstractManager<Application> implements ApplicationsManagerLocal {

	@Override
	public Application newEntity(Application m) {
		return new Application(m);
	}

	@Override
	public Class<Application> getEntityClass() {
		return Application.class;
	}

	@Override
	public TypedQuery<Application> createNamedQuery(NamedQuery argv) {
		if(argv==NamedQuery.findAll)
			return createNamedQuery("findAllApplications") ;
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
