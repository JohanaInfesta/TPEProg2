package MazoCartas;

import java.util.ArrayList;
import java.util.Collections;
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
	public int mazoPocima(){
		return pocima.size();
	}
	public void pocimas(){
		while(!(pocima.size() >= mazo.size())){
			pocima.add(null); // el arreglo de pocima tiene el mismo tamaño que cartas
		}
		Collections.shuffle(pocima);
	}


	//METODOS
	public void iniciarJuego(){
		repartirCartas();
		jugar();
	}
	//REPARTE LAS CARTAS EN EL JUEGO PARA QUE LAS POCIMAS LAS PODAMOS AGREGAR EN LAS CARTAS Y NO ESTEN EN EL MAZO DE CARTAS
	public void repartirCartas(){
		mazo.mezclar();
		pocimas(); //mezclo el arreglo de pocimas
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
	}


	public void jugar(){
		int ronda = 1;
		while(!finDelJuego(ronda)){	
			System.out.println("RONDA N°: " + ronda);
			empezarPartida();
			ronda ++;
		}
		//IMPRIME EL RESULTADO FINAL DEL JUEGO CON EL GANADOR
		Historial.finalJuegoResultado(jugadorA, jugadorB);
		System.out.println("Fin del juego");
	}

	public void empezarPartida(){
		//ATRIBUTO ELEGIDO POR EL JUGADOR GANADOR
		String atributoElegido = ganadorRonda.elegirAtributo(ganadorRonda.getPrimeraCarta());
		//IMPRIME CADA JUGADA
		Historial.imprimirJugada(ganadorRonda, jugadorA, jugadorB);
		enfrentarJugadores(atributoElegido);
		System.out.println("");
	}

	//COMPARA LOS VALORES DE LAS CARTAS DE CADA JUGADOR
	public void enfrentarJugadores(String atributoElegido){
		if(jugadorA.getPrimeraCarta().getValorAtributo(atributoElegido) > jugadorB.getPrimeraCarta().getValorAtributo(atributoElegido)){
			asignarResultadoRonda(jugadorA, jugadorB);
		}else if(jugadorB.getPrimeraCarta().getValorAtributo(atributoElegido) > jugadorA.getPrimeraCarta().getValorAtributo(atributoElegido)){
			asignarResultadoRonda(jugadorB, jugadorA);
		}else{
			jugadorA.empate(jugadorA.getPrimeraCarta());
			jugadorB.empate(jugadorB.getPrimeraCarta());
			System.out.println("Empate");
		}
	}

	//ASIGNA AL GANADOR RONDA Y ES EL QUE ELIGE EL ATRIBUTO
	public void asignarResultadoRonda(Jugador ganador, Jugador perdedor){
		ganadorRonda = ganador;
		ganador.gana(perdedor.getPrimeraCarta());
		perdedor.pierde(perdedor.getPrimeraCarta());
		Historial.imprimirResultadoRonda(ganadorRonda);
	}	
	
	public boolean finDelJuego(int rondas){
		return rondas == maxRondas+1 || jugadorA.mazoCartas() == 0 || jugadorB.mazoCartas() == 0;
	}

	//GET - SET 
	public int getMaxRondas(){
		return maxRondas;
	}

	public void setMaxRondas(int maxRondas){
		this.maxRondas = maxRondas;
	}


}
