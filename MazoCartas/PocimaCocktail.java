package MazoCartas;

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

	@Override
	public ArrayList<Atributo> addPocima(Carta cartas) {
//		ArrayList<Atributo>carta = cartas.getAtributos();
		ArrayList<Atributo> aux = new ArrayList<>();
		for(Pocima p:pocimas){
			ArrayList<Atributo> pos = p.addPocima(cartas);
			for(Atributo a:pos){
				aux.add(a);
			}
		}
		return aux;
	}

	public String getNombre() {
		return nombre;
	}

}
