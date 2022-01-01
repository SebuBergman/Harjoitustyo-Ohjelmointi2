package program;

import java.util.List;

import model.Reseptipankki;

public class ReseptipankkiKokeiluOhjelma {
	public static void main(String[] args) {
		String[] arrayAinesosat = {"1 kpl salottisipuli","2 kpl valkosipulinkynttä", "½ keltainen paprika", "½ punainen paprika", "pala kesäkurpitsaa", "maldon-suolaa, pippuria, öljyä", "1 tl lime-mausteseos (meira)", "3 dl couscous-suurimoita", "3 dl kasvislientä"};
		System.out.println("4 annosta");
		System.out.println("Valmistusaika Alle 15 min");
		System.out.println("Kasvis-couscous\n");
		
		for (String a : arrayAinesosat) {
			System.out.println(a);
		}
		System.out.println(
				"\nOhjeet\r\n" + "1. Pilko kaikki kasvikset pieneksi ja kuullota hetki öljyssä. Mausta mieleiseksi.\r\n"
						+ "2. Kiehauta kasvisliemi kattilassa ja lisää couscous-suurimot.\r\n"
						+ "3. Anna hautua 3-6 minuuttia kannen alla.\r\n"
						+ "4. Sekoita kevyesti haarukalla irtonaiseksi ja lisää kasvisseos.\r\n" + "Tarkista maku.");
		
		/*Reseptipankki reseptipankki = new Reseptipankki();
		List<Resepti> Reseptit = reseptit.findAll();
		String[] myArray = getAinesosat().split(",");
		for Resepti resepti : reseptit) {
			System.out.println("Annoksia: " + resepti.getAnnoksia());
			System.out.println(resepti.getReseptiNimi());
			System.out.println("Kokonaisaika: " + resepti.getKokonaisAika());
			for (String a : myArray) {
				System.out.println(a);
			}
			System.out.println("Ohje: " + resepti.getOhje());
			}*/
	}

}
