package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

   	//Må være minst 4 tegn og kun inneholde bokstaver og tall,
	//og må begynne med en bokstav.
	
	@Test
	public void korteBrukernavnIkkeOk() {
		assertFalse(Validator.isValidUsername(null));
		assertFalse(Validator.isValidUsername(""));
		assertFalse(Validator.isValidUsername("abc"));
	}
	
	@Test
	public void brukernavnSomErOk() {
		assertTrue(Validator.isValidUsername("abcd"));
		assertTrue(Validator.isValidUsername("æøåX"));
	}
}
