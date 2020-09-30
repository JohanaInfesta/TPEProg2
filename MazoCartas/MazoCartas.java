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

	
	public void eliminarCarta(Carta cartaPerdedora){
		
	}
	
	public void repartirCarta(Jugador jugadorA, Jugador jugadorB){
		Collections.shuffle(cartas);
//		while(!cartas.isEmpty()){
//			jugadorA.agarrarCarta();
//			if(cartas.isEmpty()){
//				jugadorB.agarrarCarta();
//			}
//		}
		
		//jugador b = darCarta()
	}
	
	public int getMazoCompleto(){
		return cartas.size();
	}
	
	public String toString(){
		return cartas.toString();
	}
}
