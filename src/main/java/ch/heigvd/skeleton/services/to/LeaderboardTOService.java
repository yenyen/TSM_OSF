package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.to.*;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Aurélien Thévoz
 */
@Stateless
public class LeaderboardTOService implements LeaderboardTOServiceLocal {
    @Override
    public PublicLeaderboardTO buildPublicLeaderboardTO(String name, String description,  List<Player> players) {       
        return new PublicLeaderboardTO(name, description,  players);
    }
}
