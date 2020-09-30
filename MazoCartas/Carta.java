package MazoCartas;

import java.util.ArrayList;

public class Carta {
	private String nombre;
	private ArrayList <Atributo> atributos;
	
	public Carta(String nombre){
		this.nombre = nombre;
		atributos = new ArrayList<>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void addAtributos(String nombre, double valor){
		if(!tieneAtributo(nombre)){
			this.atributos.add(new Atributo(nombre, valor));
		}
		/*hay una carta que no pertenece al mazo en el json y hay que comprobar que no se agrege*/ 
	}
	
	public Atributo getAtributos (String nombre){
		for(int i = 0; i < atributos.size(); i++){
			if(atributos.get(i).getNombre().equals(nombre)){
				return atributos.get(i);
			}
		}
		return null;
	}
	
	public boolean tieneAtributo(String nombre){
		Atributo at = this.getAtributos(nombre);
		return (at != null);
	}
	
	public boolean tieneAtributo (Atributo at){
		return atributos.contains(at);
	}
		
	public String toString(){
		return this.getNombre();
	}
}
