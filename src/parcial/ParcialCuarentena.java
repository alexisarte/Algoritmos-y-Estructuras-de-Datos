package parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class ParcialCuarentena {

	public int[] resolver(Grafo<Ciudad> ciudades, String origen, String destino) {
		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<Ciudad> caminoActual = new ListaEnlazadaGenerica<>();
		int[] fases = new int[5];
		Vertice<Ciudad> verticeOrigen = buscarOrigen(ciudades, origen, destino);
		if (verticeOrigen != null) {
			this.resolver(verticeOrigen.getPosicion(), ciudades, fases, visitados, caminoActual, destino);
		}
		return fases;
	}

	private void resolver(int i, Grafo<Ciudad> ciudades, int[] fases, boolean[] visitados, ListaEnlazadaGenerica<Ciudad> caminoActual, String destino) {
		visitados[i] = true;
		int j = 0;
		Vertice<Ciudad> vertice = ciudades.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(vertice.dato());
		ListaGenerica<Arista<Ciudad>> adyacentes = ciudades.listaDeAdyacentes(vertice);
		if (!vertice.dato().getNombre().equals(destino)) {
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<Ciudad> arista = adyacentes.proximo();
				j = arista.verticeDestino().getPosicion();
				var nombreDestino = arista.verticeDestino().dato().getNombre();
				if (!visitados[j] && (!nombreDestino.equals("Abasto") && !nombreDestino.equals("Pinamar") && !nombreDestino.equals("Lobos"))) {
					this.resolver(j, ciudades, fases, visitados, caminoActual, destino);
				}
			}
		} else {
			caminoActual.comenzar();
			while (!caminoActual.fin()) {
				++fases[caminoActual.proximo().getFase()];
			}
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	private Vertice<Ciudad> buscarOrigen(Grafo<Ciudad> ciudades, String origen, String destino) {
		ListaGenerica<Vertice<Ciudad>> listaDeVertices = ciudades.listaDeVertices();
		Vertice<Ciudad> verticeActual, verticeOrigen = null, verticeDestino = null;
		listaDeVertices.comenzar();
		while (!listaDeVertices.fin()) {
			verticeActual = listaDeVertices.proximo();
			if (verticeActual.dato().getNombre().equals(origen)) {
				verticeOrigen = verticeActual;
			} else if (verticeActual.dato().getNombre().equals(destino)) {
				verticeDestino = verticeActual;
			}
			if (verticeOrigen != null && verticeDestino!= null) {
				return verticeOrigen;
			}
		}
		return null;
	}

}
