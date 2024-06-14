package org.generation.italy.model;


import java.util.ArrayList;

public class MobileApp {
	
	/* TODO Scrivere una classe MobileApp contenente i seguenti attributi:
nome: stringa
sistemaOperativo: stringa
prezzo: float
elencoRecensioni: ArrayList di Recensione
ricavoTotale: float
e i seguenti metodi:
MobileApp(String nome, String sistemaOperativo, float prezzo)
 (costruttore della classe: inizializza gli attributi nome,sistemaOperativo, prezzo in base ai parametri passati verificandola validità dei parametri; inizializza elencoRecensioni,
numeroValutazioni, ricavoTotale a 0)
download():
incrementa il ricavoTotale del valore del prezzo
download(int numeroDownload):
incrementa il ricavoTotale del valore del prezzo*numeroDownload
riceviRecensione(Recensione recensione):
l'app riceve una nuova recensione
float valutazioneMedia():
restituisce la media delle recensioni ricevute finora (nr stelle)
getter e setter (verificare la validità dei dati dei parametri dei setter)
Nella classe Main:
◦ chiedere all'utente di inserire nome, sistemaOperativo, prezzo
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
mobile app (valutazione media, ricavo totale)  */
	
	
	private String nome;
	private String sistemaOperativo;
	private float prezzo;
	private ArrayList<Recensione> elencoRecensioni;
	private float ricavoTot;
	
	
	public MobileApp(String nome, String sistemaOperativo, float prezzo) {
		if (nome ==null || nome.isBlank()) {
			throw new IllegalArgumentException("Il nome non può essere vuoto! Inserisci un nome corretto");
		}
		if(sistemaOperativo ==null || sistemaOperativo.isBlank()) {
			throw new IllegalArgumentException("Il sistema operativo non può essere vuoto. Inserisci un sistema operativo corretto");
		}
		if(prezzo <0) {
			throw new IllegalArgumentException("Il prezzo non può essere negativo!");
		}
		this.nome = nome;
		this.sistemaOperativo = sistemaOperativo;
		this.prezzo = prezzo;
		this.elencoRecensioni=new ArrayList<>();
		this.ricavoTot=0;
	}
	
	//Metodo Download Singolo
	public void download() {
		this.ricavoTot += this.prezzo;
	}
	
	//Metodo Più Download
	public void download (int numeroDownload) {
		if (numeroDownload <0) {
			throw new IllegalArgumentException("Il numero di download non può essere negativo");
		}
		this.ricavoTot += this.prezzo * numeroDownload;
	}
	
	//Metodo Nuova Recensione
	public void riceviRecensione(Recensione recensione) {
		if (recensione== null) {
			throw new IllegalArgumentException("La recensione non puo essere vuota");
		}
		this.elencoRecensioni.add(recensione);
	}
	
	//Metodo Calcolo valutazione media
	public float valutazioneMedia() {
		if (elencoRecensioni.isEmpty()) {
			return 0;
		}
		int sommaStelle =0;
		for(Recensione recensione : elencoRecensioni) {
			sommaStelle += recensione.getNumeroStelle();
		}
		return (float) sommaStelle/elencoRecensioni.size();
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome==null || nome.isBlank()) {
			throw new IllegalArgumentException("Il nome non può essere vuoto!");
		}
		this.nome = nome;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		if (sistemaOperativo==null || sistemaOperativo.isBlank()) {
			throw new IllegalArgumentException("Il sistema operativo non può essere vuoto!");
		}
		this.sistemaOperativo = sistemaOperativo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		if (prezzo <0) {
			throw new IllegalArgumentException("Il prezzo non può essere negativo");
		}
		this.prezzo = prezzo;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	

	public float getRicavoTot() {
		return ricavoTot;
	}

	@Override
	public String toString() {
		return "MobileApp [nome=" + nome + ", sistemaOperativo=" + sistemaOperativo + ", prezzo=" + prezzo
				+ ", elencoRecensioni=" + elencoRecensioni + ", ricavoTot=" + ricavoTot + "]";
	}

	
	
	
	
	
	
	
}
