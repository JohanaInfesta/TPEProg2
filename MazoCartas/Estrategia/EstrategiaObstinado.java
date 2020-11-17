package MazoCartas.Estrategia;

import MazoCartas.Carta;

public class EstrategiaObstinado implements Estrategia {

	private int atributoPorPosicion;


	public EstrategiaObstinado(int atributoPorPosicion) {
		this.atributoPorPosicion = atributoPorPosicion;
	}

	public int getAtributoPorPosicion() {
		return atributoPorPosicion;
	}

	//EN EL CASO DE QUE EL ATRIBUTO SEA MAYOR A LA CANTIDAD DE ATRIBUTOS QUE TENGA LA CARTA SIEMPRE ELIGE EL ATRIBUTO EN LA POS
	// 2 SINO UTILIZA EL ATRIBUTO DEL CONSTRUCTOR
	@Override
	public String elegirAtributo(Carta carta) {
		if(this.atributoPorPosicion > carta.cantAtributos()){
			return carta.atributoPorPosicion(2).getNombre();
		}else{
			return carta.atributoPorPosicion(this.getAtributoPorPosicion()).getNombre();
		}
	}

}
