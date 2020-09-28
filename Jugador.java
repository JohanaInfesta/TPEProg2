
public class Jugador {
	
	private String nombre;
	
	/*private ArrayList <Carta> cartas
	 * agrego las cartas a el jugador */
	
	/* jugar Carta */
	
	public Jugador(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String toString(){
		return this.getNombre();
	}
}
