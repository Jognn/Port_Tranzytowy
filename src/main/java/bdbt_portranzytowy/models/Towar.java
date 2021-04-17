package bdbt_portranzytowy.models;

public class Towar {
	
	private Integer id;
	private float waga;
	private float szerokosc;
	private float dlugosc;
	private float wysokosc;
	private String opis;
	
	public Towar() {
		super();
	}
	
	public Towar(Integer id, float waga, float szerokosc, float dlugosc, float wysokosc, String opis) {
		super();
		this.id = id;
		this.waga = waga;
		this.szerokosc = szerokosc;
		this.dlugosc = dlugosc;
		this.wysokosc = wysokosc;
		this.opis = opis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getWaga() {
		return waga;
	}

	public void setWaga(float waga) {
		this.waga = waga;
	}


	public float getSzerokosc() {
		return szerokosc;
	}

	public void setSzerokosc(float szerokosc) {
		this.szerokosc = szerokosc;
	}

	public float getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(float dlugosc) {
		this.dlugosc = dlugosc;
	}

	public float getWysokosc() {
		return wysokosc;
	}

	public void setWysokosc(float wysokosc) {
		this.wysokosc = wysokosc;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	@Override
	public String toString() {
		return "Towar [id=" + id + ", waga=" + waga + ", szerokosc=" + szerokosc + ", dlugosc="
				+ dlugosc + ", wysokosc=" + wysokosc + ", opis=" + opis + "]";
	}

	
}
