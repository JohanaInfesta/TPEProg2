package MazoCartas;

public  class JugadorTimbero extends Jugador {

	public JugadorTimbero(String nombre) {
		super(nombre);
	}

	//ELIGE ATRIBUTOS AL AZAR
	@Override
	public String elegirAtributo(Carta carta) {
		int AtributoRandom = (int) Math.random() * carta.cantAtributos();
        return carta.atributoPorPosicion(AtributoRandom).getNombre();
	}

}
