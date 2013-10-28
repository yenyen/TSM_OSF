package ch.heigvd.skeleton.rest;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
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

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		// register root resources/providers
		classes.add(ApplicationExceptionMapper.class);
		classes.add(PlayersResource.class);
		return classes;
	}
}
