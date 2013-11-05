package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Event;
import ch.heigvd.skeleton.model.Player;
import ch.heigvd.skeleton.model.Rule;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class RulesManager extends AbstractManager<Rule> implements RulesManagerLocal {
        @EJB
        PlayersManagerLocal playersManager;
        
	@Override
	public Rule newEntity(Rule m) {
		return new Rule(m);
	}

	@Override
	public Class<Rule> getEntityClass() {
		return Rule.class;
	}

	@Override
	public TypedQuery<Rule> createNamedQuery(NamedQuery argv) {
		if(argv==NamedQuery.findAll)
			return createNamedQuery("findAllRules") ;
                else if(argv == NamedQuery.findByType)
                        return createNamedQuery("findRulesByType");
                        
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

        @Override
        public void notifyEvent(Event event) throws EntityNotFoundException {
            List<Rule> rules = createNamedQuery(NamedQuery.findByType)
                    .setParameter("onEventType", event.getType())
                    .getResultList();
            
            Player player = playersManager.findById(event.getPlayer().getId());
            for(Rule rule : rules) {
                player.setNumberOfPoints(player.getNumberOfPoints() + rule.getNumberOfPoints());

                if(!player.getBadges().contains(rule.getBadge()))
                    player.getBadges().add(rule.getBadge());
            }
            playersManager.update(player);
        }
                
}
