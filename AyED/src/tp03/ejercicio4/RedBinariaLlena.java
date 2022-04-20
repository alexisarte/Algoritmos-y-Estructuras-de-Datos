package tp03.ejercicio4;

import tp03.ejercicio2.ArbolBinario;

public class RedBinariaLlena {
	
	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private int retardoReenvio(ArbolBinario<Integer> arbol, int retardoIzquierda, int retardoDerecha) {
		retardoIzquierda = 0;
		retardoDerecha = 0;
		if (arbol.esHoja()) {
			return arbol.getDato();
		} else {
			if (arbol.tieneHijoIzquierdo()) {
				retardoIzquierda += retardoReenvio(arbol.getHijoIzquierdo(), retardoIzquierda, retardoDerecha);
			}
			if (arbol.tieneHijoDerecho()) {
				retardoDerecha += retardoReenvio(arbol.getHijoDerecho(), retardoIzquierda, retardoDerecha);
			}
		}
		return Math.max(retardoIzquierda, retardoDerecha) + arbol.getDato();
	}
	
	public int retardoReenvio() {
		int retardoIzquierda = 0;
		int retardoDerecha = 0;
		int retardo = 0;
		if (!arbol.esVacio()) {
			retardo = retardoReenvio(this.arbol, retardoIzquierda, retardoDerecha);
		}
		return retardo;
	}
	
}
