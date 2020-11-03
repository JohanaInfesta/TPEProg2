package MazoCartas.Pocimas;


public class PocimaReducePorcentaje extends Pocima {

	public PocimaReducePorcentaje(String nombre, double valor) {
		super(nombre, valor);
	}


	@Override
	public double addPocima(String atr, double val) {
		double valor = val - (val * this.getValor());
		return valor;
	}

}
