
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class JMBG {

	private String jmbg;
	private String datumRodjenja;
	private GregorianCalendar konacanDatum;
	private String pol;
	private String drzavaRodjenja;
	private String mestoRodjenja;
	private String danRodjenja;
	private String mesecRodjenja;
	private String godinaRodjenja;
	private int greska = 0;
	int brojacGUI = 0;
	

	
	
	// Get i Set Metode za KonacanDatum i JMBG
	
	public GregorianCalendar getKonacanDatum() {
		return konacanDatum;
	}
	
	public void setKonacanDatum(GregorianCalendar konacanDatum) {
		this.konacanDatum = konacanDatum;
	}
	
	public String getJmbg() {
		return jmbg;
	}
	
	public void setJmbg(String jmbg) {
		
		// Pretvaranje svake cifre u poseban broj, radi provere kontrilne cifre
		Integer A = Integer.parseInt(jmbg.substring(0, jmbg.length()-12));
		Integer B = Integer.parseInt(jmbg.substring(1, jmbg.length()-11));
		Integer C = Integer.parseInt(jmbg.substring(2, jmbg.length()-10));
		Integer D = Integer.parseInt(jmbg.substring(3, jmbg.length()-9));
		Integer E = Integer.parseInt(jmbg.substring(4, jmbg.length()-8));
		Integer F = Integer.parseInt(jmbg.substring(5, jmbg.length()-7));
		Integer G = Integer.parseInt(jmbg.substring(6, jmbg.length()-6));
		Integer H = Integer.parseInt(jmbg.substring(7, jmbg.length()-5));
		Integer I = Integer.parseInt(jmbg.substring(8, jmbg.length()-4));
		Integer J = Integer.parseInt(jmbg.substring(9, jmbg.length()-3));
		Integer K = Integer.parseInt(jmbg.substring(10, jmbg.length()-2));
		Integer L = Integer.parseInt(jmbg.substring(11, jmbg.length()-1));
		Integer M = Integer.parseInt(jmbg.substring(12, jmbg.length()-0));
		
		// Izracunavanje Kontrolne cifre
		int kontrolnacifra = 11 - ((7*(A + G) + 6*(B + H) + 5*(C + I) + 4*(D + J) + 3*(E + K) + 2*(F + L)) % 11) ;

		// Provera jmbg za upisivanje
		if ( jmbg == null ) {
			System.out.println("jmbg ne sme da bude null.");
			greska = 1;
		}
		if ( jmbg.equals("") ) {
			System.out.println("jmbg ne sme da bude prazan string.");
			greska = 1;
		}
		if ( jmbg.length() != 13 ) {
			System.out.println("jmbg mora da bude duzine 13 karaktera.");
			greska = 1;
		}
		
			// Provera Dana, Meseca i Godine Rodjenja
		Integer danRodjenjaINT = Integer.parseInt(jmbg.substring(0, jmbg.length()-11));
		Integer mesecRodjenjaINT = Integer.parseInt(jmbg.substring(2, jmbg.length()-9));
		Integer godinaRodjenjaINT = Integer.parseInt(jmbg.substring(4, jmbg.length()-6));
		
		System.out.println(" dan rodjenja je:" +danRodjenjaINT + " mesec rodjenja je: " + mesecRodjenjaINT + " godina rodjenaj je: " + godinaRodjenjaINT);
		
		// Kontrola Dana u mesecu
		
		if ( mesecRodjenjaINT > 12 ) {
			System.out.println("Uneli ste pogresan jmbg, mesec rodjenja ne moze da bude preko 12");
			greska = 1;
		}
		
		if (  mesecRodjenjaINT == 1   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Januar nema vise od 31 dan");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 2   ) {
			if ( godinaRodjenjaINT %4 == 0 ) {
				
				if ( danRodjenjaINT > 29 ) {
					System.out.println("Februar prestupne godine nema vise od 29 dana");
					greska = 1;
				}
				
			}
			if ( godinaRodjenjaINT %4 != 0 ) {
			
				if ( danRodjenjaINT > 28 ) {
					System.out.println("Februar kad nije prestupna godina nema vise od 28 dana");
					greska = 1;
				}
			}
		}
		
		if (  mesecRodjenjaINT == 3   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Mart nema vise od 31 dan");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 4   ) {
			if ( danRodjenjaINT > 30 ) {
				System.out.println("April nema vise od 30 dana");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 5   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Maj nema vise od 31 dan");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 6   ) {
			if ( danRodjenjaINT > 30 ) {
				System.out.println("Jun nema vise od 30 dana");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 7   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Jul nema vise od 31 dan");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 8   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Avgust nema vise od 31 dan");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 9   ) {
			if ( danRodjenjaINT > 30 ) {
				System.out.println("Septembar nema vise od 30 dana");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 10   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Oktobar nema vise od 31 dan");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 11   ) {
			if ( danRodjenjaINT > 30 ) {
				System.out.println("Novembar nema vise od 30 dana");
				greska = 1;
			}
		}
		
		if (  mesecRodjenjaINT == 12   ) {
			if ( danRodjenjaINT > 31 ) {
				System.out.println("Decembar nema vise od 31 dan");
				greska = 1;
			}
		}
		
		// Provera koliko cifara u maticnom broju su brojevi
		else {
			
			int brojac = 0;
			for (int i = 0; i < jmbg.length(); i++) {
				if ( Character.isDigit(jmbg.charAt(i)) ) {
					
	               brojac++;
	               
	        }
				else {
					System.out.println("Jmbg koji ste uneli ima slova u sebi");
					greska = 1;
				}
				
			}
		
			System.out.println("od 13 karaktera " + brojac + " su brojevi");
			
			if ( brojac == 13 ) {
				this.jmbg = jmbg;
			}
		}
		
		// Provera Kontrolne cifre 
		
		System.out.println("Kontrolna cifra je: " + kontrolnacifra);
		if ( kontrolnacifra <= 9 ) {
			if ( kontrolnacifra != M ) {
				System.out.println("jmbg nije dobar, ne slaze se kontrolna cifra");
				greska = 1;
			}
			else {
			
			}
		}
		if ( kontrolnacifra > 9 ) {
			if ( M != 0 ) {
				System.out.println("jmbg nije dobar, ne slaze se kontrolna cifra");
				greska = 1;
			}
			else {
				
			}
		}
		
		this.jmbg = jmbg;
		
		
	}
	
	// Get i Set metoda za DatumRodjenja
	
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(String datumRodjenja) {
		if ( datumRodjenja == null ) {
			System.out.println("DatumRodjenja ne sme da bude null");
			greska = 1;
		}
		if ( datumRodjenja.equals("") ) {
			System.out.println("DarumRodjenja ne sme da bude prazan string");
			greska = 1;
		}
		this.datumRodjenja = datumRodjenja;
	}
	
	// Drugi nacin da se uradi provera Meseci u JMBG-u
	/* 
	 
	public void ostatakProveriZaJMBG ( ) {
		
		Integer danRodjenjaINT = Integer.parseInt(jmbg.substring(0, jmbg.length()-11));
		Integer mesecRodjenjaINT = Integer.parseInt(jmbg.substring(2, jmbg.length()-9));
		Integer godinaRodjenjaINT = Integer.parseInt(jmbg.substring(4, jmbg.length()-6));
		
		System.out.println(" dan rodjenja je:" +danRodjenjaINT + " mesec rodjenja je: " + mesecRodjenjaINT + " godina rodjenaj je: " + godinaRodjenjaINT);
		
		if ( mesecRodjenjaINT > 12 ) {
			throw new RuntimeException("Uneli ste pogresan jmbg, mesec rodjenja ne moze da bude preko 12");
		}
		
		if (  mesecRodjenjaINT == 1   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Januar nema vise od 31 dan");
			}
		}
		
		if (  mesecRodjenjaINT == 2   ) {
			if ( godinaRodjenjaINT %4 == 0 ) {
				
				if ( danRodjenjaINT > 29 ) {
					throw new RuntimeException("Februar prestupne godine nema vise od 29 dana");
				}
				
			}
			if ( godinaRodjenjaINT %4 != 0 ) {
			
				if ( danRodjenjaINT > 28 ) {
					throw new RuntimeException("Februar kad nije prestupna godina nema vise od 28 dana");
				}
			}
		}
		
		if (  mesecRodjenjaINT == 3   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Mart nema vise od 31 dan");
			}
		}
		
		if (  mesecRodjenjaINT == 4   ) {
			if ( danRodjenjaINT > 30 ) {
				throw new RuntimeException("April nema vise od 30 dana");
			}
		}
		
		if (  mesecRodjenjaINT == 5   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Maj nema vise od 31 dan");
			}
		}
		
		if (  mesecRodjenjaINT == 6   ) {
			if ( danRodjenjaINT > 30 ) {
				throw new RuntimeException("Jun nema vise od 30 dana");
			}
		}
		
		if (  mesecRodjenjaINT == 7   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Jul nema vise od 31 dan");
			}
		}
		
		if (  mesecRodjenjaINT == 8   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Avgust nema vise od 31 dan");
			}
		}
		
		if (  mesecRodjenjaINT == 9   ) {
			if ( danRodjenjaINT > 30 ) {
				throw new RuntimeException("Septembar nema vise od 30 dana");
			}
		}
		
		if (  mesecRodjenjaINT == 10   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Oktobar nema vise od 31 dan");
			}
		}
		
		if (  mesecRodjenjaINT == 11   ) {
			if ( danRodjenjaINT > 30 ) {
				throw new RuntimeException("Novembar nema vise od 30 dana");
			}
		}
		
		if (  mesecRodjenjaINT == 12   ) {
			if ( danRodjenjaINT > 31 ) {
				throw new RuntimeException("Decembar nema vise od 31 dan");
			}
		}
		
		else {
			
			int brojac = 0;
			for (int i = 0; i < jmbg.length(); i++) {
				if ( Character.isDigit(jmbg.charAt(i)) ) {
					
	               brojac++;
	               
	        }
				else {
					throw new RuntimeException( " Jmbg koji ste uneli ima slova u sebi" );
				}
				
			}
		
			System.out.println("od 13 karaktera " + brojac + " su brojevi");
			
		}
		
	} 
	
	*/
	
	public void jmbgUDatumRodjenja () {
		
		// Pravljenje datuma rodjenja u Stringu
		String danRodjenjaa = jmbg.substring(0, jmbg.length()-11);
		String mesecRodjenjaa = jmbg.substring(2, jmbg.length()-9);
		String godinaRodjenjaa = jmbg.substring(4, jmbg.length()-6);
		
		System.out.println("Dan rodjenja je: " + danRodjenjaa + " mesec rodjenja je: " + mesecRodjenjaa + " godina rodjenja bez prvog broja je: " + godinaRodjenjaa);
		
		if ( godinaRodjenjaa.substring(0, godinaRodjenjaa.length()-2).equals("0") ) {
			godinaRodjenjaa = "2" + godinaRodjenjaa;
			
		}
		
		else {
			godinaRodjenjaa = "1" + godinaRodjenjaa;
		}
		
		System.out.println("Posle dodavanje prvog broja u godini");
		System.out.println("Dan rodjenja je: " + danRodjenjaa + " mesec rodjenja je: " + mesecRodjenjaa + " godina rodjenja bez prvog broja je: " + godinaRodjenjaa);
		
		// Od Dana Rodjenja, Meseca Rodjenja i Godine Rodjenja pravimo Datum Rodjenja :D
		
		setDatumRodjenja ( danRodjenjaa + "." + mesecRodjenjaa + "." + godinaRodjenjaa) ;
		System.out.println("Datum rodjenja je " + datumRodjenja);
		
		danRodjenja = danRodjenjaa;
		mesecRodjenja = mesecRodjenjaa;
		godinaRodjenja = godinaRodjenjaa;
		
	}
	
	public void stringUKalendar () {
		// Treba da se pretvori String u Date ili u GeorgianCalendar
	}
	
	public void Pol () {
		
		// Provera Pol-a 
		
		Integer pol = Integer.parseInt(jmbg.substring(9, jmbg.length()-1));
		
		if ( pol < 500 ) {
			this.pol = "Muski";
					System.out.println("Osoba je Muskog pol-a");
		}
		if ( pol >= 500 ) {
			this.pol = "Zenski";
			System.out.println("Osoba je Zenskog pol-a");
		}
		
	}
	
	public void RegionRodjenja () {
		
		//Provera Mesta Rodjenja
		
		Integer regionRodjenja = Integer.parseInt(jmbg.substring(7, jmbg.length()-4));
		System.out.println("region rodjenja je: " + regionRodjenja);
		
		
		// Rodjeni u Bosna i Hercegovina
		
		
		if ( regionRodjenja >= 10 && regionRodjenja <= 19 ) {
			drzavaRodjenja = "Bosna i Hercegovina";
			
			switch (regionRodjenja) {
			
			case 10 :  mestoRodjenja ="Banja Luka";
				break;
				
			case 11 : mestoRodjenja = "Bihac";
				break;
			
			case 12 : mestoRodjenja = "Doboj";
				break;
				
			case 13 : mestoRodjenja = "Gorazde";
				break;
				
			case 14 : mestoRodjenja = "Livno";
				break;
				
			case 15 : mestoRodjenja = "Mostar";
				break;
				
			case 16 : mestoRodjenja = "Prijedoro";
				break;
				
			case 17 : mestoRodjenja = "Sarajevo";
				break;
				
			case 18 : mestoRodjenja = "Tuzla";
				break;
			
			case 19 : mestoRodjenja = "Zenica";
				break;
				
			default : mestoRodjenja = "Nije Poznato";
				break;
			
			}
			
		}
		
		
		// Rodjeni u Crna Gora
		
		
		else if ( regionRodjenja > 20 && regionRodjenja < 30 ) {
			drzavaRodjenja = "Crna Gora";
			
			switch (regionRodjenja) {
			
				case 21 :  mestoRodjenja = "Podgorica";
					break;
					
				case 22 :  mestoRodjenja = "Bar, Ulcinj";
					break;
					
				case 23 :  mestoRodjenja = "Budva, Kotor, Tivat";
					break;
					
				case 24 :  mestoRodjenja = "Herceg Novit";
					break;	
				
				case 25 :  mestoRodjenja = "Cetinje";
					break;
					
				case 26 :  mestoRodjenja = "Niksic";
					break;	
					
				case 27 :  mestoRodjenja = "Barane, Rozaje, Plav, Andrijevica";
					break;
					
				case 28 :  mestoRodjenja = "Bijelo Polje, Mojkovac";
					break;	
					
				case 29 :  mestoRodjenja = "Pljevlja, Zabljak";
					break;	
				
				default : mestoRodjenja = "Nije Poznato";
					break;
			
			}
			
		}
		
		
		// Rodjeni u Hrvatska
		
		
		else if ( regionRodjenja >= 30 && regionRodjenja < 40 ) {
			drzavaRodjenja = "Hrvatska";
			
			switch (regionRodjenja) {
			
				case 30 :  mestoRodjenja = "Osjek";
					break;	
				
				case 31 :  mestoRodjenja = "Podravina";
					break;	
				
				case 32 :  mestoRodjenja = "Medjimurje";
					break;	
				
				case 33 :  mestoRodjenja = "Zagreb";
					break;	
				
				case 34 :  mestoRodjenja = "Karlovac";
					break;	
				
				case 35 :  mestoRodjenja = "Lika";
				break;	
				
				case 36 :  mestoRodjenja = "Rijeka, Iskra";
					break;	
				
				case 37 :  mestoRodjenja = "Karlovac";
					break;	
				
				case 38 :  mestoRodjenja = "Dalmacija";
					break;	
					
				default : mestoRodjenja = "Nije Poznato";
					break;
	
			}
			
		}
		
		
		// Rodjeni u Makedonija
		
		
		else if ( regionRodjenja > 40 && regionRodjenja < 50 ) {
			drzavaRodjenja = "Makedonija";
			
			switch (regionRodjenja) {
			
				case 41 :  mestoRodjenja = "Bitola";
					break;
					
				case 42 :  mestoRodjenja = "Kumanovo";
					break;
					
				case 43 :  mestoRodjenja = "Ohrid";
					break;
				
				case 44 :  mestoRodjenja = "Prilep";
					break;
				
				case 45 :  mestoRodjenja = "Skoplje";
					break;
				
				case 46 : mestoRodjenja = "Strumica";
					break;
				
				case 47 :  mestoRodjenja = "Tetovo";
					break;
				
				case 48 :  mestoRodjenja = "Veles";
					break;
				
				case 49 :  mestoRodjenja = "Stip";
					break;
				
				default : mestoRodjenja = "Nije Poznato";
					break;

			}
			
		}
		
		
		// Rodjeni u Slovenija
		
		
		else if ( regionRodjenja >= 50 && regionRodjenja < 60 ) {
			drzavaRodjenja = "Slovenija";
			
			mestoRodjenja = "Slovenija";
			
			// Slovenija koristi samo broj 50 za celu drzavu
			
			
		}
		
		
		// Rodjeni u Srbija
		
			// Rodjeni u Uza Srbija ( Bez Pokrajna: Vojvodine i Kosova i Metohije )

		
		else if ( regionRodjenja > 70 && regionRodjenja < 80 ) {
			drzavaRodjenja = "Srbija";
			
			switch (regionRodjenja) {
			
				case 71 :  mestoRodjenja = "Beograd";
					break;
					
				case 72 :  mestoRodjenja = "Kragujevac, Jagodina";
				break;
				
				case 73 : mestoRodjenja = "Nis, Pirot, Toplica";
				break;
				
				case 74 :  mestoRodjenja = "Leskovac, Vranje";
				break;
				
				case 75 :  mestoRodjenja = "Bor, Zajecar";
				break;
				
				case 76 :  mestoRodjenja = "Smederevo, Pozarevac";
				break;
				
				case 77 :  mestoRodjenja = "Macva, Kolubara";
				break;
				
				case 78 :  mestoRodjenja = "Kraljevo, Krusevac";
				break;
				
				case 79 :  mestoRodjenja = "Uzice";
				break;
					
				default : mestoRodjenja = "Nije Poznato";
					break;
					
			}
			
		}
		
		
			// Rodjeni u Autonomska Pokrajina Vojvodina
		
		
		else if ( regionRodjenja >= 80 && regionRodjenja < 90 ) {
			drzavaRodjenja = "Srbija";
			
			switch (regionRodjenja) {
			
				case 80 :  mestoRodjenja = "Novi Sad";
					break;
				
				case 81 :  mestoRodjenja = "Sombor";
					break;
			
				case 82 :  mestoRodjenja = "Subotica";
					break;
			
				case 83 :  mestoRodjenja = "Vrbas";
					break;
			
				case 84 :  mestoRodjenja = "Kikinda";
					break;
			
				case 85 :  mestoRodjenja = "Zrenjanin";
					break;
			
				case 86 :  mestoRodjenja = "Pancevo";
					break;
			
				case 87 :  mestoRodjenja = "Vrsac";
					break;
			
				case 88 :  mestoRodjenja = "Ruma";
					break;
			
				case 89 :  mestoRodjenja = "Sremska Mitrovica";
					break;
			
				default : mestoRodjenja = "Nije Poznato";
					break;
		
			}
			
		}
		
		
			// Rodjeni u Kosovo i Metehija
		
		
		else if ( regionRodjenja > 90 && regionRodjenja < 99 ) {
			drzavaRodjenja = "Srbija";
			
			
			switch (regionRodjenja) {
			
				case 81 :  mestoRodjenja = "Pristina";
					break;
		
				case 92 :  mestoRodjenja = "Kosovksa Mitrovica";
					break;
		
				case 93 :  mestoRodjenja = "Pec";
					break;
		
				case 94 :  mestoRodjenja = "Djakovica";
					break;
		
				case 95 :  mestoRodjenja = "Prizren";
					break;
		
				case 96 :  mestoRodjenja = "Gnjilane";
					break;
		
				default : mestoRodjenja = "Nije Poznato";
					break;
	
			}
			
		}
		
		else {
			drzavaRodjenja = " Nije poznato";
			mestoRodjenja = " Nije poznato";		
		}
		
		System.out.println("Drzava rodjenja je: " + drzavaRodjenja + " Mesto Rodjenja je: " + mestoRodjenja);		
		
	}

	
	// Get i Set metode za Pol, Drzavu Rodjenja, Mesto Rodjenja i Gresku
	
	
	
	public String getPol() {
		return pol;
	}
	
	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}

	public String getMestoRodjenja() {
		return mestoRodjenja;
	}

	public int getGreska() {
		return greska;
	}

	public void setGreska(int greska) {
		this.greska = greska;
	}
	
	
}
