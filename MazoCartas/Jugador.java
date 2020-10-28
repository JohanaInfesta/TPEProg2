package MazoCartas;


public abstract class Jugador {
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;
//	private MazoCartas pocimas;

	//CONSTRUCTOR
	public Jugador(String nombre){
		this.nombre = nombre;
		this.esGanador = false;
		this.cartas = new MazoCartas();
//		this.pocimas = new MazoCartas();
	}

	//METODOS
	public void agarrarCarta(Carta carta){
		cartas.addCarta(carta);
	}
	
	public abstract Atributo elegirAtributo(Carta carta);


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
