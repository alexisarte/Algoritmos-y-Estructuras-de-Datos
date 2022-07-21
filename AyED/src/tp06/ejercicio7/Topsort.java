package tp06.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio3.PilaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Topsort {

	public ListaGenerica<String> topsort(Grafo<String> grafo) {
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<Arista<String>> aristas = null;
		int[] gradosDeEntrada = new int[vertices.tamanio() + 1];
		Vertice<String> vertice = null;
		var numVerticesVisitados = 0;
		this.calcularGradosDeEntrada(gradosDeEntrada, vertices);
		var pos = this.encontrarGradoCero(gradosDeEntrada);
		while (pos != -1) {
			vertice = grafo.listaDeVertices().elemento(pos);
			lista.agregarFinal(vertice.dato());
			++numVerticesVisitados;
			gradosDeEntrada[pos] = -1;
			aristas = grafo.listaDeAdyacentes(vertice);
			this.decrementarGrado(gradosDeEntrada, aristas);
			pos = this.encontrarGradoCero(gradosDeEntrada);
		}
		if (numVerticesVisitados != vertices.tamanio()) {
			throw new IllegalArgumentException("El grafo no es acíclico");
		} else {
			return lista;
		}
	}

	public ListaGenerica<String> topsort2(Grafo<String> grafo) {
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<>();
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<Arista<String>> aristas = null;
		int[] gradosDeEntrada = new int[vertices.tamanio() + 1];
		Vertice<String> vertice = null;
		var numVerticesVisitados = 0;
		this.calcularGradosDeEntrada(gradosDeEntrada, vertices);
		encolarGradoCero(gradosDeEntrada, cola, vertices);
		while (!cola.esVacia()) {
			vertice = cola.desencolar();
			lista.agregarFinal(vertice.dato());
			++numVerticesVisitados;
			gradosDeEntrada[vertice.getPosicion()] = -1;
			aristas = grafo.listaDeAdyacentes(vertice);
			this.decrementarGradoYEncolar(gradosDeEntrada, aristas, cola);
		}
		if (numVerticesVisitados != vertices.tamanio()) {
			throw new IllegalArgumentException("El grafo no es acíclico");
		} else {
			return lista;
		}
	}

	public ListaGenerica<String> topsortEnProfundidad(Grafo<String> grafo) {
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		PilaGenerica<Vertice<String>> pila = new PilaGenerica<>();
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for (int i = 1; i < visitados.length; i++) {
			if (!visitados[i]) {
				this.topsortEnProfundidad(i, grafo, lista, pila, visitados);
			}
		}
		while (!pila.esVacia()) {
			lista.agregarFinal(pila.desapilar().dato());
		}
		return lista;
	}

	private void topsortEnProfundidad(int i, Grafo<String> grafo, ListaGenerica<String> lista,
			PilaGenerica<Vertice<String>> pila, boolean[] visitados) {
		ListaGenerica<Arista<String>> aristas = null;
		int j = 0;
		visitados[i] = true;
		Arista<String> arista = null;
		Vertice<String> vertice = grafo.listaDeVertices().elemento(i);
		aristas = grafo.listaDeAdyacentes(vertice);
		aristas.comenzar();
		while (!aristas.fin()) {
			arista = aristas.proximo();
			j = arista.verticeDestino().getPosicion();
			if (!visitados[j]) {
				this.topsortEnProfundidad(j, grafo, lista, pila, visitados);
			}
		}
		pila.apilar(vertice);
	}
	
	private void decrementarGradoYEncolar(int[] gradosDeEntrada, ListaGenerica<Arista<String>> aristas,
			ColaGenerica<Vertice<String>> cola) {
		Arista<String> arista;
		aristas.comenzar();
		while (!aristas.fin()) {
			arista = aristas.proximo();
			gradosDeEntrada[arista.verticeDestino().getPosicion()]--;
			if (gradosDeEntrada[arista.verticeDestino().getPosicion()] == 0) {
				cola.encolar(arista.verticeDestino());
			}
		}
	}

	private void encolarGradoCero(int[] gradosDeEntrada, ColaGenerica<Vertice<String>> cola,
			ListaGenerica<Vertice<String>> vertices) {
		for (int i = 1; i < gradosDeEntrada.length; i++) {
			if (gradosDeEntrada[i] == 0) {
				cola.encolar(vertices.elemento(i));
			}
		}
	}

	private void decrementarGrado(int[] gradosDeEntrada, ListaGenerica<Arista<String>> aristas) {
		Arista<String> arista;
		aristas.comenzar();
		while (!aristas.fin()) {
			arista = aristas.proximo();
			gradosDeEntrada[arista.verticeDestino().getPosicion()]--;
		}
	}

	private void calcularGradosDeEntrada(int[] gradosDeEntrada, ListaGenerica<Vertice<String>> vertices) {
		ListaGenerica<Arista<String>> aristas;
		Vertice<String> vertice;
		Arista<String> arista;
		vertices.comenzar();
		while (!vertices.fin()) {
			vertice = vertices.proximo();
			aristas = ((VerticeImplListAdy<String>) vertice).obtenerAdyacentes();
			aristas.comenzar();
			while (!aristas.fin()) {
				arista = aristas.proximo();
				gradosDeEntrada[arista.verticeDestino().getPosicion()]++;
			}
		}
	}

	private int encontrarGradoCero(int[] gradosDeEntrada) {
		for (int i = 1; i < gradosDeEntrada.length; i++) {
			if (gradosDeEntrada[i] == 0) {
				return i;
			}
		}
		return -1;
	}

}
