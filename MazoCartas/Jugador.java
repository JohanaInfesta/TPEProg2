package MazoCartas;

public class Jugador {
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;


	/* jugar Carta */

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

	public Atributo elegirAtributo(){
		if(cartas.getMazoCompleto() > 0) {
			int randomAttribute = (int) Math.random() * cartas.getMazoCompleto();
			return cartas.getPrimeraCarta().getAtributos(nombre);// corregir: pedir lista de atributos, y usar randomAttribute
		}
		return null;
	}
	//no se muy bien como hay que hacer esta parte.. habria que consultar

	public void gana(){

	}

	public void pierde(){

	}

	public String toString(){
		return this.getNombre();
	}
}
