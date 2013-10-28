package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.Application;
import ch.heigvd.skeleton.to.PublicApplicationTO;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti
 */
@Stateless
public class ApplicationsTOService implements ApplicationsTOServiceLocal {

	@Override
	public PublicApplicationTO buildPublicApplicationTO(Application source) {
		//long id, String name, String description, String apiKey, String apiSecret
		PublicApplicationTO to = new PublicApplicationTO(
				source.getId(), 
				source.getName(), 
				source.getDescription(), 
				source.getApiKey(), 
				source.getApiSecret()
		);
		return to;
	}

	@Override
	public void updateApplicationEntity(Application existingEntity, PublicApplicationTO newState) {
		existingEntity.setApiKey(newState.getApiKey());
		existingEntity.setApiSecret(newState.getApiSecret());
		existingEntity.setDescription(newState.getDescription());
		existingEntity.setName(newState.getName());
		existingEntity.setId(newState.getId());
	}
	
	
}
