/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.model.Player;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author komanda.phanzu
 */
public class PlayersManagerTest {

	Logger logger = Logger.getLogger(getClass().getName());
	//PlayersManager playersManager;

	public PlayersManagerTest() {
	}

	@BeforeClass
	public static void setUpClass() {

	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		//playersManager = lookupPlayersManagerBean();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of createNamedQuery method, of class PlayersManager.
	 *
	 * @throws java.lang.Exception
	 */
	@Test
	public void testCreateNamedQuery_String() throws Exception {
		System.out.println("createNamedQuery");
		String query = "";
		PlayersManager instance = lookupPlayersManagerBean();
		assertNotNull(instance);

		TypedQuery<Player> result = instance.createNamedQuery(query);
		assertNotNull(result);
		List<Player> l = result.getResultList();
		assertNotNull(l);
		logger.info(l.toString());

	}
	EJBContainer container = null;

	private EJBContainer getContainer() {
		if (container != null) {
			return container;
		}
//		// Create a properties map to pass to the embeddable container:
//		Map<String, Object> properties = new HashMap<String, Object>();
//		// Use the MODULES property to specify the set of modules to be initialized,
//		// in this case a java.io.File 
//		properties.put(EJBContainer.MODULES, new File("build/jar"));
//
//		// Create the container instance, passing it the properties map:
//		container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
		container = javax.ejb.embeddable.EJBContainer.createEJBContainer();

		return container;
	}

	private PlayersManager lookupPlayersManagerBean() {
		try {

			Context c = getContainer().getContext();
			return (PlayersManager) c.lookup("java:global/ch.heigvd_Skeleton_war_1.0-SNAPSHOT/PlayersManager!ch.heigvd.skeleton.services.crud.PlayersManager");
		} catch (NamingException ne) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
			throw new RuntimeException(ne);
		}
	}

}
