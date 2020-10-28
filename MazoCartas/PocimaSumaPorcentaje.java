package MazoCartas;

import java.util.ArrayList;

public class PocimaSumaPorcentaje extends Pocima {

	public PocimaSumaPorcentaje(String nombre, double valor) {
		super(nombre, valor);
	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> carta = cartas.getAtributos();
		for(Atributo c:carta){
			double valor = c.getValor();
			double porcentaje = valor + valor * super.getValor();
			c.setValor(porcentaje);
		}
		return carta;
	}

}