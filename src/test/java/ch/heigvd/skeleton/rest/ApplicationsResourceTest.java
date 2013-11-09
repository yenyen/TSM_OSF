/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.to.PublicApplicationTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author komanda.phanzu
 */
public class ApplicationsResourceTest {
	
	Logger logger=Logger.getLogger(getClass().getName());
	public ApplicationsResourceTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
//	//@Test
//	public void test_REST_getForEntity() throws Exception {
//		System.out.println("test_REST_GetResourceList");
//		
//		RestTemplate template=new RestTemplate();
//		ResponseEntity<PublicApplicationTO> re = template.getForEntity("http://localhost:8080/thevoz-phanzu-gamification/api/applications", PublicApplicationTO.class);
//		assertNotNull(re);
//		PublicApplicationTO o = re.getBody();
//		assertNotNull(o);
//	}
//	
//	//@Test
//	public void test_REST_getForEntity_String() throws Exception {
//		System.out.println("test_REST_getForEntity_String");
//		
//		RestTemplate template=new RestTemplate();
//		ResponseEntity<String> re = template.getForEntity("http://localhost:8080/thevoz-phanzu-gamification/api/applications", String.class);
//		assertNotNull(re);
//		String o = re.getBody();
//		assertNotNull(o);
//	}	
	
	//@Test
	public void test_REST_getForObject_String() throws Exception {
		System.out.println("test_REST_getForEntity_String");
		
		RestTemplate template=new RestTemplate();
		String re = template.getForObject("http://localhost:8080/thevoz-phanzu-gamification/api/applications", String.class);
		assertNotNull(re);
		logger.info(re);
	}

	/**
	 * Test of createResource method, of class ApplicationsResource.
	 */
	//@Test
	public void testCreateResource() throws Exception {
		System.out.println("createResource");
		PublicApplicationTO newTO = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		ApplicationsResource instance = (ApplicationsResource)container.getContext().lookup("java:global/classes/ApplicationsResource");
		Response expResult = null;
		Response result = instance.createResource(newTO);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getResourceList method, of class ApplicationsResource.
	 */
	//@Test
	public void testGetResourceList() throws Exception {
		System.out.println("getResourceList");
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		ApplicationsResource instance = (ApplicationsResource)container.getContext().lookup("java:global/classes/ApplicationsResource");
		List<PublicApplicationTO> expResult = null;
		List<PublicApplicationTO> result = instance.getResourceList();
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getResource method, of class ApplicationsResource.
	 */
	//@Test
	public void testGetResource() throws Exception {
		System.out.println("getResource");
		long id = 0L;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		ApplicationsResource instance = (ApplicationsResource)container.getContext().lookup("java:global/classes/ApplicationsResource");
		PublicApplicationTO expResult = null;
		PublicApplicationTO result = instance.getResource(id);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of Resource method, of class ApplicationsResource.
	 */
	//@Test
	public void testResource() throws Exception {
		System.out.println("Resource");
		PublicApplicationTO updatedApplicationTO = null;
		long id = 0L;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		ApplicationsResource instance = (ApplicationsResource)container.getContext().lookup("java:global/classes/ApplicationsResource");
		Response expResult = null;
		Response result = instance.Resource(updatedApplicationTO, id);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteResource method, of class ApplicationsResource.
	 */
	//@Test
	public void testDeleteResource() throws Exception {
		System.out.println("deleteResource");
		long id = 0L;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		ApplicationsResource instance = (ApplicationsResource)container.getContext().lookup("java:global/classes/ApplicationsResource");
		Response expResult = null;
		Response result = instance.deleteResource(id);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
