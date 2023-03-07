package it.polito.tdp.Lab01.model;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private LinkedList <String> listaParole;
		
	public Parole() {
		listaParole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void cancella(String s) {
		listaParole.remove(s);
	}

}