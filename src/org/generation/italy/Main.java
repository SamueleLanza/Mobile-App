package org.generation.italy;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;

public class Main {

	public static void main(String[] args) {
		/* TODO chiedere all'utente di inserire nome, sistemaOperativo, prezzo
		dell'app
		◦ creare un oggetto della classe MobileApp passando al costruttore i
		parametri inseriti dall'utente
		◦ creare un menu con le seguenti voci:
		▪ download singolo
		▪ download multiplo (in questo caso chiedere all'utente il numero di
		download da effettuare)
		▪ ricevi recensione (in questo caso chiedere all'utente il nome, il
		stelle da assegnare, il testo della recensione; impostare la data
		automaticamente al giorno corrente)
		▪ visualizza recensioni
		▪ esci
		◦ dopo ogni chiamata ad una voce di menu visualizzare i dati della
		mobile app (valutazione media, ricavo totale)*/
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Inserire il nome dell'app: ");
		String nomeApp=sc.nextLine();
		
		System.out.println("Inserisci il sistema operativo: ");
		String sistemaOperativo =sc.nextLine();
		
		float prezzo=0;
		boolean inputValido= false;
		
		while (!inputValido) {
			try {
				System.out.println("Inserisci il prezzo dell'app: ");
				prezzo =sc.nextFloat();
				if (prezzo <0) {
					throw new IllegalArgumentException("Il prezzo non può essere negativo!");
				}
				inputValido=true;
			} catch (InputMismatchException e) {
				System.out.println("Input non valido! Inserisci un valore numerico");
				sc.nextLine();
			}catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		sc.nextLine();
		
		MobileApp mobileApp= new MobileApp(nomeApp, sistemaOperativo, prezzo);
		
		//Menu
		boolean esci= false;
		
		while (!esci) {
			System.out.println("========");
			System.out.println("Menu");
			System.out.println("========");
			System.out.println("\n1. Download singolo");
			System.out.println("2. Download multiplo");
			System.out.println("3. Ricevi recensione");
			System.out.println("4. Visualizza recensioni");
			System.out.println("5. Esci");
			System.out.println("Scelta: ");
			
			int scelta=0;
			
			try {
				scelta= sc.nextInt();
				sc.nextLine();
			}catch (InputMismatchException e) {
				System.out.println("Inserici un numero corrispondente al menu");
				sc.nextLine();
				continue;
			}
			
			switch (scelta) {
			case 1: {
				mobileApp.download();
				break;
			}
			case 2: {
				System.out.println("Inserisci il numero di download da effettuare: ");
				int numeroDownload= sc.nextInt();
				sc.nextLine();
				mobileApp.download(numeroDownload);
				break;
			}
			case 3: {
				System.out.println("Inserisci il nome di scrive la recensione: ");
				String nomeRecensore= sc.nextLine();
				
				int stelle=0;
				inputValido=false;
				while (!inputValido) {
					try {
						System.out.println("Inserisci il numero di stelle (da 1-5): ");
						stelle=sc.nextInt();
						
						if (stelle <1 || stelle >5) {
							throw new IllegalArgumentException("Il numero di stelle deve essere compreso tra 1 e 5");
						}
						inputValido= true;
					}catch (InputMismatchException e) {
						System.out.println("Inserisci un numero corretto al numero di stelle");
					}
					catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				}
				sc.nextLine();
				
				System.out.println("Inserisci  la recensione: ");
				String testoRecensione=sc.nextLine();
				
				Recensione recensione =new Recensione(LocalDate.now(),nomeRecensore, stelle, testoRecensione);
				mobileApp.riceviRecensione(recensione);
				break;
				
			}
			case 4: {
				System.out.println("\nRecensioni: ");
				for (Recensione r:mobileApp.getElencoRecensioni()) {
					System.out.println(r);
				}
				break;
			}
			
			case 5: {
				esci =true;
				break;
			}
			
			
			
			default:
				System.out.println("Scelta non valida! Riprova");
				break;
			}
			
			//dati aggiornati dell'app
			System.out.println("\nDati dell'app aggiornati: ");
			System.out.println("Valutazione media: "+mobileApp.valutazioneMedia());
			System.out.println("Ricavo totale: "+mobileApp.getRicavoTot());
			
		}
		sc.close();
		System.out.println("Arrivederci! :D");
		
		
	}

}
