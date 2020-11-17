package MazoCartas.Estrategia;

import MazoCartas.Atributo;
import MazoCartas.Carta;

public  class EstrategiaTimbero implements Estrategia {

	//ELIGE ATRIBUTOS AL AZAR
	@Override
	public String elegirAtributo(Carta carta) {
		int cantAtributos = carta.cantAtributos();
		int AtributoRandom = (int) Math.floor(Math.random() * cantAtributos);
		Atributo atributoElegido = carta.atributoPorPosicion(AtributoRandom);
        return atributoElegido.getNombre();
	}

}
