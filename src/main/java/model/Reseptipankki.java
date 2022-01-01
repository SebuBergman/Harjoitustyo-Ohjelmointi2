package model;

public class Reseptipankki {
	private int reseptiId;
	private String annoksia;
	private String reseptiNimi;
	private String valmistusAika;
	private String ainesosat;
	private String ohje;

	public Reseptipankki() {
		super();
		this.reseptiId = 0;
		this.annoksia = null;
		this.reseptiNimi = null;
		this.valmistusAika = null;
		this.ainesosat =  null;
		this.ohje =  null;
	}
	
	public Reseptipankki(String annoksia, String reseptiNimi, String valmistusAika, String ainesosat, String ohje) {
		super();
		this.annoksia = annoksia;
		this.reseptiNimi = reseptiNimi;
		this.valmistusAika = valmistusAika;
		this.ainesosat = ainesosat;
		this.ohje = ohje;
	}

	public Reseptipankki(int reseptiId, String annoksia, String reseptiNimi, String valmistusAika, String ainesosat, String ohje) {
		super();
		this.reseptiId = reseptiId;
		this.annoksia = annoksia;
		this.reseptiNimi = reseptiNimi;
		this.valmistusAika = valmistusAika;
		this.ainesosat = ainesosat;
		this.ohje = ohje;
	}

	public int getReseptiId() {
		return reseptiId;
	}

	public void setReseptiId(int reseptiId) {
		this.reseptiId = reseptiId;
	}

	public String getAnnoksia() {
		return annoksia;
	}

	public void setAnnoksia(String annoksia) {
		this.annoksia = annoksia;
	}

	public String getReseptiNimi() {
		return reseptiNimi;
	}

	public void setReseptiNimi(String reseptiNimi) {
		this.reseptiNimi = reseptiNimi;
	}

	public String getValmistusAika() {
		return valmistusAika;
	}

	public void setValmistusAika(String valmistusAika) {
		this.valmistusAika = valmistusAika;
	}

	public String getAinesosat() {
		return ainesosat;
	}

	public void setAinesosat(String ainesosat) {
		this.ainesosat = ainesosat;
	}

	public String getOhje() {
		return ohje;
	}

	public void setOhje(String ohje) {
		this.ohje = ohje;
	}

	@Override
	public String toString() {
		return "Reseptipankki [reseptiId=" + reseptiId + ", annoksia=" + annoksia + ", reseptiNimi=" + reseptiNimi
				+ ", valmistusAika=" + valmistusAika + ", ainesosat=" + ainesosat
				+ ", ohje=" + ohje + "]";
	}
}
