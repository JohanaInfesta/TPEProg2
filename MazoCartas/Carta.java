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
	}
	
	public Atributo getAtributo(String nombreAtributo) {
		Atributo atributo = null;
		for(int i = 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(nombreAtributo)) {
				atributo = atributos.get(i);
				i = atributos.size() + 1; //para que no siga recorriendo despues de encontrar el atributo
			}
		}
		return atributo;//tiene que estar inicializada si o si para que realice el return
	}

	public ArrayList <Atributo> getAtributos (){
		
		return this.atributos;
	}

	public boolean tieneAtributo(String nombre){
		Atributo at = this.getAtributo(nombre);
		return (at != null);
	}

	public int cantAtributos(){
		return atributos.size();//devuelve la cantidad de los atributos por carta
	}
	
	public Atributo atributoPorPosicion(int atributoPosicion){
		Atributo at = atributos.get(atributoPosicion); 
		return at; //devuelve la posicion del atributo elegido
	}
	
	public boolean tieneAtributo (Atributo at){
		return atributos.contains(at);
	} // tengo que implementar equals para usar este metodo
	
	public void agregarAtributo(Atributo atributo){//metodo creado porque lo pide el VisorMazo
		if(!tieneAtributo(atributo)){
			atributos.add(atributo);
		}
	}
	
	public boolean equals(Object obj) {
		try {
			Carta aux = (Carta) obj;
			return this.getNombre().equals(aux.getNombre());
		} catch (Exception e) {
			return false;
		}
	}
	
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
