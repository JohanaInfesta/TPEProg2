package MazoCartas.Pocimas;

import java.util.ArrayList;

public class PocimaCocktail extends Pocima {
	private String nombre;
	private ArrayList<Pocima>pocimas;

	public PocimaCocktail(String nombre) {
		this.nombre = nombre;
		pocimas = new ArrayList<>();
	}

	public void addPocimasAlCocktail(Pocima pocima){
		pocimas.add(pocima);
	}


	public String getNombre() {
		return nombre;
	}

	@Override
	public double addPocima(String atr, double val) {
		for(Pocima p:pocimas){
			val = p.addPocima(nombre, val);
		}
		return val;
	}

}
