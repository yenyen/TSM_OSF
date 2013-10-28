/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author komanda.phanzu
 */
public class PlayerUnitTest {
	
	public PlayerUnitTest() {
	}
	

    // TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	 @Test
	 public void testConstructor_empty() {
		Player o = new Player();
		assertNotNull(o);
		assertNull(o.getId());
		assertNull(o.getFirstName());
		assertNull(o.getEmail());
		assertNull(o.getLastName());
		assertEquals(o.getNumberOfPoints(), 0);
	 }
	 @Test
	 public void testConstructor_withParameters_Values() {
		Player o = new Player("Aurélien", "Thevoz", "at@me.org", 10);
		assertNotNull(o);
		assertNull(o.getId());
		assertNotNull(o.getFirstName());
		assertEquals(o.getFirstName(), "Aurélien");
		assertNotNull(o.getLastName());
		assertEquals(o.getLastName(), "Aurélien");
		assertNotNull(o.getEmail());
		assertEquals(o.getEmail(), "at@me.org");
		
		assertEquals(o.getNumberOfPoints(), 10);
	 }
}
