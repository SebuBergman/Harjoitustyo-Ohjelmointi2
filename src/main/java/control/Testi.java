package control;

public class Testi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ainesosat = "Ohjeet:1.Voitele uunivuoka. Laita uuni lämpenemään 200 asteeseen.:2.Mittaa ainekset vuokaan ja sekoita. (Makaroneja ei siis tarvitse keittää.):3.Paista laatikkoa uunin alatasolla noin 40 minuuttia. 4.Anna vetäytyä hetki ennen tarjoilua.";
		ainesosat = ainesosat.replace(":", "<br>");
		String ainesosatBR = ainesosat;
		System.out.println(ainesosatBR);
	}
}