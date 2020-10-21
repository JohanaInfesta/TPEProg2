package MazoCartas;

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

	public boolean finDelJuego(int rondas){
		return rondas == maxRondas || jugadorA.mazoCartas() == 0 || jugadorB.mazoCartas() == 0;
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
			ganador = jugadorA;
			jugadorB.setEsGanador(false);
			setPerdedorRonda(jugadorB);
		}
		return ganador;
	}
	public void jugar(){
		int ronda = 1;
		mazo.repartirCarta(jugadorA, jugadorB);

		while(!finDelJuego(ronda)){
			Jugador primerTurno = asignarTurno();
			Carta cartaPrimerTurno = primerTurno.getPrimeraCarta();
			Jugador segundoTurno = getPerdedorRonda();
			Carta cartaSegundoTurno = segundoTurno.getPrimeraCarta();
			Atributo atributoElegido = primerTurno.elegirAtributo(cartaPrimerTurno);
			System.out.println("el jugador : " + primerTurno + " eligio el atributo : " + atributoElegido);
			System.out.println("La carta de " + primerTurno + " es " + cartaPrimerTurno);
//			if(primerTurno.agregarPocima == false){
//			Pocima pocion =	primerTurno.agregarPocima();
//				System.out.println("Se aplico pocima " + "pocion");
//			}
			System.out.println("La carta de " + segundoTurno + " es " + cartaSegundoTurno);
			System.out.println();
			
			asignarResultado(primerTurno, cartaPrimerTurno, segundoTurno, cartaSegundoTurno, atributoElegido);

			System.out.println("RONDA N°: " + ronda);
			ronda ++;


		}
		System.out.println("Fin del juego");
	}

	public void asignarResultado(Jugador primerTurno, Carta cartaPrimerTurno, Jugador segundoTurno, Carta cartaSegundoTurno, Atributo atributoElegido){
		if(primerTurno.elegirAtributo(cartaPrimerTurno).getValor()>segundoTurno.elegirAtributo(cartaSegundoTurno).getValor()){
			primerTurno.gana(cartaSegundoTurno);
			segundoTurno.pierde(cartaSegundoTurno);
			Jugador ganador = primerTurno;
			Jugador perdedor = segundoTurno;
			primerTurno = asignarTurno();
			segundoTurno = getPerdedorRonda();
		}else if(segundoTurno.elegirAtributo(cartaSegundoTurno).getValor()>primerTurno.elegirAtributo(cartaPrimerTurno).getValor()){
			primerTurno.pierde(cartaPrimerTurno);
			segundoTurno.gana(cartaPrimerTurno);
			segundoTurno = primerTurno;
			Jugador ganador = segundoTurno;
			Jugador perdedor = primerTurno;
			segundoTurno = asignarTurno();
			primerTurno = getPerdedorRonda();
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
