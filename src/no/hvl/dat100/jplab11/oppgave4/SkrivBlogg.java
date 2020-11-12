package no.hvl.dat100.jplab11.oppgave4;

import java.io.PrintWriter;
import java.nio.file.Path;

import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
			String lokasjon = Path.of(mappe, filnavn).toString();
			PrintWriter skriver = new PrintWriter(lokasjon);
			String data = samling.toString();
			skriver.print(data);
			skriver.close();
			return true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
