package MazoCartas;

public class Jugador {
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;


	public Jugador(String nombre){
		this.nombre = nombre;
		this.esGanador = false;
		this.cartas = new MazoCartas();
	}

	public String getNombre(){
		return nombre;
	}

	public void agarrarCarta(Carta carta){
		cartas.addCarta(carta); // agrega las cartas al mazo del jugador
	}

	public Carta getPrimeraCarta(){
		if(!cartas.esVacio()){
			return cartas.getPrimeraCarta();
		}
		return null;
	}

	public Atributo elegirAtributo(Carta carta){
		int cantAtributos = carta.cantAtributos();
		int atributoRandom = (int) (Math.random()*cantAtributos );
		Atributo atributoElegido = carta.atributoPorPosicion(atributoRandom);
		return atributoElegido;
	}

	public void gana(Carta cartaPerdedora){
		setEsGanador(true);
		cartas.addCarta(cartaPerdedora);
	}

	public void pierde(Carta cartaPerdedora){
		setEsGanador(false);
		cartas.eliminarCarta(cartaPerdedora);
	}

	public boolean esGanador(){
		return esGanador;
	}

	public void setEsGanador(boolean esGanador){
		this.esGanador = esGanador;
	}
	
	public MazoCartas getCartas(){
		return cartas;
	}
	public int mazoCartas(){
		return cartas.getMazoCompleto();
	}
	public String toString(){
		return this.getNombre();
	}
}
