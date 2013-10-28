package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class PlayersManager implements PlayersManagerLocal {

	@PersistenceContext(unitName = "ch.heigvd_Skeleton_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	@Override
	public long create(Player player) {
		Player newEmployee = new Player(player);
		em.persist(newEmployee);
		return newEmployee.getId();
	}

	
	@Override
	public void update(Player newState) throws EntityNotFoundException {
		findById(newState.getId()); //A tester
		em.merge(newState);
	}

	@Override
	public void delete(long id) throws EntityNotFoundException {
		em.remove(findById(id));
	}

	@Override
	public Player findById(long id) throws EntityNotFoundException {
		Player player = em.find(Player.class, id);
		if (player == null) {
			throw new EntityNotFoundException();
		}
		return player;
	}

	@Override
	public List<Player> findAll() {
		List players = em.createNamedQuery("findAllPlayers").getResultList();
		return players;
	}
}
