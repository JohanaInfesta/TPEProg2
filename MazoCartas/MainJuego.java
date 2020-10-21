package MazoCartas;


public class MainJuego {

	public static void main(String[] args) {
		Pocima p1 = new Pocima ("Fortalecedora", 0.20);
		Pocima p2 = new Pocima ("Pócima Selectiva Fuerza.", 0.35);
		
		String mazoJson = "./src/lib/superheroes.json"; 
		MazoCartas mazo = VisorMazo.cargarMazo(mazoJson);

		Jugador j1 = new JugadorObstinado ("PEPITO");
		Jugador j2 = new JugadorObstinado ("JOSE");
		
		//mazo - jugador 1 - jugador 2 - cantidad de rondas
		Juego jugar = new Juego (mazo, j1, j2, 10);
		
		jugar.jugar();
		
	}
}
