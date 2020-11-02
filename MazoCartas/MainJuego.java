package MazoCartas;

import MazoCartas.Jugador.Jugador;
import MazoCartas.Jugador.JugadorObstinado;
import MazoCartas.Jugador.JugadorTimbero;
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

		mazo.addPocima(p1);
		mazo.addPocima(p2);
		mazo.addPocima(p3);
		mazo.addPocima(p4);
		mazo.addPocima(p5);
		mazo.addPocima(p6);
		mazo.addPocima(p7);
		mazo.addPocima(p8);
		mazo.addPocima(p9);
		mazo.addPocima(p10);
		
		p9.addPocimasAlCocktail(p1);
		p9.addPocimasAlCocktail(p2);
		p10.addPocimasAlCocktail(p3);
		p10.addPocimasAlCocktail(p4);
		
		
		Jugador j1 = new JugadorTimbero ("PEPITO");
		Jugador j2 = new JugadorObstinado ("JOSE");
	
		//mazo - jugador 1 - jugador 2 - cantidad de rondas
		Juego jugar = new Juego (mazo, j1, j2, 10);
		
		jugar.jugar();
		
	}
}
