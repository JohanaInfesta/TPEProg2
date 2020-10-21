package MazoCartas;

public  class JugadorTimbero extends Jugador {

	public JugadorTimbero(String nombre) {
		super(nombre);
	}

	@Override
	public Atributo elegirAtributo(Carta carta) {
		int cantAtributos = carta.cantAtributos();
		int atributoRandom = (int) (Math.random()*cantAtributos );
		Atributo atributoElegido = carta.atributoPorPosicion(atributoRandom);
		return atributoElegido;
	}

}
