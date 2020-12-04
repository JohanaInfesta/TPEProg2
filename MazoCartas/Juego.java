package MazoCartas;

import java.util.ArrayList;
import MazoCartas.Pocimas.Pocima;

public class Juego {

	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int maxRondas;
	private Jugador ganadorRonda;
	private ArrayList<Pocima>pocima;

	//CONSTRUCTOR
	public Juego(MazoCartas mazo, Jugador jugadorA, Jugador jugadorB, int maxRondas){
		this.mazo = mazo;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.maxRondas = maxRondas;
		ganadorRonda = jugadorA;
		this.pocima = new ArrayList<>();
	}

	//2DA PARTE POCIMAS
	public void addPocima(Pocima p){
		pocima.add(p);
	}

	//METODOS
	public void iniciarJuego(){
		repartirCartas();
		jugar();
	}
	//REPARTE LAS CARTAS EN EL JUEGO PARA QUE LAS POCIMAS LAS PODAMOS AGREGAR EN LAS CARTAS Y NO ESTEN EN EL MAZO DE CARTAS
	public void repartirCartas(){
		mazo.mezclar();
		while(!mazo.esVacio()){
			if(pocima.size()>0){
				Carta primeraCarta = mazo.getPrimeraCarta();
				primeraCarta.setPocima(pocima.get(0));// le asigno una pocima a la primera carta del mazo y la elimino
				pocima.remove(0);
			}
			jugadorA.agarrarCarta(mazo.eliminarPrimeraCarta());// cuando da la primera carta se elimina automaticamente del mazo
			if(!mazo.esVacio()){
				jugadorB.agarrarCarta(mazo.eliminarPrimeraCarta());
			}
		}
		jugadorA.mezclarMazo();
		jugadorB.mezclarMazo();
	}


	public void jugar(){
		int ronda = 1;
		while(!finDelJuego(ronda)){	
			System.out.println("RONDA N°: " + ronda);
			enfrentarJugadores();
			ronda ++;
		}
		//IMPRIME EL RESULTADO FINAL DEL JUEGO CON EL GANADOR
		Historial.finalJuegoResultado(jugadorA, jugadorB);
	}

	//COMPARA LOS VALORES DE LAS CARTAS DE CADA JUGADOR
	public void enfrentarJugadores(){
		Historial.imprimirJugada(ganadorRonda, jugadorA, jugadorB);
		
		if(jugadorA.enfrentraAtributo(jugadorB) != null){
			asignarResultadoRonda(jugadorB, jugadorA);
		}else if(jugadorB.enfrentraAtributo(jugadorA) != null){
			asignarResultadoRonda(jugadorA, jugadorB);
		}else{
			jugadorA.empate(jugadorA.getPrimeraCarta());
			jugadorB.empate(jugadorB.getPrimeraCarta());
			System.out.println("Empate");
		}
		System.out.println("");
	}

	//ASIGNA AL GANADOR RONDA Y ES EL QUE ELIGE EL ATRIBUTO
	public void asignarResultadoRonda(Jugador ganador, Jugador perdedor){
		ganadorRonda = ganador;
		ganador.gana(perdedor.getPrimeraCarta());
		perdedor.pierde(perdedor.getPrimeraCarta());
		Historial.imprimirResultadoRonda(ganadorRonda);
	}	
	
	public boolean finDelJuego(int rondas){
		return rondas == maxRondas+1 || jugadorA.getMazoCompleto() == 0 || jugadorB.getMazoCompleto() == 0;
	}

	//GET - SET 
	public int getMaxRondas(){
		return maxRondas;
	}

	public void setMaxRondas(int maxRondas){
		this.maxRondas = maxRondas;
	}


}
