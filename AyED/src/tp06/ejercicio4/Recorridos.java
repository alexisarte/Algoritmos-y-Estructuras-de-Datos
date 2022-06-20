package tp06.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {

	// Retorna una lista de vértices con el recorrido en profundidad del grafo
	// recibido como parámetro.
	public ListaGenerica<T> dfs(Grafo<T> grafo) {
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<T> lis = new ListaEnlazadaGenerica<>();
		for (int i = 1; i < visitados.length; i++) {
			if (!visitados[i]) // si no está marcado
				this.depthFirstSearch(i, grafo, lis, visitados);
		}
		return (ListaGenerica<T>) lis;
	}
	
	private void depthFirstSearch(int i, Grafo<T> grafo, ListaGenerica<T> lis, boolean[] visitados) {
		visitados[i] = true;
		int j = 0;
		Arista<T> arista = null;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		System.out.println(v.dato());
		lis.agregarFinal(v.dato());
		ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			arista = adyacentes.proximo();
			j = arista.verticeDestino().getPosicion();
			if (!visitados[j]) {
				this.depthFirstSearch(j, grafo, lis, visitados);
			}
		}
	}

	// Retorna una lista de vértices con el recorrido en amplitud del grafo recibido
	// como parámetro.
	public ListaGenerica<T> bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		for (int i = 1; i < marca.length; i++) {
			if (!marca[i])
				this.breadthFirstSearch(i, grafo, lista, marca); // las listas empiezan en la pos 1
		}
		return (ListaGenerica<T>) lista;
	}

	private void breadthFirstSearch(int i, Grafo<T> grafo, ListaGenerica<T> lista, boolean[] marca) {
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();
		ListaGenerica<Arista<T>> adyacentes = null;
		Arista<T> arista = null;
		Vertice<T> vertice = grafo.listaDeVertices().elemento(i);
		cola.encolar(vertice);
		marca[i] = true;
		int j = 0;
		while (!cola.esVacia()) {
			vertice = cola.desencolar();
			lista.agregarFinal(vertice.dato());
			adyacentes = grafo.listaDeAdyacentes(vertice);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				arista = adyacentes.proximo();
				j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					marca[j] = true;
					cola.encolar(arista.verticeDestino());
				}
			}
		}
	}

}
