package MazoCartas.Jugador;

import MazoCartas.Carta;
import MazoCartas.MazoCartas;


public abstract class Jugador {
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;

	//CONSTRUCTOR
	public Jugador(String nombre){
		this.nombre = nombre;
		this.esGanador = false;
		this.cartas = new MazoCartas();
	}
	//2DA PARTE
	public abstract String elegirAtributo(Carta carta);
	
	//METODOS
	public void agarrarCarta(Carta carta){
		cartas.addCarta(carta);
	}

	public void gana(Carta cartaPerdedora){
		Carta ganadora = cartas.getPrimeraCarta();
		setEsGanador(true);
		cartas.addCarta(cartaPerdedora);
		cartas.addCarta(ganadora);
		cartas.darCarta();
	}

	public void pierde(Carta cartaPerdedora){
		setEsGanador(false);
		cartas.eliminarCarta(cartaPerdedora);
	}

	public boolean esGanador(){
		return esGanador;
	}

	public void empate(Carta carta){
		cartas.addCarta(carta);
		cartas.darCarta();
	}
	
	// GET - SET
	public int mazoCartas(){
		return cartas.getMazoCompleto();
	}

	public MazoCartas getCartas(){
		return cartas;
	}

	public String getNombre(){
		return nombre;
	}

	public void setEsGanador(boolean esGanador){
		this.esGanador = esGanador;
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
