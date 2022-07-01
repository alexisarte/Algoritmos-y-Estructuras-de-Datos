package parciales.grafos;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class ParcialGrafos {

	private Vertice<Local> buscarLocal(String ciudad, Grafo<Local> locales) {
		ListaGenerica<Vertice<Local>> vertices = locales.listaDeVertices();
		Vertice<Local> vertice = null;
		vertices.comenzar();
		while (!vertices.fin() && !vertice.dato().getNombre().equals(ciudad)) {
			vertice = vertices.proximo();
		}
		if (vertice.dato().getNombre().equals(ciudad)) {
			return vertice;
		}
		return null;
	}

	public ListaGenerica<Local> resolver(Grafo<Local> locales, String origen, String destino, int distancia,
			int personas) {
		ListaGenerica<Vertice<Local>> vertices = locales.listaDeVertices();
		ListaGenerica<Local> listaDeLocales = null;
		ListaGenerica<Local> listaDeLocales2 = null;
		boolean[] visitados = new boolean[vertices.tamanio() + 1];
		Vertice<Local> verticeOrigen = buscarLocal(origen, locales);
		if (verticeOrigen != null) {
			this.resolver(locales, verticeOrigen, destino, distancia, personas, visitados, listaDeLocales,
					listaDeLocales2);
		}
		return listaDeLocales;
	}

	private void resolver(Grafo<Local> locales, Vertice<Local> vertice, String destino, int distancia, int personas,
			boolean[] visitados, ListaGenerica<Local> listaDeLocales, ListaGenerica<Local> listaDeLocales2) {
		if (!vertice.dato().getNombre().equals(destino)) {
			visitados[vertice.getPosicion()] = true;
			listaDeLocales.agregarFinal(vertice.dato());
			ListaGenerica<Arista<Local>> aristas = locales.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin()) {
				Arista<Local> arista = aristas.proximo();
				if (!visitados[arista.verticeDestino().getPosicion()] && (arista.peso() < distancia)) {
					this.resolver(locales, arista.verticeDestino(), destino, distancia, personas, visitados,
							listaDeLocales, listaDeLocales2);
				}
			}
		} else {
			Local local;
			listaDeLocales.comenzar();
			while (!listaDeLocales.fin()) {
				local = listaDeLocales.proximo();
				if (local.getAforo() > personas) {
					listaDeLocales2.agregarFinal(local);
				}
			}
		}
		visitados[vertice.getPosicion()] = false;
		listaDeLocales.eliminarEn(listaDeLocales.tamanio());
	}

}
