package MazoCartas;

public class Historial {

	//CLASE IMPLEMENTADA UNICAMENTE PARA IMPRIMIR LOS RESULTADOS DEL JUEGO

	public static void imprimirJugada(Jugador ganadorRonda, Jugador jugadorA,  Jugador jugadorB) {

		String atributoElegido = ganadorRonda.elegirAtributo(ganadorRonda.getPrimeraCarta());
		//JUGADOR A
		Carta primerJugador = jugadorA.getPrimeraCarta();
		Atributo atributoPrimerJugador = jugadorA.getPrimeraCarta().getAtributo(atributoElegido);
		String pocimaPrimerJugador = jugadorA.getPrimeraCarta().aplicarPocima(atributoElegido);
		//JUGADOR B
		Carta segundoJugador = jugadorB.getPrimeraCarta();
		Atributo atributoSegundoJugador = jugadorB.getPrimeraCarta().getAtributo(atributoElegido);
		String pocimaSegundoJugador = jugadorB.getPrimeraCarta().aplicarPocima(atributoElegido);

		//GANADOR RONDA
		System.out.println("el jugador : " + ganadorRonda.getNombre() + " eligio competir con el atributo : " + atributoElegido);
		//JUGADOR A
		System.out.println("La carta de " + jugadorA.getNombre() + " es " + primerJugador.getNombre() + 
				" con " + atributoPrimerJugador.getValor() + pocimaPrimerJugador);
		//JUGADOR B
		System.out.println("La carta de " + jugadorB.getNombre() + " es " + segundoJugador.getNombre() + 
				" con " + atributoSegundoJugador.getValor() + pocimaSegundoJugador);
	}


	public static void imprimirResultadoRonda(Jugador ganadorRonda) {
		String ganador = ganadorRonda.getNombre();
		int cantCartas = ganadorRonda.mazoCartas();

		System.out.println("Gana la ronda " + ganador + " y le quedan " + cantCartas + " cartas");

	}

	//IMPRIME EL RESULTADO FINAL DEL JUEGO CON EL GANADOR
	public static void finalJuegoResultado(Jugador jugadorA, Jugador jugadorB) {
		System.out.println("------RESULTADO------");
		if(jugadorA.mazoCartas()>jugadorB.mazoCartas()){
			System.out.println("El ganador es el jugador " + jugadorA.getNombre());
		}else if(jugadorB.mazoCartas()>jugadorA.mazoCartas()){
			System.out.println("El ganado es el jugador " + jugadorB.getNombre());
		}else{
			System.out.println("El juego finalizo en empate");
		}
		System.out.println("FIN DEL JUEGO");
	}

}
