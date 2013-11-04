package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.to.*;
import javax.ejb.Stateless;

/**
 *
 * @author Aurélien Thévoz
 */
@Stateless
public class ApplicationsTOService implements ApplicationsTOServiceLocal {
    @Override
    public PublicApplicationTO buildPublicApplicationTO(Application source) {
        PublicApplicationTO to = new PublicApplicationTO(source.getId(), source.getName(), source.getDescription(), source.getApiKey(), "secret");
        return to;
    }

    @Override
    public void updateApplicationEntity(Application existingEntity, PublicApplicationTO newState) {
        existingEntity.setDescription(newState.getDescription());
        existingEntity.setName(newState.getName());
        existingEntity.setApiSecret(newState.getApiSecret());
    }

}
