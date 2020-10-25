package zajecia1;
import java.util.Scanner;
public class kolkoKrzyzyk {

	public static void main(String[] args) {
		int licznik = 0;
		int wymiar = 3;
		char plansza [][] = { { '_', '_', '_' }, 
				{ '_', '_', '_' }, { '_', '_', '_' } };
			
		char gracz = 'X';
		while (true) {
			drukujPlansze(plansza);
			boolean ruchPoprawny = ruch(plansza, gracz);
						
			if(ruchPoprawny) {
				boolean wygranaWiersze = sprawdzWiersze(plansza, gracz);
				boolean wygranaKolumny = sprawdzKolumny(plansza, gracz);
				boolean wygranaSkos1 = sprawdzSkos1(plansza, gracz);
				boolean wygranaSkos2 = sprawdzSkos2(plansza, gracz);

				if(wygranaWiersze || wygranaKolumny || wygranaSkos1)
					System.out.println("Gratulacje, wygrywa: " + gracz);			
			}			
		}
	}
	
	
	public static boolean sprawdzWiersze(char plansza [][], char gracz) {
		int wymiar = plansza.length;
		for(int wiersz = 0; wiersz<wymiar; wiersz++) {
			boolean wygrana = true;
			for(int kolumna = 0; kolumna<wymiar; kolumna++) {
				if(plansza[wiersz][kolumna] != gracz) {
					wygrana = false;
				}
			}
			if(wygrana) {
				return true;
			}
		}return false;
	}
	public static boolean sprawdzKolumny(char plansza [][], char gracz) {
		int wymiar = plansza.length;
		for(int kolumna = 0; kolumna<wymiar; kolumna++) {
			boolean wygrana = true;
			for(int wiersz = 0; wiersz<wymiar; wiersz++) {
				if(plansza[wiersz][kolumna] != gracz) {
					wygrana = false;
				}
			}
			if(wygrana) {
				return true;
			}
		}return false;
	}
	public static boolean sprawdzSkos1(char plansza [][], char gracz) {
		return plansza[0][0] == plansza [1][1] && plansza [1][1] == plansza[2][2] && plansza[2][2] == gracz;
	}
	public static boolean sprawdzSkos2(char plansza [][], char gracz) {
		return plansza[0][2] == plansza[1][1] && plansza[1][1] == plansza[2][0] && plansza[1][1] == gracz;
	}
	
	public static boolean ruch(char plansza [][], char gracz) {
		int licznik =0;
		System.out.println();
		
		gracz = gracz == 'X' ? 'O' : 'X';

		while (licznik < 9) {
			gracz = gracz == 'X' ? 'O' : 'X';

			System.out.println(gracz + ", twój ruch");
			int wymiar = 3;
			
			System.out.println("Podaj indeks wiersza");
			int wiersz = new Scanner(System.in).nextInt();
			
			if (wiersz < 0 || wiersz > wymiar) {
				System.out.println("B³êdne wartoœci");
				licznik--;
				continue;
			}
			
			System.out.println("Podaj indeks kolumny");
			int kolumna = new Scanner(System.in).nextInt();
			
			if (kolumna <0 || kolumna >wymiar) {
				System.out.println("B³êdne wartoœci");
				licznik--;
				continue;
			}				
		
			boolean wolne = plansza[wiersz][kolumna] == '_';

			if (!wolne) {
				System.out.println("Pole zajête, wybierz inne.");
				return false;
			}
			
			plansza[wiersz][kolumna] = gracz;
			
			drukujPlansze(plansza);
		}
		gracz = gracz == 'X' ? 'O' : 'X';
		return true;
		

	}
	
	public static void drukujPlansze(char[][] plansza) {
		int wymiar = 3;

		System.out.print("   ");

		for(int i = 0; i<wymiar; i++) {
			System.out.print(i + " " );
		}
		System.out.println();

		for (int wiersz = 0; wiersz<plansza.length; wiersz++) {
			System.out.print(wiersz + ": " );
			for(int kolumna=0; kolumna<plansza[wiersz].length; kolumna++) {
				System.out.print(plansza[wiersz][kolumna]+ " ");
			}
			System.out.println();
		}
	}
	

}
