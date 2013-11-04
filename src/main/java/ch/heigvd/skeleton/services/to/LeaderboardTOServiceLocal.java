package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.Player;
import ch.heigvd.skeleton.to.PublicLeaderboardTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti
 */
@Local
public interface LeaderboardTOServiceLocal {
	
	/**
	 * This method builds a TO instance from a JPA entity instance. In this particular
	 * case, the only thing that we do is get rid of the salary property (which is
	 * available in the JPA entity but should not be communicated to clients).
	 * 
	 * @param source the JPA entity
	 * @return the TO
	 */
	public PublicLeaderboardTO buildPublicLeaderboardTO(String name, String description, List<Player> players);
}
