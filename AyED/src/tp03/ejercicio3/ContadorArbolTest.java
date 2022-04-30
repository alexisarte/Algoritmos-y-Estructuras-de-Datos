package tp03.ejercicio3;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio2.ArbolBinario;
import tp03.ejercicio2.CrearArbolBinario;

public class ContadorArbolTest {

	public static void main(String[] args) {
		
		CrearArbolBinario crear = new CrearArbolBinario(); 
		ArbolBinario<Integer> arbol = crear.crearArbolInteger();
		
		ContadorArbol contador = new ContadorArbol(arbol);
		
		ListaGenerica<Integer> lista = contador.numerosParesInOrden();

//		lista = contador.numerosParesPostOrden();
		
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}

	}

}
