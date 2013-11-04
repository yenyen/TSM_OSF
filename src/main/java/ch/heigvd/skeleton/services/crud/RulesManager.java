package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.model.Rule;
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
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
