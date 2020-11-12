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

	
	public boolean finDelJuego(int rondas){
		return rondas == maxRondas+1 || jugadorA.mazoCartas() == 0 || jugadorB.mazoCartas() == 0;
	}


	public void jugar(){
		int ronda = 1;
		while(!finDelJuego(ronda)){	
			System.out.println("RONDA N°: " + ronda);
			empezarPartida();
			ronda ++;
		}
		finalJuegoResultado(ronda);
		System.out.println("Fin del juego");
	}

	public void empezarPartida(){
		String atributoElegido = ganadorRonda.elegirAtributo(ganadorRonda.getPrimeraCarta());
		System.out.println("el jugador : " + ganadorRonda.getNombre() + " eligio competir con el atributo : " + atributoElegido);
		//primer turno
		System.out.println("La carta de " + jugadorA.getNombre() + " es " + jugadorA.getPrimeraCarta().getNombre() + 
				" con " + jugadorA.getPrimeraCarta().getAtributo(atributoElegido).getValor() + jugadorA.getPrimeraCarta().aplicarPocima(atributoElegido));
		//segundo turno
		System.out.println("La carta de " + jugadorB.getNombre() + " es " + jugadorB.getPrimeraCarta().getNombre() + 
				" con " + jugadorB.getPrimeraCarta().getAtributo(atributoElegido).getValor() + jugadorB.getPrimeraCarta().aplicarPocima(atributoElegido));
		enfrentarJugadores(atributoElegido);
		System.out.println("");
	}
	
	public void enfrentarJugadores(String atributoElegido){
		if(jugadorA.getPrimeraCarta().getValorAtributo(atributoElegido) > jugadorB.getPrimeraCarta().getValorAtributo(atributoElegido)){
			asignarResultadoRonda(jugadorA, jugadorB);
			System.out.println("Gana la ronda " + jugadorA.getNombre() + " y le quedan " + jugadorA.mazoCartas() + " cartas");
		}else if(jugadorB.getPrimeraCarta().getValorAtributo(atributoElegido) > jugadorA.getPrimeraCarta().getValorAtributo(atributoElegido)){
			asignarResultadoRonda(jugadorB, jugadorA);
			System.out.println("Gana la ronda " + jugadorB.getNombre() + " y le quedan " + jugadorB.mazoCartas() + " cartas");
		}else{
			jugadorA.empate(jugadorA.getPrimeraCarta());
			jugadorB.empate(jugadorB.getPrimeraCarta());
			System.out.println("Empate");
		}
	}

	public void asignarResultadoRonda(Jugador ganador, Jugador perdedor){
		ganadorRonda = ganador;
		ganador.gana(perdedor.getPrimeraCarta());
		perdedor.pierde(perdedor.getPrimeraCarta());

	}

	public void finalJuegoResultado(int ronda){
		System.out.println("------RESULTADO------");
		if(jugadorA.mazoCartas()>jugadorB.mazoCartas()){
			System.out.println("El ganador es el jugador " + jugadorA.getNombre());
		}else if(jugadorB.mazoCartas()>jugadorA.mazoCartas()){
			System.out.println("El ganado es el jugador " + jugadorB.getNombre());
		}else{
			System.out.println("El juego finalizo en empate");
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
