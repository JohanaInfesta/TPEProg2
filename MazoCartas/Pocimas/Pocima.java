package MazoCartas.Pocimas;


public abstract class Pocima {
	private String nombre;
	private double valor;

	public Pocima (){}
	public Pocima(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public abstract double addPocima(String atr, double val);
		
	public boolean equals(Object obj){
		try{
			Pocima aux = (Pocima)obj;
			return this.getNombre().equals(aux.getNombre());
		}catch(Exception e){
			return false;
		}		
	}

}
