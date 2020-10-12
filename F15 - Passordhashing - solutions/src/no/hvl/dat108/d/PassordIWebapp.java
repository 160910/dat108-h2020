package no.hvl.dat108.d;

import no.hvl.dat108.util.PassordUtil;

public class PassordIWebapp {

	public static void main(String[] args) {

		/*
		 * Dette er en demo av hvordan PassordUtil kan brukes i en webapp.
		 * 
		 * En bruker registrerer seg med brukernavn og valgtPassord. Et brukerobjekt med
		 * brukernavn og kryptert passord lagres i databasen. Brukeren blir logget på.
		 * 
		 * Tiden går ... og brukeren er logget ut.
		 * 
		 * Bruker ønsker å logge inn igjen, og oppgir brukernavn og loginnPassord. Et
		 * brukerobjekt blir hentet fra databasen basert på oppgitt brukernavn.
		 * loginnPassord sammenlignes med det lagrede krypterte passordet for denne
		 * brukeren, osv ...
		 * 
		 * NB! Sjekk innholdet i metodene PassordUtil.krypterPassord() og
		 * PassordUtil.sjekkPassord(). De er pensum!!!
		 */

		PassordUtil pwUtil = new PassordUtil();

		// Bruker registrerer seg
		String valgtPassord = "1234567890";
		System.out.println("Valgt passord er " + valgtPassord);

		// validerer ...

		// krypterer
		String kryptertPassord = pwUtil.krypterPassord(valgtPassord);
		System.out.println("\"Kryptert\" passord er " + kryptertPassord);

		// oppretter bruker-entitet og lagrer i database
		// logg på bruker

		// ...

		// senere pålogging, brukernavn + loginnPassord
		String loginnPassord = "1234567890";
		System.out.println("Prøver å logge inn med " + loginnPassord);

		// henter bruker fra database og henter ut igjen lagret kryptertPassord

		// sammenligner, osv. ...
		if (pwUtil.sjekkPassord(loginnPassord, kryptertPassord)) {
			System.out.println("Riktig passord. Innlogging OK.");
		} else {
			System.out.println("Feil passord.");
		}

	}
}
