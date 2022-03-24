package parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {

	public ListaGenerica<Integer> resolver(ArbolGeneral<Integer> arbol) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> caminoActual = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> caminoFiltradoMaximo = new ListaEnlazadaGenerica<>();
		int nivel = 0, costoActual = 0, costoMayor = 0;
		resolverRecursivo(arbol, nivel, caminoActual, caminoActual, costoActual, costoMayor);
		return lista;
	}

	private void resolverRecursivo(ArbolGeneral<Integer> arbol, int nivel, ListaGenerica<Integer> caminoActual,
			ListaGenerica<Integer> caminoActual2, int costoActual, int costoMayor) {
		
	}

}
