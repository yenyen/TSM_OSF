package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.Player;
import ch.heigvd.skeleton.to.PublicPlayerTO;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti
 */
@Stateless
public class PlayersTOService implements PlayersTOServiceLocal {

	public PublicPlayerTO buildPublicPlayerTO(Player source) {
		PublicPlayerTO to = new PublicPlayerTO(source.getId(), source.getFirstName(), source.getLastName(), source.getEmail(), source.getNumberOfPoints());
		return to;
	}

	@Override
	public void updatePlayerEntity(Player existingEntity, PublicPlayerTO newState) {
		existingEntity.setFirstName(newState.getFirstName());
		existingEntity.setLastName(newState.getLastName());
		existingEntity.setEmail(newState.getEmail());		
	}
	
	
}
