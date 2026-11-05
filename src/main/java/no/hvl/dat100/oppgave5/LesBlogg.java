package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File fil= new File(mappe, filnavn);
		Blogg samling = null;

		try (Scanner leser = new Scanner(fil)) {
			if (leser.hasNextLine()){
				int antallInnlegg = Integer.parseInt(leser.nextLine().trim());
				samling = new Blogg(antallInnlegg);
			}

			while (leser.hasNextLine()){
				string type = leser.nextLine().trim();
				if (type.isEmpty()){
					continue;
				}
				int id = Integer.parseInt(leser.nextLine().trim());
				String bruker = leser.nextLine().trim();
				String dato = leser.nextLine().trim();
				int likes = Integer.parseInt(leser.nextLine().trim());

				if (type.equals("TEKST")){
					String tekstInnhold = leser.nextLine().trim();

					Tekst tekstObjekt = new Tekst(id, bruker, dato, likes, tekstInnhold);
					samling.leggTil(tekstObjekt);

				}
				else if (type.equals("BILDE")) {
					String tekstInnhold = leser.nextLine().trim();
					String url = leser.nextLine().trim();

					Bilde bildeObjekt = new Bilde(id, bruker, dato, likes, tekstInnhold, url);
					samling.leggTil(bildeObjekt);
				}

			}
		} catch (FileNotFoundException e){
			System.err.println("Feil: Fant filen som skulle lese: " + filnavn);
			return null;
		}
		return  samling;

	}
}
