package MazoCartas;

import MazoCartas.Estrategia.Estrategia;
import MazoCartas.Estrategia.EstrategiaObstinado;
import MazoCartas.Estrategia.EstrategiaTimbero;
import MazoCartas.Pocimas.Pocima;
import MazoCartas.Pocimas.PocimaCocktail;
import MazoCartas.Pocimas.PocimaNoImportaAtributo;
import MazoCartas.Pocimas.PocimaReducePorcentaje;
import MazoCartas.Pocimas.PocimaSelectiva;
import MazoCartas.Pocimas.PocimaSumaPorcentaje;


public class MainJuego {

	public static void main(String[] args) {
		
		String mazoJson = "./src/lib/autos.json"; 
		MazoCartas mazo = VisorMazo.cargarMazo(mazoJson);
		//ELIJO UN ATRIBUTO POR POSICION EN EL OBSTINADO
		Estrategia eo = new EstrategiaObstinado(3);
		
		Jugador j1 = new Jugador ("PEPITO", new EstrategiaTimbero());
		Jugador j2 = new Jugador ("JOSE", eo);
		
		Pocima p1 = new PocimaSumaPorcentaje("Fortalecedora", 0.20);
		Pocima p2 = new PocimaSumaPorcentaje("Fortalecedora Plus", 0.50);
		Pocima p3 = new PocimaReducePorcentaje("Kriptonita", 0.2);
		Pocima p4 = new PocimaReducePorcentaje("Reductor de Plomo", 0.55);
		Pocima p5 = new PocimaNoImportaAtributo("Quiero vale cuatro", 4.0);
		Pocima p6 = new PocimaNoImportaAtributo("Número Mágico", 23.0);
		Pocima p7 = new PocimaSelectiva("Pócima Selectiva Fuerza", 0.35);
		Pocima p8 = new PocimaSelectiva("Pócima Selectiva Peso", 0.43);
		PocimaCocktail p9 = new PocimaCocktail("Pócima Cocktail incrementa");
		PocimaCocktail p10 = new PocimaCocktail("Pócima Cocktail reduce ");

		
		p9.addPocimasAlCocktail(p1);
		p9.addPocimasAlCocktail(p2);
		p9.addPocimasAlCocktail(p7);
		
		p10.addPocimasAlCocktail(p3);
		p10.addPocimasAlCocktail(p4);
		p10.addPocimasAlCocktail(p7);
		
		Juego jugar = new Juego (mazo, j1, j2, 50);
	
		
		jugar.addPocima(p1);
		jugar.addPocima(p2);
		jugar.addPocima(p3);
		jugar.addPocima(p4);
		jugar.addPocima(p5);
		jugar.addPocima(p6);
		jugar.addPocima(p7);
		jugar.addPocima(p8);
		jugar.addPocima(p9);
		jugar.addPocima(p10);
		//mazo - jugador 1 - jugador 2 - cantidad de rondas
		
		jugar.iniciarJuego();
		
	}
}
