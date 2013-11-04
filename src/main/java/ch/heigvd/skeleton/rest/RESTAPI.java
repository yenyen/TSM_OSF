package ch.heigvd.skeleton.rest;

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
		classes.add(ApplicationExceptionMapper.class);
		classes.add(PlayersResource.class);
		classes.add(BadgesResource.class);
		return classes;
	}
}
