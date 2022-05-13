package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {

//	Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
//	pasados como parámetros, recorrido en preorden.
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		this.numerosImparesMayoresQuePreOrden(a, n, lista);
		return lista;
	}

	private void numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
		if (!a.esVacio()) {
			if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
				lista.agregarFinal(a.getDato());
			}
			if (a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					this.numerosImparesMayoresQuePreOrden(hijos.proximo(), n, lista);
				}
			}
		}
	}

	// Idem al anterior, pero recorrido inorden
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		this.numerosImparesMayoresQueInOrden(a, n, lista);
		return lista;
	}

	private void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
		if (!a.esVacio()) {
			if (a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				// Llamar recursivamente con el primer hijo
				this.numerosImparesMayoresQueInOrden(hijos.proximo(), n, lista);
			}
			// Procesar el dato
			if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
				lista.agregarFinal(a.getDato());
			}
			// Lamar recursivamente con el resto de los hijos
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			while (!hijos.fin()) {
				this.numerosImparesMayoresQueInOrden(hijos.proximo(), n, lista);
			}
		}
	}

	// Idem al anterior, pero recorrido postorden
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		this.numerosImparesMayoresQuePostOrden(a, n, lista);
		return lista;
	}

	private void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
		if (!a.esVacio()) {
			if (a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					this.numerosImparesMayoresQuePostOrden(hijos.proximo(), n, lista);
				}
			}
			if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
				lista.agregarFinal(a.getDato());
			}
		}
	}

	// Idem al anterior, pero recorrido por niveles
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		ArbolGeneral<Integer> arbol = null;
		cola.encolar(a);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if ((arbol.getDato() % 2 != 0) && (arbol.getDato() > n)) {
					lista.agregarFinal(arbol.getDato());
				}
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return lista;
	}

}
