package MazoCartas;


public class MainJuego {

	public static void main(String[] args) {
		Pocima p1 = new PocimaSumaPorcentaje("Fortalecedora", 0.20);
		Pocima p2 = new PocimaSumaPorcentaje("Fortalecedora Plus", 0.50);
		Pocima p3 = new PocimaReducePorcentaje("Kriptonita", 0.2);
		Pocima p4 = new PocimaReducePorcentaje("Reductor de Plomo", 0.55);
		Pocima p5 = new PocimaNoImportaAtributo("Quiero vale cuatro", 4.0);
		Pocima p6 = new PocimaNoImportaAtributo("Número Mágico", 23.0);
//		Pocima p7 = new PocimaNoImportaAtributo("Pócima Selectiva Fuerza", 0.35);
//		Pocima p8 = new PocimaNoImportaAtributo("Pócima Selectiva Peso", 0.43);
//		Pocima p9 = new PocimaNoImportaAtributo("Pócima Cocktail", );
		
		String mazoJson = "./src/lib/superheroes.json"; 
		MazoCartas mazo = VisorMazo.cargarMazo(mazoJson);

		Jugador j1 = new JugadorObstinado ("PEPITO");
		Jugador j2 = new JugadorObstinado ("JOSE");
		
		//mazo - jugador 1 - jugador 2 - cantidad de rondas
		Juego jugar = new Juego (mazo, j1, j2, 10);
		
		jugar.jugar();
		
	}
}
