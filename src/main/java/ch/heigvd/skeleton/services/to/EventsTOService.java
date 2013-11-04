package ch.heigvd.skeleton.services.to;

import ch.heigvd.skeleton.model.*;
import ch.heigvd.skeleton.to.*;
import javax.ejb.Stateless;

/**
 *
 * @author Aurélien Thévoz
 */
@Stateless
public class EventsTOService implements EventsTOServiceLocal {
    @Override
    public PublicEventTO buildPublicEventTO(Event source) {
        PublicEventTO to = new PublicEventTO(source.getId(), source.getApplication().getId(), source.getPlayer().getId(), 
                source.getType(), source.getTimestamp());
        return to;
    }
    
    
    @Override
    public void updateEventEntity(Event existingEntity, PublicEventTO newState) {
        Application application = new Application();
        application.setId(newState.getApplicationId());
        existingEntity.setApplication(application);
        
        Player player = new Player();
        player.setId(newState.getPlayerId());
        existingEntity.setPlayer(player);
        
        existingEntity.setTimestamp(newState.getTimestamp());
        existingEntity.setType(newState.getType());
    }
}
