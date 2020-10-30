package MazoCartas;

import java.util.ArrayList;

public abstract class Pocima {
	private String nombre;
	private double valor;

	public Pocima (){}
	public Pocima(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public abstract ArrayList<Atributo> addPocima(Carta cartas);
	
//	public abstract Atributo addPocima(Atributo atr);

	public double getValor() {
		return valor;
	}
	public String getNombre() {
		return nombre;
	}
	public String toString(){
		return "Pocima " + getNombre();
	}
	
	public boolean equals(Object obj){
		try{
			Pocima aux = (Pocima)obj;
			return this.getNombre().equals(aux.getNombre());
		}catch(Exception e){
			return false;
		}		
	}

}
