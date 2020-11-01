package MazoCartas;


public class PocimaReducePorcentaje extends Pocima {

	public PocimaReducePorcentaje(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}


	@Override
	public double addPocima(String atr, double val) {
		// TODO Auto-generated method stub
		return val + val * this.getValor() / 100;
	}

}
