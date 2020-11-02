package MazoCartas.Pocimas;

public class PocimaSumaPorcentaje extends Pocima {

	public PocimaSumaPorcentaje(String nombre, double valor) {
		super(nombre, valor);
	}

	@Override
	public double addPocima(String atr, double val) {
		double valor = val + val * this.getValor() / 100 ;
		return valor;
	}
}
