package MazoCartas;

import java.util.ArrayList;

public class PocimaNoImportaAtributo extends Pocima {

	public PocimaNoImportaAtributo(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public Atributo addPocima(Atributo atr) {
//		Atributo atributo = new Atributo(atr.getNombre(), super.getValor());
//		return atributo;
//	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> atributoCarta = cartas.getAtributos();
		ArrayList<Atributo> aux = new ArrayList<Atributo>();
		for(int i = 0 ; i < atributoCarta.size(); i++){
			aux.add(atributoCarta.get(i));
			aux.get(i).setValor(super.getValor());
		}
		return aux;
	}
}
