package no.hvl.dat100.jplab11.oppgave3;


import java.util.ArrayList;
import java.util.List;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig = 0;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
		
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) > -1;
	}

	public boolean ledigPlass() {
		return innleggtabell.length > nesteledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (nesteledig >= innleggtabell.length) return false;
		
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}
	
	public String toString() {
		String r = Integer.toString(nesteledig)+"\n";
		for (int i = 0; i < nesteledig; i++) {
			r += innleggtabell[i].toString();
		}
		return r;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[innleggtabell.length*2];
		for (int i = 0; i < innleggtabell.length; i++) {
			ny[i] = innleggtabell[i];
		}
		innleggtabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (finnes(innlegg)) return false;
		
		if (!ledigPlass()) utvid();
		return leggTil(innlegg);
		
				
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int index = finnInnlegg(innlegg);
		if (index > -1) {
			for (int i = index+1; i < innleggtabell.length; i++) {
				innleggtabell[i-1] = innleggtabell[i];
			}
			
			nesteledig--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		List<Integer> resultater = new ArrayList<>();
		for (int i = 0; i < nesteledig; i++) {
			Tekst tekstInnlegg = (Tekst)innleggtabell[i];
			if (tekstInnlegg.getTekst().contains(keyword)) {
				resultater.add(i);
			}
		}
		int[] returArray = new int[resultater.size()];
		for (int i = 0; i < resultater.size(); i++) {
			returArray[i] = resultater.get(i).intValue();
		}
		
		return returArray;
	}
}