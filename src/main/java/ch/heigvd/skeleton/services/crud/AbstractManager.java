package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.exceptions.InvalidOperationException;
import ch.heigvd.skeleton.model.AbstractModel;
import ch.heigvd.skeleton.model.Application;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * @author Olivier Liechti
 * @param <T>
 */
public abstract class AbstractManager<T extends AbstractModel> implements AbstractManagerLocal<T> {
	
	Logger logger=Logger.getLogger(getClass().getName());
	public enum NamedQuery{
		findAll,
                findAllOrderByPoints, 
                findByType,
                findByKeyAndSecret,
                findByKey
	}

	@PersistenceContext(unitName = "ch.heigvd_Skeleton_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	Application currentApplication=null;
	@Override
	public void setApplication(Application app) {
		currentApplication=app;
	}

	

	
	
	public abstract T newEntity(T m);
	public abstract Class<T> getEntityClass();
	public abstract TypedQuery<T> createNamedQuery(NamedQuery argv);
	

	public TypedQuery<T> createNamedQuery(String query){
		return em.createNamedQuery(query, getEntityClass());
	}
	
	protected EntityManager entityManager(){ return em;}
	@Override
	public long create(T m)throws InvalidOperationException {
		T o = newEntity(m);
		em.persist(o);
		return o.getId();
	}

	
	@Override
	public void update(T m) throws EntityNotFoundException, InvalidOperationException {
		findById(m.getId()); //A tester
		em.merge(m);
	}

	@Override
	public void delete(long id) throws EntityNotFoundException, InvalidOperationException {
		em.remove(findById(id));
	}

	@Override
	public T findById(long id) throws EntityNotFoundException, InvalidOperationException {
		T dr = em.find(getEntityClass(), id);
		if (dr == null) {
			throw new EntityNotFoundException();
		}
		return dr;
	}

	@Override
	public List<T> findAll() {
		List l = createNamedQuery(NamedQuery.findAll).getResultList();
		return l;
	}
        
        @Override
	public List<T> findAll(long applicationId) {
		List l = createNamedQuery(NamedQuery.findAll)
                        .setParameter("applicationId", applicationId)
                        .getResultList();
		return l;
	}
}
