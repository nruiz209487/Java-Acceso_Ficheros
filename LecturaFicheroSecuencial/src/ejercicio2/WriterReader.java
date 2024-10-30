/**
 * 
 */
package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public class WriterReader {
	public static final String RUTA = "src/ejercicio2/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		leerFichero();
	}

	private static void Escribirfichero(List<String> palabrasSeparadas) {

		String insetar = "palabras separadas y ordenadas . \n";
		try {
			File archivo = new File(RUTA + "palabraSeparadas.txt");
			FileWriter fw;

			if (archivo.exists()) {
				fw = new FileWriter(archivo, true);
			} else {
				fw = new FileWriter(archivo);
			}

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(insetar);
			bw.newLine();
			for (String elemento : palabrasSeparadas) {
				bw.write(elemento);
				bw.newLine();
			}
			bw.close();
			System.out.println("Datos guardados correctamente en palabraseparadas.txt.");

		} catch (IOException e) {
			System.err.println("Error al guardar los datos: " + e.getMessage());
		}
	}

	public static void separarPalabras(String texto) {
		List<String> palabrasSeparadas = new ArrayList<>();
		StringBuilder palabraActual = new StringBuilder();
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (Character.isUpperCase(c) && palabraActual.length() > 0) {
				palabrasSeparadas.add(palabraActual.toString());
				palabraActual = new StringBuilder();
			}

			palabraActual.append(c);
		}

		if (palabraActual.length() > 0) {
			palabrasSeparadas.add(palabraActual.toString());
		}
	    Collections.sort(palabrasSeparadas);

		Escribirfichero(palabrasSeparadas);
	}

	private static void leerFichero() {
		String linea = "";
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(RUTA + "palabras.txt"));
			linea = reader.readLine();
			while (linea != null) {
				separarPalabras(linea);
				linea = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
