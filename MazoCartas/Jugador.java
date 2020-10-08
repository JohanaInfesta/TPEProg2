package MazoCartas;

public class Jugador {
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;


	public Jugador(String nombre){
		this.nombre = nombre;
		this.esGanador = false;
	}

	public String getNombre(){
		return nombre;
	}

	public void agarrarCarta(Carta carta){
		cartas.addCarta(carta); // agrega las cartas al mazo del jugador
	}

	public Carta getPrimeraCarta(){
		if(!cartas.esVacio()){
			cartas.getPrimeraCarta();
		}
		return null;
	}

	public Atributo elegirAtributo(Carta carta){
		int cantAtributos = carta.cantAtributos();
		int atributoRandom = (int) (Math.random()*cantAtributos - 1 );
		Atributo atributoElegido = carta.atributoPorPosicion(atributoRandom);
		return atributoElegido;
	}

	public void gana(){

	}

	public void pierde(){

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
	public String toString(){
		return this.getNombre();
	}
}
