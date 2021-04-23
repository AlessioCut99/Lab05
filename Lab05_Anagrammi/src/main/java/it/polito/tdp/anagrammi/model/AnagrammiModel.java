package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDao;

public class AnagrammiModel {
	
	AnagrammaDao anagrammaDAO = new AnagrammaDao();
	
	/**
	 * Il metodo si occupa di preparare la ricorsione per ottenere il Set di anagrammi
	 * @param parola - parola di cui trovare gli anagrammi
	 * @return - Set contenente gli anagrammi
	 */
	
	public Set<String> calcolaAnagrammi(String parola){
		Set<String> anagrammi = new HashSet<String>();
		String parziale = "";
		calcola(parziale,parola,0,anagrammi);
		return anagrammi;
	}
	
	
	
	/**
	 * Il metodo si occupa di verificare la correttezza dell'anagramma delegando al DAO
	 * @param anagramma
	 * @return
	 */
	
	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
	}
	

	
	/**
	 * Il metodo si occupa di compiere la ricorsione
	 * @param parziale - soluzione parziale
	 * @param parola - parola iniziale di cui si vogliono calcolare gli anagrammi
	 * @param passo - il livello della ricorsione
	 * @param anagrammi - il Set in cui si aggiungono i risultati
	 */
	
	private void calcola(String parziale,String parola, int passo, Set<String> anagrammi){
		
		if(passo == parola.length()){
			anagrammi.add(parziale);
			return;
		}
		
		for(int i = 0; i< parola.length(); i++){
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))){
				parziale += parola.charAt(i);
				calcola(parziale, parola, passo + 1,anagrammi);
				parziale = parziale.substring(0,parziale.length()-1);
			}
		}
			
	}
	
	

	/**
	 * Il metodo permette di ottenere il numero di volte in cui un carattere appare in una stringa.
	 * 
	 * @param string - La stringa in cui si effettua la ricerca
	 * @param c - Il carattere che si ricerca
	 * @return l'intero corrispondente al numero di volte in cui c appare in string
	 */
	
	private static int charCounter(String string, char c){
		int count = 0;
	    for (int i=0; i < string.length(); i++)
	    {
	        if (string.charAt(i) == c)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	

}