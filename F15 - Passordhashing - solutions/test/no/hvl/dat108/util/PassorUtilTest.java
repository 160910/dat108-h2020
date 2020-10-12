package no.hvl.dat108.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PassorUtilTest {
	
	private static final String RIKTIG_PASSORD = "Abc de fgh";
	private static final String FEIL_PASSORD = "Java er kjedelig";
	private static final String FOR_KORT_PASSORD = "123456789";
	
//	private PassordUtilOld passordUtil = new PassordUtilOld();
	private PassordUtil passordUtil = new PassordUtil();

	@Test
	void riktigPassordVirker() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertTrue(passordUtil.sjekkPassord(RIKTIG_PASSORD, mittSaltPlussDigest));
	}

	@Test
	void feilPassordVirkerIkke() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertFalse(passordUtil.sjekkPassord(FEIL_PASSORD, mittSaltPlussDigest));
	}
	
	@Test
	void tomKryptertVirkerIkke() {
        assertFalse(passordUtil.sjekkPassord(RIKTIG_PASSORD, ""));
	}
	
	@Test
	void nullPassordKasterUnntak1() {
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.krypterPassord(null));
	}
	
	@Test
	void nullPassordKasterUnntak2() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.sjekkPassord(null, mittSaltPlussDigest));
	}
	
	@Test
	void nullKryptertKasterUnntak() {
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.sjekkPassord(RIKTIG_PASSORD, null));
	}
	
	@Test
	void kortPassordKasterUnntak1() {
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.krypterPassord(FOR_KORT_PASSORD));
	}
	
	@Test
	void kortPassordKasterUnntak2() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.sjekkPassord(FOR_KORT_PASSORD, mittSaltPlussDigest));
	}
	

}
