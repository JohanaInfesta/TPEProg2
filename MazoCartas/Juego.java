package MazoCartas;

public class Juego {

	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int maxRondas;

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

	public void jugar(){
		int ronda = 0;
		mazo.repartirCarta(jugadorA, jugadorB);
		
		while(!finDelJuego(ronda)){
			Carta cartaPrimerTurno = jugadorA.getPrimeraCarta();
			Carta cartaSegundoTurno = jugadorB.getPrimeraCarta();
			Atributo atributoElegido = jugadorA.elegirAtributo(cartaPrimerTurno);
			System.out.println("el jugador : " + jugadorA + " eligio el atributo : " + atributoElegido);
			System.out.println("La carta de " + jugadorA + " es " + cartaPrimerTurno);
			System.out.println("La carta de " + jugadorB + " es " + cartaSegundoTurno);
			System.out.println();
			asignarResultado(jugadorA, cartaPrimerTurno, jugadorB, cartaSegundoTurno, atributoElegido);

			System.out.println("RONDA N°: " + ronda);
			ronda ++;
		}
		System.out.println("Fin del juego");
	}

	public void asignarResultado(Jugador primerTurno, Carta cartaPrimerTurno, Jugador segundoTurno, Carta cartaSegundoTurno, Atributo atributoElegido){
		if(primerTurno.elegirAtributo(cartaPrimerTurno).getValor()>segundoTurno.elegirAtributo(cartaSegundoTurno).getValor()){
			primerTurno.gana(cartaSegundoTurno);
			segundoTurno.pierde(cartaSegundoTurno);
		}else if(segundoTurno.elegirAtributo(cartaSegundoTurno).getValor()>primerTurno.elegirAtributo(cartaPrimerTurno).getValor()){
			primerTurno.pierde(cartaPrimerTurno);
			segundoTurno.gana(cartaPrimerTurno);
			segundoTurno = primerTurno;
		}else{
			primerTurno.agarrarCarta(cartaPrimerTurno);
			segundoTurno.agarrarCarta(cartaSegundoTurno);
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


}
