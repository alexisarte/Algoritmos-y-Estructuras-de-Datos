package tp06.ejercicio8;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class AlgoritmoDeDijkstra {

	public ListaGenerica<String> dijkstra(Grafo<String> grafo, String origen) {
		int[] distancias = new int[grafo.listaDeVertices().tamanio() + 1];
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio() + 1];
		String[] predecesores = new String[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> caminoMinimo = new ListaEnlazadaGenerica<>();
		ListaGenerica<Arista<String>> aristas = null;
		Arista<String> arista = null;
		int w = 0;
		// Inicializamos el vector con distancias iniciales
		for (int i = 1; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}
		Vertice<String> verticeOrigen = this.buscarOrigen(grafo, origen);
		if (verticeOrigen != null) {
			// La distancia de verticeOrigen a verticeOrigen es 0
			distancias[verticeOrigen.getPosicion()] = 0;
			Vertice<String> verticeDesconocidoMenorDist = this.verticeDesconocidoMenorDist(distancias, visitados,
					grafo);
			while (verticeDesconocidoMenorDist != null) {
				visitados[verticeDesconocidoMenorDist.getPosicion()] = true;
				caminoMinimo.agregarFinal(verticeDesconocidoMenorDist.dato());
				System.out.println("Que está pasando: " + caminoMinimo.elemento(caminoMinimo.tamanio()));
				aristas = grafo.listaDeAdyacentes(verticeDesconocidoMenorDist);
				aristas.comenzar();
				while (!aristas.fin()) {
					arista = aristas.proximo();
					w = arista.verticeDestino().getPosicion();
					if (distancias[w] == Integer.MAX_VALUE) {
						// verticeDesconocidoMenorDist tiene su distancia desde el vertice destino
						if ((distancias[verticeDesconocidoMenorDist.getPosicion()] + arista.peso()) < distancias[w]) {
							distancias[w] = distancias[verticeDesconocidoMenorDist.getPosicion()] + arista.peso();
							predecesores[w] = verticeDesconocidoMenorDist.dato();
						}
					}
				}
				verticeDesconocidoMenorDist = verticeDesconocidoMenorDist(distancias, visitados, grafo);
			}
		} else {
			System.out.println("El vertice destino no es está en el grafo");
		}
		return caminoMinimo;
	}

	private Vertice<String> verticeDesconocidoMenorDist(int[] distancias, boolean[] visitados, Grafo<String> grafo) {
		var minimo = Integer.MAX_VALUE;
		for (int i = 1; i < distancias.length; i++) {
			if ((distancias[i] < minimo) && !visitados[i]) {
				minimo = i;
			}
		}
		System.out.println("grafo.listaDeVertices().elemento(minimo): " + grafo.listaDeVertices().elemento(minimo));
		return grafo.listaDeVertices().elemento(minimo);
	}

	private Vertice<String> buscarOrigen(Grafo<String> grafo, String origen) {
		ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
		Vertice<String> verticeActual;
		listaDeVertices.comenzar();
		while (!listaDeVertices.fin()) {
			verticeActual = listaDeVertices.proximo();
			if (verticeActual.dato().equals(origen)) {
				return verticeActual;
			}
		}
		return null;
	}

}
