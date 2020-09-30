package MazoCartas;

public class Atributo {
	private String nombre;
	private double valor;
	
	public Atributo(String nombre, double valor){
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public double getValor() {
		return valor;
	}

	public String toString(){
		return this.getNombre()+": "+this.getValor();
	}
}
