package MazoCartas.Pocimas;

public class PocimaNoImportaAtributo extends Pocima {

	public PocimaNoImportaAtributo(String nombre, double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double addPocima(String atr, double val) {
		return this.getValor();
	}
}
