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

	public void addAtributos(String nombre, int valor){
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

//	public boolean tieneAtributo (Atributo at){
//		return atributos.contains(at);
//	} // tengo que implementar equals para usar este metodo

	public String toString(){
		return this.getNombre();
	}

	public boolean comparar(Carta c) {
		for(int i = 0; i< atributos.size(); i++){
			Atributo atr = atributos.get(i);
			if(!c.tieneAtributo(atr.getNombre())){
				return false;
			}
		}
		return true;
	}
}
