package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	
	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		int total = 0;
		int contador = 0;
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(this.arbol);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (contador++ == p) {
					total += arbol.getDato();
				}
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
			} else {
				System.out.println();
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return total;
	}
	
}
