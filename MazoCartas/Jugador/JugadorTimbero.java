package MazoCartas.Jugador;

import MazoCartas.Atributo;
import MazoCartas.Carta;

public  class JugadorTimbero extends Jugador {

	public JugadorTimbero(String nombre) {
		super(nombre);
	}

	//ELIGE ATRIBUTOS AL AZAR
	@Override
	public String elegirAtributo(Carta carta) {
		int cantAtributos = carta.cantAtributos();
		int AtributoRandom = (int) Math.floor(Math.random() * cantAtributos);
		Atributo atributoElegido = carta.atributoPorPosicion(AtributoRandom);
        return atributoElegido.getNombre();
	}

}
