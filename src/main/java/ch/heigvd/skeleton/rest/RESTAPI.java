package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.InvalidOperationException;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Olivier Liechti
 */
@ApplicationPath("/api")
public class RESTAPI extends Application {

	/**
	 *
	 * @return
	 */
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		// register root resources/providers
		classes.add(InvalidOperationException.class);
		classes.add(ApplicationExceptionMapper.class);
		classes.add(LoginFailedExceptionMapper.class);
		classes.add(ApplicationsResource.class);
		classes.add(BadgesResource.class);
		classes.add(EventsResource.class);
		classes.add(LeaderboardResource.class);
		classes.add(PlayersResource.class);
		classes.add(RulesResource.class);
		
		return classes;
	}
}
