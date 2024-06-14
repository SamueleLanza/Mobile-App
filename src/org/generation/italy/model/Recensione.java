package org.generation.italy.model;

import java.time.LocalDate;

public class Recensione {
	/* TODO Scrivere una classe “Recensione” che contiene i seguenti attributi:
LocalDate data
String nomeUtente
int numeroStelle
String testo
e opportuni metodi costruttore, getters, setters, facendo in modo che non
si possa creare un’istanza non valida di Recensione (ad esempio il
numero di stelle deve essere compreso tra 1 e 5)
*/
	
	
	private LocalDate data;
	private String nomeUtente;
	private int numeroStelle;
	private String testo;
	
	
	
	
	
	public Recensione(LocalDate data, String nomeUtente, int numeroStelle, String testo) {
		if (numeroStelle<1 || numeroStelle >5 ) {
			throw new IllegalArgumentException("Il numero delle stelle deve esser compreso tra 1-5 ");
		}
		this.data = data;
		this.nomeUtente = nomeUtente;
		this.numeroStelle = numeroStelle;
		this.testo = testo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public int getNumeroStelle() {
		return numeroStelle;
	}
	public void setNumeroStelle(int numeroStelle) {
		if (numeroStelle <1 || numeroStelle >5) {
			throw new IllegalArgumentException("Il numero delle stelle deve esser compreso tra 1-5 ");
		}
		this.numeroStelle = numeroStelle;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
	@Override
	public String toString() {
		return "Recensione [data=" + data + ", nomeUtente=" + nomeUtente + ", numeroStelle=" + numeroStelle + ", testo="
				+ testo + "]";
	}
	
	
	
	
	
	
}
