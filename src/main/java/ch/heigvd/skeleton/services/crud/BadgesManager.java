package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.model.Badge;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 *
 * @author Olivier Liechti
 */
@Stateless
public class BadgesManager extends AbstractManager<Badge> implements BadgesManagerLocal {

    @Override
    public Badge newEntity(Badge m) {
        return new Badge(m);
    }

    @Override
    public Class<Badge> getEntityClass() {
        return Badge.class;
    }

    @Override
    public TypedQuery<Badge> createNamedQuery(NamedQuery argv) {
        if (argv == NamedQuery.findAll) {
            return createNamedQuery("findAllBadges");
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
