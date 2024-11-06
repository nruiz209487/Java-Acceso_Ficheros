package clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public class TratamientoFichero {

	public static final String RUTA_LEER = "src\\clases\\Lectura.txt";
	public static final String RUTA_ESCRIBIR = "src\\clases\\Escritura";

	public static void main(String[] args) throws IOException {
		crearArchivoLecturaAprtado1();
		crearArchivoLecturaAprtado1();
		crearArchivoLecturaAprtado2();
		escribirArchivoInversoAprtado2();
		crearArchivoLecturaAprtado3();
		escribirArchivoInversoAprtado3();
	}

	public static void crearArchivoLecturaAprtado1() throws IOException {
		File ficheroLectura = new File(RUTA_LEER);

		try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "rw")) {
			fileLeer.writeBytes(("a"));
		}
	}

	public static void escribirArchivoAprtado1() throws IOException {
		File ficheroLectura = new File(RUTA_LEER);
		File ficheroEscritura = new File(RUTA_ESCRIBIR+"1.txt");
		char letra;
		try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "r");
				RandomAccessFile fileEscribir = new RandomAccessFile(ficheroEscritura, "rw")) {

			fileLeer.seek(0);
			letra = (char) fileLeer.readByte();
			fileLeer.readByte();
			fileEscribir.seek(fileEscribir.length());
			for (int i = 0; i < 4; i++) {
				fileEscribir.writeBytes(letra + "");
			}

		}
	}

	public static void crearArchivoLecturaAprtado2() throws IOException {
		File ficheroLectura = new File(RUTA_LEER);
		try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "rw")) {
			for (int i = 1; i <= 4; i++) {
				fileLeer.writeBytes((char) ('a' + i - 1) + "\n");
			
			}
		}
	}

	public static void escribirArchivoInversoAprtado2() throws IOException {
	    File ficheroLectura = new File(RUTA_LEER);
	    File ficheroEscritura = new File(RUTA_ESCRIBIR+"2.txt"); 

	    char letra;
	    try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "r");
	         RandomAccessFile fileEscribir = new RandomAccessFile(ficheroEscritura, "rw")) {
	       
	        long posicion = fileLeer.length() - 2;
	        while (posicion >= 0) {
	            fileLeer.seek(posicion);
	            letra = (char) fileLeer.readByte();
	            fileEscribir.seek(fileEscribir.length()); 
	            fileEscribir.writeBytes(letra + "\n");
	            posicion -= 2;
	        }
	    }
	}

	public static void crearArchivoLecturaAprtado3() throws IOException {
		File ficheroLectura = new File(RUTA_LEER);
		try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "rw")) {
			fileLeer.writeBytes(("a1" + "\n"));
			for (int i = 1; i <= 4; i++) {
				fileLeer.writeBytes((char) ('b' + i - 1) + String.valueOf(i) + "\n");
			}
		}
	}

	public static void escribirArchivoInversoAprtado3() throws IOException {
		File ficheroLectura = new File(RUTA_LEER);
		File ficheroEscritura = new File(RUTA_ESCRIBIR+"3.txt");
		long posicion;
		char letra;
		char numero;
		try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "r");
				RandomAccessFile fileEscribir = new RandomAccessFile(ficheroEscritura, "rw")) {
			for (int i = 5; i >= 1; i--) {
				posicion = (i - 1) * 3;
				fileLeer.seek(posicion);
				letra = (char) fileLeer.readByte();
				numero = (char) fileLeer.readByte();
				fileLeer.readByte();
				fileEscribir.seek(fileEscribir.length());
				fileEscribir.writeBytes(letra + "" + numero + " " + "\n");
			}
		}
	}
}
