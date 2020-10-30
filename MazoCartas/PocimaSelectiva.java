package MazoCartas;

import java.util.ArrayList;


public class PocimaSelectiva extends Pocima {

	
	public PocimaSelectiva(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public Atributo addPocima(Atributo atr) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> atributoCarta = cartas.getAtributos();
//		ArrayList<Atributo> aux = new ArrayList<Atributo>();
		for(int i = 0 ; i < atributoCarta.size(); i++){
//			aux.add(atributoCarta.get(i));
//			if(aux.get(i).getNombre().contains(super.getNombre().toLowerCase())){
			atributoCarta.get(i).setValor(super.getValor());
//			}
		}
		return atributoCarta;
	}	
	
}
