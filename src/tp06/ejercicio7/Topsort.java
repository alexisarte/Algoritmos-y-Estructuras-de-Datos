package tp06.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.PilaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Topsort {

	public ListaGenerica<String> topsort(Grafo<String> grafo) {
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<Arista<String>> adyacentes = null;
		int[] grados = new int[vertices.tamanio() + 1];
		Vertice<String> vertice = null;
		this.calcularGrados(grados, vertices);
		var pos = this.encontrarGradoCero(grados);
		while (pos != -1) {
			vertice = grafo.vertice(pos);
			lista.agregarFinal(vertice.dato());
			grados[pos] = -1;
			adyacentes = grafo.listaDeAdyacentes(vertice);
			this.decrementarGrado(grados, adyacentes);
			pos = this.encontrarGradoCero(grados);
		}
		return lista;
	}

	public ListaGenerica<String> topsort2(Grafo<String> grafo) {
		PilaGenerica<Vertice<String>> pila = new PilaGenerica<>();
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<Arista<String>> adyacentes = null;
		int[] grados = new int[vertices.tamanio() + 1];
		Vertice<String> vertice = null;
		this.calcularGrados(grados, vertices);
		apilarGradoCero(grados, pila, vertices);
		while (!pila.esVacia()) {
			vertice = pila.desapilar();
			lista.agregarFinal(vertice.dato());
			grados[vertice.getPosicion()] = -1;
			adyacentes = grafo.listaDeAdyacentes(vertice);
			this.decrementarGradoYApilar(grados, adyacentes, pila);
		}
		return lista;
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

	private void topsortEnProfundidad(int i, Grafo<String> grafo, ListaGenerica<String> lista, PilaGenerica<Vertice<String>> pila, boolean[] visitados) {
		ListaGenerica<Arista<String>> adyacentes = null;
		int j = 0;
		visitados[i] = true;
		Arista<String> arista = null;
		Vertice<String> vertice = grafo.listaDeVertices().elemento(i);
		adyacentes = grafo.listaDeAdyacentes(vertice);
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			arista = adyacentes.proximo();
			j = arista.verticeDestino().getPosicion();
			if (!visitados[j]) {
				this.topsortEnProfundidad(j, grafo, lista, pila, visitados);
			}
		}
		pila.apilar(vertice);
	}

	private void decrementarGradoYApilar(int[] grados, ListaGenerica<Arista<String>> adyacentes,
			PilaGenerica<Vertice<String>> pila) {
		Arista<String> arista;
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			arista = adyacentes.proximo();
			grados[arista.verticeDestino().getPosicion()]--;
			if (grados[arista.verticeDestino().getPosicion()] == 0) {
				pila.apilar(arista.verticeDestino());
			}
		}

	}

	private void apilarGradoCero(int[] grados, PilaGenerica<Vertice<String>> pila,
			ListaGenerica<Vertice<String>> vertices) {
		for (int i = 1; i < grados.length; i++) {
			if (grados[i] == 0) {
				pila.apilar(vertices.elemento(i));
			}
		}
	}

	private void decrementarGrado(int[] grados, ListaGenerica<Arista<String>> adyacentes) {
		Arista<String> arista;
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			arista = adyacentes.proximo();
			grados[arista.verticeDestino().getPosicion()]--;
		}
	}

	private void calcularGrados(int[] grados, ListaGenerica<Vertice<String>> vertices) {
		Vertice<String> vertice;
		Arista<String> arista;
		ListaGenerica<Arista<String>> adyacentes;
		vertices.comenzar();
		while (!vertices.fin()) {
			vertice = vertices.proximo();
			adyacentes = ((VerticeImplListAdy<String>) vertice).obtenerAdyacentes();
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				arista = adyacentes.proximo();
				grados[arista.verticeDestino().getPosicion()]++;
			}
		}
	}

	private int encontrarGradoCero(int[] grados) {
		for (int i = 1; i < grados.length; i++) {
			if (grados[i] == 0) {
				return i;
			}
		}
		return -1;
	}

}
