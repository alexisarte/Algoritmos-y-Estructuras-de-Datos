package tp03.ejercicio4;

import tp03.ejercicio2.ArbolBinario;
import tp03.ejercicio2.CrearArbolBinario;

public class RedBinariaLlenaTest {

	public static void main(String[] args) {
		
		CrearArbolBinario crear = new CrearArbolBinario(); 
		ArbolBinario<Integer> arbol = crear.crearArbolInteger2();
		
		RedBinariaLlena red = new RedBinariaLlena(arbol);
		
		arbol.printPreorden();
		System.out.println("Retardo de reenvío máximo: " + red.retardoReenvio());
		
	}

}
