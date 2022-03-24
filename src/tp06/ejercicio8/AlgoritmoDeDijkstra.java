package tp06.ejercicio8;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class AlgoritmoDeDijkstra {

	public void dijkstra(Grafo<String> grafo, String origen) {
		int[] distancias = new int[grafo.listaDeVertices().tamanio() + 1];
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio() + 1];
		String[] predecesores = new String[grafo.listaDeVertices().tamanio() + 1];	
		ListaGenerica<Arista<String>> adyacentes = null;
		Arista<String> arista = null;
		int w = 0;
		for (int i = 1; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}
		Vertice<String> verticeOrigen = buscarOrigen(grafo, origen);
		distancias[verticeOrigen.getPosicion()] = 0;
		if (verticeOrigen != null) {
			Vertice<String> verticeDesconocidoMenorDist = verticeDesconocidoMenorDistancia(distancias, visitados, grafo);
			while (verticeDesconocidoMenorDist != null) {				
				visitados[verticeDesconocidoMenorDist.getPosicion()] = true;
				adyacentes = grafo.listaDeAdyacentes(verticeDesconocidoMenorDist);
				adyacentes.comenzar();
				while (!adyacentes.fin()) {
					arista = adyacentes.proximo();
					w = arista.verticeDestino().getPosicion();
					if (distancias[w] == Integer.MAX_VALUE) {
						if (distancias[w]  > distancias[verticeDesconocidoMenorDist.getPosicion()] + arista.peso())
						distancias[w] = distancias[verticeDesconocidoMenorDist.getPosicion()] + arista.peso();
						predecesores[w] = verticeDesconocidoMenorDist.dato();
					}
				}
				verticeDesconocidoMenorDist = verticeDesconocidoMenorDistancia(distancias, visitados, grafo);
			}
		}
	}

	private Vertice<String> verticeDesconocidoMenorDistancia(int[] distancias, boolean[] visitados, Grafo<String> grafo) {
		var minimo = Integer.MAX_VALUE;
		for (int i = 1; i < distancias.length; i++) {
			if (distancias[i] < minimo && !visitados[i]) {
				minimo = i;
			}
		}
		return grafo.vertice(minimo);
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
