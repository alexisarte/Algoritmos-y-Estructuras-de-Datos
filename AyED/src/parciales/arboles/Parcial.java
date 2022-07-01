package parciales.arboles;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {

	public ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character> arbol) {
		ListaGenerica<Character> caminoActual = new ListaEnlazadaGenerica<Character>();
		ListaGenerica<ListaGenerica<Character>> listaDeListas = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		this.caminosPares(arbol, listaDeListas, caminoActual, 1);
		return listaDeListas;
	}

	private void caminosPares(ArbolGeneral<Character> arbol, ListaGenerica<ListaGenerica<Character>> listaDeListas,
			ListaGenerica<Character> caminoActual, int length) {
		if (!arbol.esVacio()) {
			caminoActual.agregarFinal(arbol.getDato());
			if (arbol.esHoja()) {
				if (length % 2 == 0) {
					listaDeListas.agregarFinal(caminoActual.clonar());
				}
			}
			ListaGenerica<ArbolGeneral<Character>> hijos = new ListaEnlazadaGenerica<>();
			hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				this.caminosPares(hijos.proximo(), listaDeListas, caminoActual, length + 1);
			}
			caminoActual.eliminarEn(length);
		}
	}

}
