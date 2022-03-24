package tp03.ejercicio3;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosEnlazada;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {

	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();

	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public void esParInOrden(ArbolBinario<Integer> arbol, ListaDeEnteros lista) {
		if (!this.arbol.esVacio()) {
			if (this.arbol.tieneHijoIzquierdo()) {
				this.esParInOrden(this.arbol.getHijoIzquierdo(), lista);
			}
			if ((arbol.getDato()) % 2 == 0) {
				lista.agregarFinal(this.arbol.getDato());
			}
			if (this.arbol.tieneHijoDerecho()) {
				this.esParInOrden(this.arbol.getHijoDerecho(), lista);
			}
		}
	}

	public ListaDeEnteros numerosParesInOrden() {
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		this.esParInOrden(this.arbol, lista);
		return lista;
	}

	
	public void esParPostOrden(ArbolBinario<Integer> arbol, ListaDeEnteros lista) {
		if (!this.arbol.esVacio()) {
			if (this.arbol.tieneHijoIzquierdo()) {
				this.esParInOrden(this.arbol.getHijoIzquierdo(), lista);
			}
			if ((arbol.getDato()) % 2 == 0) {
				lista.agregarFinal(this.arbol.getDato());
			}
			if (this.arbol.tieneHijoDerecho()) {
				this.esParInOrden(this.arbol.getHijoDerecho(), lista);
			}
		}
	}
	
	public ListaDeEnteros numerosParesPostOrden() {
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		this.esParPostOrden(this.arbol, lista);
		return lista;
	}

}