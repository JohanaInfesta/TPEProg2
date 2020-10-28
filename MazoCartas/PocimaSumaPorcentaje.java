package MazoCartas;

import java.util.ArrayList;

public class PocimaSumaPorcentaje extends Pocima {

	public PocimaSumaPorcentaje(String nombre, double valor) {
		super(nombre, valor);
	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> cartaConPocima = new ArrayList<>(); 
		ArrayList<Atributo> carta = cartas.getAtributos();
		for(Atributo c:carta){
//			double porcentaje = c.getValor() + c.getValor() * super.getValor();
//			cartaConPocima.addAll(c.setValor(porcentaje));
		}
		return cartaConPocima;
	}

}
