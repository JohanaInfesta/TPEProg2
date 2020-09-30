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
//	public Atributo elegirAtributo(){
//		
//	}
	public void gana(){
		
	}
	
	public void pierde(){
		
	}
	
	public String toString(){
		return this.getNombre();
	}
}
