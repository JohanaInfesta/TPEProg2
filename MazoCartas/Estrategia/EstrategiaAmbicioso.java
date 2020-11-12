package MazoCartas.Estrategia;

import MazoCartas.Carta;

public class EstrategiaAmbicioso extends Estrategia {

	//ATRIBUTO QUE POSEA MAYOR VALOR DE SU CARTA
	@Override
	public String elegirAtributo(Carta carta) {
		String atributoElegido = "";
		double valorMasAlto = 0; 
		for(int i = 0; i < carta.cantAtributos(); i++){
			if(carta.atributoPorPosicion(i).getValor()>valorMasAlto){
				atributoElegido = carta.atributoPorPosicion(i).getNombre();
				valorMasAlto = carta.atributoPorPosicion(i).getValor();
			}
		}
		return atributoElegido;
	}
}
