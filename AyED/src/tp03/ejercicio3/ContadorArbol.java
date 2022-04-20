package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio2.ArbolBinario;

public class ContadorArbol {

	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();

	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	private void numerosParesInOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				this.numerosParesInOrden(arbol.getHijoIzquierdo(), lista);
			}
			if ((arbol.getDato()) % 2 == 0) {
				lista.agregarFinal(arbol.getDato());
			}
			if (arbol.tieneHijoDerecho()) {
				this.numerosParesInOrden(arbol.getHijoDerecho(), lista);
			}
		}
	}

	public ListaGenerica<Integer>  numerosParesInOrden() {
		 ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		this.numerosParesInOrden(this.arbol, lista);
		return lista;
	}

	
	private void numerosParesPostOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer>  lista) {
		if (!this.arbol.esVacio()) {
			if (this.arbol.tieneHijoIzquierdo()) {
				this.numerosParesInOrden(this.arbol.getHijoIzquierdo(), lista);
			}
			if (this.arbol.tieneHijoDerecho()) {
				this.numerosParesInOrden(this.arbol.getHijoDerecho(), lista);
			}
			if ((arbol.getDato()) % 2 == 0) {
				lista.agregarFinal(this.arbol.getDato());
			}
		}
	}
	
	public ListaGenerica<Integer> numerosParesPostOrden() {
		ListaGenerica<Integer>  lista = new ListaEnlazadaGenerica<Integer>();
		this.numerosParesPostOrden(this.arbol, lista);
		return lista;
	}

}