package MazoCartas;

import java.util.ArrayList;

public class MazoCartas {
	private ArrayList <Carta> cartas;
	
	public MazoCartas(){
		cartas = new ArrayList <>();
	}
	
	public void addCarta(Carta c){
		cartas.add(c);
	}
	
	public String toString(){
		return cartas.toString();
	}
}
