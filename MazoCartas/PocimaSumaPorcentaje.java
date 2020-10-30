package MazoCartas;

import java.util.ArrayList;

public class PocimaSumaPorcentaje extends Pocima {

	public PocimaSumaPorcentaje(String nombre, double valor) {
		super(nombre, valor);
	}
//
//	@Override
//	public Atributo addPocima(Atributo atr) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> atributoCarta = cartas.getAtributos();
		ArrayList<Atributo> aux = new ArrayList<Atributo>();
		for(int i = 0 ; i < atributoCarta.size(); i++){
			aux.add(atributoCarta.get(i));
			double porcentaje = atributoCarta.get(i).getValor() + atributoCarta.get(i).getValor() * super.getValor();
			aux.get(i).setValor(porcentaje);

		}
		return aux;
	}
}
