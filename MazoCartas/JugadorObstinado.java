package MazoCartas;

public class JugadorObstinado extends Jugador {

	public JugadorObstinado(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	//SIEMPRE EL MISMO ATRIBUTO EN ESTE CASI YO ELEGI EL QUE ESTA EN LA POS 2 DEL ARREGLO DE ATRIBUTOS DE LA CARTA
	@Override
	public String elegirAtributo(Carta carta) {
		return carta.atributoPorPosicion(2).getNombre();
	}

}
