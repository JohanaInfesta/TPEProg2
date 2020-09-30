package MazoCartas;

public class Atributo {
	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor){
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public int getValor() {
		return valor;
	}

	public String toString(){
		return this.getNombre()+": "+this.getValor();
	}
}
