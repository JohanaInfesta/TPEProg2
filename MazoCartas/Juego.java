package MazoCartas;

import MazoCartas.Jugador.Jugador;
import MazoCartas.Jugador.JugadorObstinado;

public class Juego {

	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int maxRondas;
	private Jugador perdedorRonda;


	//CONSTRUCTOR
	public Juego(MazoCartas mazo, Jugador jugadorA, Jugador jugadorB, int maxRondas){
		this.mazo = mazo;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.maxRondas = maxRondas;

	}
	//METODOS

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
			ganador = jugadorA;
			jugadorB.setEsGanador(false);
			setPerdedorRonda(jugadorB);
		}
		return ganador;
	}
	
	public boolean finDelJuego(int rondas){
		return rondas == maxRondas+1 || jugadorA.mazoCartas() == 0 || jugadorB.mazoCartas() == 0;
	}
	
	public void jugar(){
		int ronda = 1;
		mazo.repartirCarta(jugadorA, jugadorB);

		while(!finDelJuego(ronda)){
			Jugador primerTurno = asignarTurno();
			Jugador segundoTurno = getPerdedorRonda();
			Carta cartaPrimerTurno = primerTurno.getPrimeraCarta();
			Carta cartaSegundoTurno = segundoTurno.getPrimeraCarta();			
			String atributoElegido = primerTurno.elegirAtributo(cartaPrimerTurno);
			Atributo primeraCarta = cartaPrimerTurno.getAtributo(atributoElegido);
			Atributo segundaCarta = cartaSegundoTurno.mismoAtributo(atributoElegido);
			
			// esto se puede poner en otra clase // imprimirResultado();
			System.out.println("RONDA N°: " + ronda);
			System.out.println("el jugador : " + primerTurno + " eligio competir con el atributo : " + atributoElegido);
			System.out.println("La carta de " + primerTurno + " es " + cartaPrimerTurno.getNombre() + 
					" con " + primeraCarta.getValor() + cartaPrimerTurno.aplicarPocima(atributoElegido));
			System.out.println("La carta de " + segundoTurno + " es " + cartaSegundoTurno.getNombre() + 
					" con " + segundaCarta.getValor() + cartaSegundoTurno.aplicarPocima(atributoElegido));
			asignarResultado(primerTurno, cartaPrimerTurno, segundoTurno, cartaSegundoTurno, atributoElegido);
			System.out.println("");
			ronda ++;

		}
		System.out.println("Fin del juego");
	}

	public void asignarResultado(Jugador primerTurno, Carta cartaPrimerTurno, Jugador segundoTurno, Carta cartaSegundoTurno, String atributoElegido){
		if(primerTurno.getPrimeraCarta().getValorAtributo(atributoElegido)>segundoTurno.getPrimeraCarta().getValorAtributo(atributoElegido)){
			primerTurno.gana(cartaSegundoTurno);
			segundoTurno.pierde(cartaSegundoTurno);
			Jugador ganador = primerTurno;
			Jugador perdedor = segundoTurno;
			primerTurno = asignarTurno();
			segundoTurno = getPerdedorRonda();
			System.out.println("Gana la ronda " + ganador + " y le quedan " + ganador.mazoCartas() + " cartas");
		}else if(segundoTurno.getPrimeraCarta().getValorAtributo(atributoElegido)>primerTurno.getPrimeraCarta().getValorAtributo(atributoElegido)){
			primerTurno.pierde(cartaPrimerTurno);
			segundoTurno.gana(cartaPrimerTurno);
			segundoTurno = primerTurno;
			Jugador ganador = segundoTurno;
			Jugador perdedor = primerTurno;
			segundoTurno = asignarTurno();
			primerTurno = getPerdedorRonda();
			System.out.println("Gana la ronda " + ganador + " y le quedan " + ganador.mazoCartas() + " cartas");
		}else{
			primerTurno.agarrarCarta(cartaPrimerTurno);
			segundoTurno.agarrarCarta(cartaSegundoTurno);
			Jugador ganador = new JugadorObstinado ("Ninguno");
			Jugador perdedor = new JugadorObstinado ("Ninguno");
		}


	}

	//GET - SET 
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
