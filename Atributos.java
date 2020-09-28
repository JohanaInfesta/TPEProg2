
public class Atributos {
	/*Todos los atributos tienen un nombre y un valor numérico */
	
	private String nombre;
	private double valor;
	
	public Atributos(String nombre, double valor){
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
