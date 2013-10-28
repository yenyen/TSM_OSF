package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.Badge;
import ch.heigvd.skeleton.to.*;
import javax.ejb.Stateless;

/**
 *
 * @author Aurélien Thévoz
 */
@Stateless
public class BadgesTOService implements BadgesTOServiceLocal {
    @Override
    public PublicBadgeTO buildPublicBadgeTO(Badge source) {
        PublicBadgeTO to = new PublicBadgeTO(source.getId(), source.getName(), source.getDescription(), source.getIcon());
        return to;
    }

    @Override
    public void updateBadgeEntity(Badge existingEntity, PublicBadgeTO newState) {
        existingEntity.setDescription(newState.getDescription());
        existingEntity.setName(newState.getName());
        existingEntity.setIcon(newState.getIcon());
    }

}
