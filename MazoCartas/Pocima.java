package MazoCartas;

import java.util.ArrayList;

public class Pocima{
	private FormaAplicarPocima pocimas;
	private String nombre;
	private double porcentaje;
	private int valor;
	private Atributo atributos;
	//CONSTRUCTOR
	public Pocima(){};

	public Pocima (String nombre, double porcentaje){
		this.nombre = nombre;
		this.setPorcentaje(porcentaje);
	}
	public Pocima (String nombre, int valor){
		this.nombre = nombre;
		this.valor = valor;
	}

	//METODOS
	public boolean aplicaPocima(){
		return pocimas.getAplicarPocima();
	}
	
	//GET - SET
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
