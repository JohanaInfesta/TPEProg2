package MazoCartas;

public class JugadorAmbicioso extends Jugador {

	public JugadorAmbicioso(String nombre) {
		super(nombre);
	}

	@Override
	public Atributo elegirAtributo(Carta carta) {
		double valorMasAlto = 0,valor ;
		int pos = 0;
		int cantAtributos = carta.cantAtributos();
		for(int i= 0; i< cantAtributos; i++){
			valor = carta.getAtributos().get(i).getValor();
			if(valor > valorMasAlto){
				valorMasAlto = valor;
				pos = i;
			}
		}	
		return carta.atributoPorPosicion(pos);
	}

}
