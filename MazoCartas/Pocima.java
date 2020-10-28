package MazoCartas;

import java.util.ArrayList;

public abstract class Pocima {

	private String nombre;
	private double valor;
	private Carta carta;
	public Pocima(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public abstract ArrayList<Atributo> addPocima(Carta cartas);

	public double getValor() {
		return valor;
	}
	
	
}
