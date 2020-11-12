package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		try {
			File lokasjon = Path.of(mappe,filnavn).toFile();
			Scanner leser = new Scanner(lokasjon);
			
			int antall = Integer.parseInt(leser.nextLine());
			Blogg blogg = new Blogg(antall);
			
			while(leser.hasNextLine()) {
				String type = leser.nextLine().trim();
				if (type.equals(TEKST)) {
					int id = Integer.parseInt(leser.nextLine());
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int likes = Integer.parseInt(leser.nextLine());
					String tekst = leser.nextLine();
					blogg.leggTil(new Tekst(id, bruker, dato,likes, tekst));
				}
				else if (type.equals(BILDE)) {
					int id = Integer.parseInt(leser.nextLine());
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int likes = Integer.parseInt(leser.nextLine());
					String tekst = leser.nextLine();
					String url = leser.nextLine();
					blogg.leggTil(new Bilde(id,bruker,dato,likes,tekst,url));
				}
			}
			
			leser.close();
			return blogg;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
