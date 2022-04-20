package tp03.ejercicio4;

import tp03.ejercicio2.ArbolBinario;
import tp03.ejercicio2.CrearArbolBinario;

public class RedBinariaLlenaTest {

	public static void main(String[] args) {
		
		CrearArbolBinario crear = new CrearArbolBinario(); 
		ArbolBinario<Integer> arbol = crear.crearArbolDeEnteros();
		
		RedBinariaLlena red = new RedBinariaLlena(arbol);
		
		System.out.println("Retardo de reenv�o: " + red.retardoReenvio());
		
	}

}
