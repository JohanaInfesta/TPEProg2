package MazoCartas;

public class Juego {

	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int maxRondas;
	private Jugador perdedorRonda;


	public Juego(MazoCartas mazo, Jugador jugadorA, Jugador jugadorB, int maxRondas){
		this.mazo = mazo;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.maxRondas = maxRondas;
	}

	public Jugador asignarTurno(){
		Jugador ganador;
		if(jugadorA.esGanador() && !jugadorB.esGanador()){
			ganador = jugadorA;
			jugadorB.setEsGanador(false);
			setPerdedorRonda(jugadorB);
		}else if(jugadorB.esGanador() && !jugadorA.esGanador()){
			ganador = jugadorB;
			jugadorA.setEsGanador(false);
			setPerdedorRonda(jugadorA);
		}else{
			return null; // en el caso que sea empate --> resolver
		}
		return ganador;
	}
	
	public boolean finDelJuego(int rondas){
		return rondas == maxRondas || jugadorA.mazoCartas() == 0 || jugadorB.mazoCartas() == 0;
	}

	public void jugar(){
		int ronda = 0;
		while(!finDelJuego(ronda)){
			Jugador primerTurno = asignarTurno();
			Carta cartaPrimerTurno = primerTurno.getPrimeraCarta();
			Jugador segundoTurno = getPerdedorRonda();
			Carta cartaSegundoTurno = segundoTurno.getPrimeraCarta();
			Atributo atributoElegido = primerTurno.elegirAtributo(cartaPrimerTurno);
			System.out.println("el jugador : " + primerTurno + " eligio el atributo : " + atributoElegido);
			System.out.println("La carta de " + primerTurno + " es " + cartaPrimerTurno);
			System.out.println("La carta de " + segundoTurno + " es " + cartaSegundoTurno);
			System.out.println();
			asignarResultado(primerTurno, cartaPrimerTurno, segundoTurno, cartaSegundoTurno, atributoElegido);

			System.out.println("RONDA N°: " + ronda);
			ronda ++;
		}
		System.out.println("Fin del juego");
	}
	
	public void asignarResultado(Jugador primerTurno, Carta cartaPrimerTurno, Jugador segundoTurno, Carta cartaSegundoTurno, Atributo atributoElegido){
		
		//resolver
		
		
	}

	public MazoCartas getMazo(){
		return mazo;
	}

	public Jugador getJugadorA(){
		return jugadorA;
	}

	public Jugador getJugadorB(){
		return jugadorB;
	}

	public int getMaxRondas(){
		return maxRondas;
	}

	public void setMaxRondas(int maxRondas){
		this.maxRondas = maxRondas;
	}

	public Jugador getPerdedorRonda(){
		return perdedorRonda;
	}

	private void setPerdedorRonda(Jugador perdedorRonda) {
		this.perdedorRonda = perdedorRonda;
	}

}
