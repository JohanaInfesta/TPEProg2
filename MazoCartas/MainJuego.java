package MazoCartas;


public class MainJuego {

	public static void main(String[] args) {
		String mazoJson = "C:/Users/Usuario/workspace/TrabajoPracticoProg/src/lib/superheroes.json"; 
		//se puso la url completa porque no pudimos porla directa y tiraba error
		MazoCartas mazo = VisorMazo.cargarMazo(mazoJson);

		Jugador j1 = new Jugador ("PEPITO");
		Jugador j2 = new Jugador ("JOSE");
		
		//mazo - jugador 1 - jugador 2 - cantidad de rondas
		Juego jugar = new Juego (mazo, j1, j2, 10);
		
		jugar.jugar();
		
	}
}
