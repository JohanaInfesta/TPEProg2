package MazoCartas.Estrategia;

import MazoCartas.Atributo;
import MazoCartas.Carta;
import MazoCartas.Jugador;

public  class EstrategiaTimbero extends Estrategia {

	//ELIGE ATRIBUTOS AL AZAR
	@Override
	public String elegirAtributo(Carta carta) {
		int cantAtributos = carta.cantAtributos();
		int AtributoRandom = (int) Math.floor(Math.random() * cantAtributos);
		Atributo atributoElegido = carta.atributoPorPosicion(AtributoRandom);
        return atributoElegido.getNombre();
	}

}
