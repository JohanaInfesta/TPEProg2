package MazoCartas;

public class Atributo {
	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor){
		this.nombre = nombre;
		this.valor = valor;
	}

	public boolean ganador(Atributo atValor){
		return this.valor > atValor.getValor();
	}
	
	public boolean empate(Atributo atValor){
		return this.valor == atValor.getValor();
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getValor() {
		return valor;
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
