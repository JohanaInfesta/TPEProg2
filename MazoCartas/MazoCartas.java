package MazoCartas;

import java.util.ArrayList;
import java.util.Collections;

public class MazoCartas {

	private ArrayList <Carta> cartas;

	//CONSTRUCTOR
	public MazoCartas(){
		cartas = new ArrayList<>();
	}	
	
	//METODOS
	public void addCarta(Carta c){
		if(cartas.isEmpty())
			cartas.add(c);
		else{
			if(compararCartas(c)){
				cartas.add(c);
			}
		}
	}

	//COMPARAR LAS CARTAS A AGREGAR AL MAZO CON LA PRIMERA
	public boolean compararCartas(Carta c){
		Carta primera = cartas.get(0);
		return primera.comparar(c);
	}

	public void mezclar(){
		Collections.shuffle(cartas);
	}

	//ELIMINA LA PRIMERA CARTA DEL MAZO
	public Carta eliminarPrimeraCarta(){
		return this.cartas.remove(0);
	}

	public boolean existe (Carta carta){
		return cartas.contains(carta);
	}

	public void eliminarCarta(Carta cartaPerdedora){
		if(existe(cartaPerdedora)){
			cartas.remove(cartaPerdedora);
		}
	}

	public boolean esVacio(){//lo puse porque sino no puedo preguntar si el mazo en la clase jugador es vacio o no
		return cartas.isEmpty();
	}

	public int size(){
		return cartas.size();
	}
	
	//GET 
	public Carta getPrimeraCarta(){
		return getMazo().get(0);
	}

	private ArrayList<Carta> getMazo(){
		return new ArrayList<>(cartas);
	}
	public String toString(){
		return cartas.toString();
	}

}
