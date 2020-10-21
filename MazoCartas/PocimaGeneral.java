package MazoCartas;

import java.util.ArrayList;

public class PocimaGeneral extends FormaAplicarPocima {

	double porciento;
	int valor;

	public PocimaGeneral(double porciento){
		super(nombre);
		this.porciento = porciento;
	}

	public PocimaGeneral(int valor){
		super(nombre);
		this.valor = valor;
	}

	@Override
	public ArrayList <Atributo> getAplicarPocima(ArrayList <Atributo> atributos){
		for(int i = 0; i< atributos.size(); i++){
			Atributo atr = atributos.get(i);
			if( valor != 0){
				int aux = atr.getValor();
				aux = valor;
			}
		}
		return atributos;
	}

}
