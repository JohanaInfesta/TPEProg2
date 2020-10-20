package MazoCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class VisorMazo {

	public static void mostrarMazo(String jsonFile) {
		// URL url = getClass().getResource(jsonFile);
		File jsonInputFile = new File(jsonFile);
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Creo el objeto JsonReader de Json.
			JsonReader reader = Json.createReader(is);
			// Obtenemos el JsonObject a partir del JsonReader.
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
				String atributosStr = "";
				for (String nombreAtributo : atributos.keySet())
					atributosStr = atributosStr + nombreAtributo + ": " + atributos.getInt(nombreAtributo) + "; ";
				System.out.println(nombreCarta + "\t\t\t" + atributosStr);
			}

			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MazoCartas cargarMazo(String jsonFile) {
		// URL url = getClass().getResource(jsonFile);
		MazoCartas mazo = new MazoCartas();

		File jsonInputFile = new File(jsonFile);
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Creo el objeto JsonReader de Json.
			JsonReader reader = Json.createReader(is);
			// Obtenemos el JsonObject a partir del JsonReader.
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				Carta cartaNueva = new Carta(nombreCarta);
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
				for (String nombreAtributo : atributos.keySet()) {
					int valorAtributo = atributos.getInt(nombreAtributo);
					Atributo nuevoAtributo = new Atributo(nombreAtributo, valorAtributo);
					cartaNueva.agregarAtributo(nuevoAtributo);

				}
				mazo.agregarCarta(cartaNueva);
			}

			reader.close();
			return mazo;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}