package no.hvl.dat108.c;

import no.hvl.dat108.util.Passordhjelper;

public class Bruker {
	
	private String brukernavn;
	private String salt;
	private String passordhash;
	
	public Bruker(String brukernavn, String passord) {
		this.brukernavn = brukernavn;
		this.salt = Passordhjelper.genererTilfeldigSalt();
		this.passordhash = Passordhjelper.hashMedSalt2(passord, salt);
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public String getSalt() {
		return salt;
	}

	public String getPassordhash() {
		return passordhash;
	}

	@Override
	public String toString() {
		return "Bruker [brukernavn=" + brukernavn + ", salt=" + salt + ", passordhash=" + passordhash + "]";
	}

	

}
