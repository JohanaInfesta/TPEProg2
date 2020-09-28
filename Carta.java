import java.util.ArrayList;


public class Carta {
	
	private String nombre;
	private ArrayList <Atributos> atributos;
	
	public Carta(String nombre){
		this.nombre = nombre;
		atributos = new ArrayList<>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void addAtributos(String nombre, double valor){
		if(!tieneAtributo(nombre)){
			this.atributos.add(new Atributos(nombre, valor));
		}
	}
	
	public Atributos getAtributos (String nombre){
		for(int i = 0; i < atributos.size(); i++){
			if(atributos.get(i).getNombre().equals(nombre)){
				return atributos.get(i);
			}
		}
		return null;
	}
	
	public boolean tieneAtributo(String nombre){
		Atributos at = this.getAtributos(nombre);
		return (at != null);
	}
	
	public boolean tieneAtributo (Atributos at){
		return atributos.contains(at);
	}
		
	public String toString(){
		return this.getNombre();
	}
}
