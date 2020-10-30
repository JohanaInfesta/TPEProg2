package MazoCartas;

import java.util.ArrayList;

public class Carta {
	private String nombre;
	private ArrayList <Atributo> atributos;
	private Pocima pocima;

	//CONSTRUCTOR
	public Carta(String nombre){
		this.nombre = nombre;
		atributos = new ArrayList<>();
	}

	//METODOS
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

	public boolean tieneAtributo (Atributo at){
		return atributos.contains(at);
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

	public void addAtributos(String nombre, int valor){
		if(!tieneAtributo(nombre)){
			this.atributos.add(new Atributo(nombre, valor));
		}
	}

	public void agregarAtributo(Atributo atributo){//metodo creado porque lo pide el VisorMazo
		if(!tieneAtributo(atributo)){
			atributos.add(atributo);
		}
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

	public Atributo mismoAtributo(Atributo atributoElegido){ // metodo realizado para imprimir el mismo atributo elegido por el primer jugador
		Atributo igual = null;
		for(Atributo atr: atributos){
			if(atr.equals(atributoElegido)){
				igual = atr;
				return igual;
			}
		}
		return igual;
	}
	// 2DA PARTE
	public Pocima getPocima(){
		return pocima;
	}

	public void agregarPocima(Pocima pocima){
		pocima.addPocima(this);
	}

	// GET  
	public String getNombre(){
		return nombre;
	}

	public ArrayList <Atributo> getAtributos (){
		return this.atributos;
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
		return this.getNombre() + " " + this.atributos + pocima;
	}

}
