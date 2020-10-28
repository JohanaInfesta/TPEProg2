package MazoCartas;

import java.util.ArrayList;

public class PocimaReducePorcentaje extends Pocima {

	public PocimaReducePorcentaje(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> carta = cartas.getAtributos();
		for(Atributo c:carta){
			double valor = c.getValor();
			double porcentaje = valor - valor * super.getValor();
			c.setValor(porcentaje);
		}
		return carta;
	}

}
