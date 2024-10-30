package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
	public static final String RUTA = "src\\ejercicio1\\carpetas.txt";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		leerTxt();

	}

	/**
	 * leerTxt el txt y llama a crearEstructuraCarpetas
	 */
	public static void leerTxt() {
		String linea;
		StringBuilder carpetasBuilder = new StringBuilder();
		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(RUTA));
			linea = reader.readLine();

			while (linea != null) {
				carpetasBuilder.append(linea.trim()).append(" ");
				linea = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		String[] carpetasArray = carpetasBuilder.toString().trim().split(" ");
		crearEstructuraCarpetas(carpetasArray);
	}

	/**
	 * funcion que crea la estructura de carpetas
	 * 
	 * @param carpetas
	 */
	public static void crearEstructuraCarpetas(String[] carpetas) {

		for (String carpeta : carpetas) {
			File directorio = new File(carpeta);
			if (!directorio.exists()) {
				if (directorio.mkdirs()) {
					System.out.println("Directorio creado: " + carpeta);
					if (carpeta.contains("EJ")) {
						crearArchivoHtml(carpeta);
					}
				} else {
					System.out.println("No se pudo crear el directorio: " + carpeta);
				}
			} else {
				System.out.println("El directorio ya existe: " + carpeta);
			}
		}
	}

	/**
	 * funcion que cea los html en base a kas rutas de las carpetas
	 * 
	 * @param carpeta
	 */
	public static void crearArchivoHtml(String carpeta) {
		try {

			File archivoHtml = new File(carpeta + "\\archivo.html");
			archivoHtml.getParentFile().mkdirs();
			FileWriter fw = new FileWriter(archivoHtml);
			BufferedWriter bw = new BufferedWriter(fw);

			String nombreCarpeta = carpeta.substring(carpeta.lastIndexOf("\\") + 1);
			bw.write("<html>\r\n" + "   <head>\r\n" + "      <title>" + nombreCarpeta + "</title>\r\n"
					+ "   </head>\r\n" + "   <body>\r\n" + "      <h1>" + carpeta + "</h1>\r\n"
					+ "      <h3>Autor: Neos Rafael </h3>\r\n" + "   </body>\r\n" + "</html>");
			bw.newLine();

			bw.close();
			System.out.println("Archivo HTML creado correctamente en: " + archivoHtml.getPath());

		} catch (IOException e) {
			System.err.println("Error al guardar el archivo HTML: " + e.getMessage());
		}
	}
}
