package clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TratamientoFichero {

    public static final String RUTA_LEER = "src\\clases\\Lectura.txt";
    public static final String RUTA_ESCRIBIR = "src\\clases\\Escritura.txt";

    public static void main(String[] args) throws IOException {
        crearArchivoLectura();
        escribirArchivoInverso();
    }


    public static void crearArchivoLectura() throws IOException {
        File ficheroLectura = new File(RUTA_LEER);
        try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "rw")) {
            for (int i = 1; i <= 5; i++) {
                fileLeer.writeBytes((char)('a' + i - 1) + String.valueOf(i) + "\n");
            }
        }
    }


    public static void escribirArchivoInverso() throws IOException {
        File ficheroLectura = new File(RUTA_LEER);
        File ficheroEscritura = new File(RUTA_ESCRIBIR);
        char letra; 
        char numero;
        long posicion;
        long posicionFinal;
        try (RandomAccessFile fileLeer = new RandomAccessFile(ficheroLectura, "r");
             RandomAccessFile fileEscribir = new RandomAccessFile(ficheroEscritura, "rw")) {
             posicionFinal = fileLeer.length();
            for (int i = 1; i <= 5; i++) {
                posicion = posicionFinal - (i * 3); 
                fileLeer.seek(posicion);
                letra = (char) fileLeer.readByte(); 
                numero = (char) fileLeer.readByte(); 
                fileLeer.readByte(); 
                fileEscribir.seek(fileEscribir.length());
                fileEscribir.writeBytes(letra + "" + numero + " ");
            }
        }
    }
}
