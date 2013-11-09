package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.Player;
import ch.heigvd.skeleton.to.PublicBadgeTO;
import ch.heigvd.skeleton.to.PublicPlayerTO;
import ch.heigvd.skeleton.to.PublicPlayerWithBadgesTO;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti
 */
@Stateless
public class PlayersTOService implements PlayersTOServiceLocal {

    public PublicPlayerTO buildPublicPlayerTO(Player source) {
        return new PublicPlayerTO(source.getId(), 
                source.getFirstName(), 
                source.getLastName(), 
                source.getEmail(), 
                source.getNumberOfPoints());
    }

    @Override
    public PublicPlayerWithBadgesTO buildPublicPlayerWithBadgesTO(Player source, PublicBadgeTO[] badges) {
        return new PublicPlayerWithBadgesTO(source.getId(), 
                source.getFirstName(), 
                source.getLastName(), 
                source.getEmail(), 
                source.getNumberOfPoints(),
                badges);
    }


    @Override
    public void updatePlayerEntity(Player existingEntity, PublicPlayerTO newState) {
        existingEntity.setFirstName(newState.getFirstName());
        existingEntity.setLastName(newState.getLastName());
        existingEntity.setEmail(newState.getEmail());		
    }
}
