package MazoCartas;

import java.util.ArrayList;

public class PocimaNoImportaAtributo extends Pocima {

	public PocimaNoImportaAtributo(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
		ArrayList<Atributo> carta = cartas.getAtributos();
		for(Atributo c:carta){
			double valor = c.getValor();
			valor = super.getValor();
			c.setValor(valor);
		}
		return carta;
	}

}
