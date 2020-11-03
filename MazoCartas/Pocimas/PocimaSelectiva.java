package MazoCartas.Pocimas;

public class PocimaSelectiva extends Pocima {

	public PocimaSelectiva(String nombre, double valor){
		super(nombre, valor);
	}
	
	@Override
	public double addPocima(String atr, double val) {
		if(this.getNombre().toLowerCase().contains(atr.toLowerCase())){
			double valor = val + (val * this.getValor()) ;
			return valor;
		}
		return val;
	}

}
