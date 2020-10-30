package MazoCartas;

public class JugadorObstinado extends Jugador {

	public JugadorObstinado(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Atributo elegirAtributo(Carta carta) {
		return carta.atributoPorPosicion(2);
	}

}
