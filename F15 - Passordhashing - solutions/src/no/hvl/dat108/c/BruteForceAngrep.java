package no.hvl.dat108.c;

import no.hvl.dat108.util.PassordUtil;

public class BruteForceAngrep {

    public static void main(String[] args) {
        
        PassordUtil passordUtil = new PassordUtil();

        String passord = "abc";
        String kryptert = passordUtil.krypterPassord(passord);
        
        long antallPassordSjekket = 0;

        long start = System.currentTimeMillis();
        
        boolean ferdig = false;
        for (char c1='0'; c1<='z' && !ferdig; c1++) {
            System.out.print(".");
            for (char c2='0'; c2<='z' && !ferdig; c2++) {
                for (char c3='0'; c3<='z' && !ferdig; c3++) {
                	antallPassordSjekket++;
                    String p = "" + c1 + c2 + c3;
                    if (passordUtil.sjekkPassord(p, kryptert)) {
                        System.out.println("\nPassordet er " + p);
                        ferdig = true;
                    }
                }
            }
        }
        
        long stopp = System.currentTimeMillis();
        
        System.out.println("Antall passord sjekket: " + antallPassordSjekket);
        System.out.println("Tid i sekunder: " + (stopp-start)/1_000);
    }
}
