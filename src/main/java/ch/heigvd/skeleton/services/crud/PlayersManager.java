package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.model.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class PlayersManager extends AbstractManager<Player> implements PlayersManagerLocal {

	@Override
	public Player newEntity(Player m) {
		return new Player(m);
	}

	@Override
	public Class<Player> getEntityClass() {
		return Player.class;
	}

	@Override
	public TypedQuery<Player> createNamedQuery(NamedQuery argv) {
		if(argv==NamedQuery.findAll)
			return createNamedQuery("findAllPlayers") ;
                else if(argv == NamedQuery.findAllOrderByPoints)
                        return createNamedQuery("findAllPlayersOrderByPoints");
                
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

       public List<Player> findTopPlayers(long applicationId, int top) {
		List l = createNamedQuery(NamedQuery.findAllOrderByPoints)
                        .setParameter("applicationId", applicationId)
                        .setMaxResults(5)
                        .getResultList();
		return l;
	}
}
