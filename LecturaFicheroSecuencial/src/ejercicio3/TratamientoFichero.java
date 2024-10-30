/**
 * 
 */
package ejercicio3;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 */
public class TratamientoFichero {
	private static final String RUTA = "src/ejercicio2/";

	public static void main(String[] args) {
        leerFichero();
        escribirFichero();
	}

	/**
	 * 
	 */
	private static void leerFichero() {

	}

	private static void escribirFichero() {
		 try (// create a new RandomAccessFile with filename test
		RandomAccessFile raf = new RandomAccessFile( RUTA +"fichero2.txt", "rw")) {
	         // write something in the file
	         raf.writeUTF("Hello World");

	         // set the file pointer at 0 position
	         raf.seek(0);

	         // print the string
	         System.out.println("" + raf.readUTF());

	         // set the file pointer at 5 position
	         raf.seek(5);

	         // write something in the file
	         raf.writeUTF("This is an example");

	         // set the file pointer at 0 position
	         raf.seek(0);

	         // print the string
	         System.out.println("" + raf.readUTF());
	         
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }
	

	}
	

