package MazoCartas;

public class Atributo {
	private String nombre;
	private double valor;
	
	//CONSTRUCTOR
	public Atributo(String nombre, double valor){
		this.nombre = nombre;
		this.valor = valor;
	}

	// GET - SET
	public String getNombre() {
		return nombre;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor){
		this.valor = valor;
	}

	public boolean equals (Object obj){
		try{
			Atributo aux = (Atributo)obj;
			return this.getNombre().equals(aux.getNombre());
		}catch(Exception e){
			return false;
		}
	}
	
	public String toString(){
		return this.getNombre()+": "+this.getValor();
	}
}
