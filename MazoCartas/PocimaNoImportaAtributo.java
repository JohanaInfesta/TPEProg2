package MazoCartas;

import java.util.ArrayList;

public class PocimaNoImportaAtributo extends Pocima {

	public PocimaNoImportaAtributo(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> cartaConPocima = new ArrayList<>(); 
		ArrayList<Atributo> carta = cartas.getAtributos();
		for(Atributo a:carta){
//			double aux = a.setValor(this.getValor());
//			cartaConPocima.addAll(aux);
		}
		return null;
	}

}
