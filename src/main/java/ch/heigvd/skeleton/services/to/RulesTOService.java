package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.Badge;
import ch.heigvd.skeleton.model.Rule;
import ch.heigvd.skeleton.to.PublicRuleTO;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti
 */
@Stateless
public class RulesTOService implements RulesTOServiceLocal {

	public PublicRuleTO buildPublicRuleTO(Rule source) {
		PublicRuleTO to = new PublicRuleTO(
                        source.getId(), 
                        source.getOnEventType(), 
                        source.getNumberOfPoints(), 
                        source.getBadge().getId());
		return to;
	}

	@Override
	public void updateRuleEntity(Rule existingEntity, PublicRuleTO newState) {
            Badge badge = new Badge();
            badge.setId(newState.getBadgeId());
            
            existingEntity.setBadge(badge);
            existingEntity.setNumberOfPoints(newState.getNumberOfPoints());
            existingEntity.setOnEventType(newState.getOnEventType());
	}
	
	
}
