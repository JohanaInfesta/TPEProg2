package MazoCartas;

import MazoCartas.Estrategia.Estrategia;

public class Jugador {
	private String nombre;
	private MazoCartas cartas;
	private Estrategia estrategia;
	
	//CONSTRUCTOR
	public Jugador(String nombre, Estrategia estrategia){
		this.nombre = nombre;
		this.cartas = new MazoCartas();
		this.estrategia = estrategia;
	}
	//2DA PARTE
	//ESTRATEGIA IMPLEMENTADA DEPENDIENDO DE QUE TIPO DE JUGADOR SEA
	public void setEstrategia(Estrategia estrategia){
		this.estrategia = estrategia;
	}
	//DEVUELVE EL ATRIBUTO ELEGIDO EN LA ESTRATEGIA
	public String elegirAtributo(Carta c){
		return estrategia.elegirAtributo(c);
	}
	
	//METODOS
	public void agarrarCarta(Carta carta){
		cartas.addCarta(carta);
	}
	
	//CUANDO GANA AGREGA LA CARTA DEL PERDEDOR A SU MAZO Y PASO LA PRIMER CARTA GANADORA AL FONDO DEL MAZO
	public void gana(Carta cartaPerdedora){
		Carta ganadora = cartas.getPrimeraCarta();
		cartas.addCarta(cartaPerdedora);
		cartas.addCarta(ganadora);
		cartas.eliminarPrimeraCarta();
	}
	
	//LE SACO LA CARTA PERDEDORA AL JUGADOR QUE PERDIO
	public void pierde(Carta cartaPerdedora){
		cartas.eliminarCarta(cartaPerdedora);
	}


	//CUANDO ES EMPATE LA CARTA PASA AL FONDO DEL MAZO DEL JUGADOR
	public void empate(Carta carta){
		cartas.addCarta(carta);
		cartas.eliminarPrimeraCarta();
	}
	
	// GET - SET
	public int mazoCartas(){
		return cartas.size();
	}

	public String getNombre(){
		return nombre;
	}

	public Carta getPrimeraCarta(){
		if(!cartas.esVacio()){
			return cartas.getPrimeraCarta();
		}
		return null;
	}

	public String toString(){
		return this.getNombre();
	}

}
