package MazoCartas;

import java.util.ArrayList;

public abstract class FormaAplicarPocima {

	protected static String nombre;
	
	public FormaAplicarPocima(String nombre){
		this.setNombre(nombre);
	}
	public abstract ArrayList<Atributo> getAplicarPocima(ArrayList <Atributo> atributos);
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
