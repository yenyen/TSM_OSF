/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

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
		assertEquals(0, o.getNumberOfPoints());
	 }
	 @Test
	 public void testConstructor_withParameters_Values() {
		Player o = new Player(null, "Aurélien", "Thevoz", "at@me.org", 10);
		assertNotNull(o);
		assertNull(o.getId());
		assertNotNull(o.getFirstName());
		assertEquals("Aurélien", o.getFirstName());
		assertNotNull(o.getLastName());
		assertEquals("Thevoz", o.getLastName());
		assertNotNull(o.getEmail());
		assertEquals("at@me.org", o.getEmail());
		
		assertEquals(10, o.getNumberOfPoints());
	 }
}
