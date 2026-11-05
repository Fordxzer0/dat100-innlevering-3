package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		File fil = new File(mappe, filnavn);
		try(PrintWriter utskrift= new PrintWriter(fil)){
			utskrift.print(samling.toString());
			return true;
		}
		catch (FileNotFoundException e){
			System.err.println("Feil : Kunne ikke skrive til filen " + filnavn + "." + e.getMessage());
			return  false;
		}
	}
}
