package MazoCartas;

import java.util.ArrayList;

import MazoCartas.Pocimas.Pocima;

public class Carta {
	private String nombre;
	private ArrayList <Atributo> atributos;
	private Pocima pocima;

	//CONSTRUCTOR
	public Carta(String nombre){
		this.nombre = nombre;
		atributos = new ArrayList<>();
		pocima = null;
	}

	//METODOS
	public Atributo getAtributo(String nombreAtributo) {
		for(int i = 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(nombreAtributo)) {
				return atributos.get(i);
			}
		}
		return null;
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

	public void agregarAtributo(Atributo atributo){//metodo creado porque lo pide el VisorMazo
		if(!atributos.contains(atributo)){
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

	// 2DA PARTE
	//TRAE EL VALOR DEL ATRIBUTO ELEGIDO
	public double getValorAtributo(String atributoElegido){
		Atributo atr = this.getAtributo(atributoElegido);
		if(pocima != null){
			return this.getAddPocima(atr.getNombre(), atr.getValor());
		}else{
			return atr.getValor();
		}
	}
	//AGREGA LA POCIMA A UN ATRIBUTO ESPECIFICO Y SU VALOR
	public double getAddPocima(String nombre, double val){
		return pocima.addPocima(nombre, val);
	}

	//DEVUELVE EL STRING CON EL VALOR MODIFICADO DEL ATRIBUTO AL QUE SE LE AGREGO LA POCIMA
	public String aplicarPocima(String nombre){
		if(pocima != null){
			Atributo atr = this.getAtributo(nombre);
			double valor = this.getAddPocima(atr.getNombre(), atr.getValor());
			if(atr.getValor() == valor){
				return "";
			}else{
				return " se aplico pocima " + pocima.getNombre() + " valor resultante " + pocima.addPocima(nombre, atr.getValor());
			}
		}
		return "";
	}

	public void setPocima(Pocima pocima){
		this.pocima = pocima;
	}

	// GET  
	public String getNombre(){
		return nombre;
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
