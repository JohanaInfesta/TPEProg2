package MazoCartas;


public class MainJuego {

	public static void main(String[] args) {
		MazoCartas M1 = new MazoCartas();
		
		Carta c1 = new Carta("Hulk");	
		c1.addAtributos("fuerza", 200);
		c1.addAtributos("velocidad", 20);
		c1.addAtributos("altura", 100);
				
		Carta c2 = new Carta ("Flash");
		c2.addAtributos("fuerza", 250);
		c2.addAtributos("velocidad", 200);
		c2.addAtributos("altura", 10);
		
		Carta c3 = new Carta ("Helicoptero");
		c3.addAtributos("peso", 250);
		c3.addAtributos("masa", 200);
		
		M1.addCarta(c1);
		M1.addCarta(c2);
		M1.addCarta(c3);
		System.out.println(M1);
		
		Jugador j1 = new Jugador ("PEPITO");
		
		
	}
}
