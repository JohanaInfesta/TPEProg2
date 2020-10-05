package MazoCartas;

import java.util.ArrayList;
import java.util.Collections;

public class MazoCartas {
	private ArrayList <Carta> cartas;

	public MazoCartas(){
		cartas = new ArrayList <>();
	}

	public void addCarta(Carta c){
		if(cartas.isEmpty())
			cartas.add(c);
		else
			if(compararCartas(c)){
				cartas.add(c);
			}
	}
	public boolean compararCartas(Carta c){
		Carta primera = cartas.get(0);
		return primera.comparar(c);
	}
	public Carta darCarta(){
		return cartas.remove(0); //elimina la primera carta del mazo
	}

	public void repartirCarta(Jugador jugadorA, Jugador jugadorB){
		Collections.shuffle(cartas); // mezcla las cartas del mazo
		while(!cartas.isEmpty()){
			jugadorA.agarrarCarta(this.darCarta()); // cuando da la primera carta se elimina automaticamente dek mazo con el metodo darCarta
			if(cartas.isEmpty()){
				jugadorB.agarrarCarta(this.darCarta());
			}
		}

	}


	public void eliminarCarta(Carta cartaPerdedora){

	}

	
	public int getMazoCompleto(){
		return cartas.size();
	}

	public String toString(){
		return cartas.toString();
	}

	public boolean esVacio(){//lo puse porque sino no puedo preguntar si el mazo en la clase jugador
		return cartas.isEmpty();//es vacio o no
	}
	public Carta getPrimeraCarta(){
		if(!cartas.isEmpty()){
			return cartas.get(0);
		}
		return null;
	}
}
