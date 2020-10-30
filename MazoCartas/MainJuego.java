package MazoCartas;


public class MainJuego {

	public static void main(String[] args) {
		
		String mazoJson = "./src/lib/superheroes.json"; 
		MazoCartas mazo = VisorMazo.cargarMazo(mazoJson);
		
		
		Pocima p1 = new PocimaSumaPorcentaje("Fortalecedora", 0.20);
		Pocima p2 = new PocimaSumaPorcentaje("Fortalecedora Plus", 0.50);
		Pocima p3 = new PocimaReducePorcentaje("Kriptonita", 0.2);
		Pocima p4 = new PocimaReducePorcentaje("Reductor de Plomo", 0.55);
		Pocima p5 = new PocimaNoImportaAtributo("Quiero vale cuatro", 4.0);
		Pocima p6 = new PocimaNoImportaAtributo("N�mero M�gico", 23.0);
		Pocima p7 = new PocimaSelectiva("P�cima Selectiva Fuerza", 0.35);
		Pocima p8 = new PocimaSelectiva("P�cima Selectiva Peso", 0.43);
		PocimaCocktail p9 = new PocimaCocktail("P�cima Cocktail");

		mazo.addPocima(p1);
		mazo.addPocima(p2);
		mazo.addPocima(p3);
		mazo.addPocima(p4);
		mazo.addPocima(p5);
		mazo.addPocima(p6);
		mazo.addPocima(p7);
		mazo.addPocima(p8);
		mazo.addPocima(p9);
		
//		p9.addPocimasAlCocktail(p1);
//		p9.addPocimasAlCocktail(p2);
		
		
		Jugador j1 = new JugadorObstinado ("PEPITO");
		Jugador j2 = new JugadorObstinado ("JOSE");
	
		//mazo - jugador 1 - jugador 2 - cantidad de rondas
		Juego jugar = new Juego (mazo, j1, j2, 10);
		
		jugar.jugar();
		
	}
}
