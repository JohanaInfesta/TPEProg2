package MazoCartas;

import java.util.ArrayList;
import java.util.Collections;

import MazoCartas.Jugador.Jugador;
import MazoCartas.Pocimas.Pocima;

public class MazoCartas {

	private ArrayList <Carta> cartas;
	private ArrayList <Pocima> pocima;

	//CONSTRUCTOR
	public MazoCartas(){
		cartas = new ArrayList<>();
		pocima = new ArrayList<>();
	}

	//2DA PARTE
	public void addPocima(Pocima p){
		pocima.add(p);
	}
	public int mazoPocima(){
		return pocima.size();
	}
	public void pocimas(){
		while(!(pocima.size() >= cartas.size())){
			pocima.add(null); // el arreglo de pocima tiene el mismo tamaño que cartas
		}
		Collections.shuffle(pocima);
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

	public boolean compararCartas(Carta c){
		Carta primera = cartas.get(0);
		return primera.comparar(c);
	}

	public void repartirCarta(Jugador jugadorA, Jugador jugadorB){
		Collections.shuffle(cartas); pocimas(); // mezcla las cartas del mazo
		while(!cartas.isEmpty()){
			if(pocima.size()>0){
				getPrimeraCarta().setPocima(pocima.get(0));// le asigno una pocima a la primera carta del mazo
				pocima.remove(0);
			}
			jugadorA.agarrarCarta(darCarta());// cuando da la primera carta se elimina automaticamente del mazo con el metodo darCarta
			if(!cartas.isEmpty()){
				jugadorB.agarrarCarta(darCarta());
			}
		}
	}

	public Carta darCarta(){
		return this.cartas.remove(0); //elimina la primera carta del mazo
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

	//GET 
	public Carta getPrimeraCarta(){
		return getMazo().get(0);
	}

	public int getMazoCompleto(){
		return cartas.size();
	}

	public ArrayList<Carta> getMazo(){
		return new ArrayList<>(cartas);
	}
	public String toString(){
		return cartas.toString();
	}

}
