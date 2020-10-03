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
	public String elegirAtributo(){
		if(cartas.getMazoCompleto() > 0) {
			int randomAttribute = (int) Math.random() * cartas.getMazoCompleto();
			return cartas.getPrimerCarta().getAtributos(nombre);// corregir: pedir lista de atributos, y usar randomAttribute
		}
	}
	public void gana(){
		
	}
	
	public void pierde(){
		
	}
	
	public String toString(){
		return this.getNombre();
	}
}
