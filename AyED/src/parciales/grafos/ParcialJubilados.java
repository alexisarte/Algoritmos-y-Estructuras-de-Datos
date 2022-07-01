package parciales.grafos;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class ParcialJubilados {

	public ListaEnlazadaGenerica<Persona> jubilados(Grafo<Persona> grafo, Persona empleado, int distancia, int maxJubilados) {
        ListaEnlazadaGenerica<Persona> jubilados = new ListaEnlazadaGenerica<Persona>();
        ListaGenerica<Vertice<Persona>> vertices = grafo.listaDeVertices();
        Vertice<Persona> vertice = null;
        vertices.comenzar();
        while (!vertices.fin() && !vertice.dato().getId().equals(empleado.getId())) {
			vertice = vertices.proximo();
		}
        if (vertice.dato().getId().equals(empleado.getId())) {
        	boolean[] visitados = new boolean[vertices.tamanio() + 1];
        	this.jubilados(grafo, vertice, jubilados, visitados, distancia, 40);
        }
        return jubilados;
    }

	private void jubilados(Grafo<Persona> grafo, Vertice<Persona> empleado,
			ListaEnlazadaGenerica<Persona> jubilados, boolean[] visitados, int distancia, int maxJubilados) {
		ColaGenerica<Vertice<Persona>> cola = new ColaGenerica<>();
		Vertice<Persona> vertice = null, adyacente = null;
		Arista<Persona> arista = null;
		int j = 0;
		cola.encolar(empleado);
		cola.encolar(vertice);
		while (!cola.esVacia() && (distancia > 0) && (jubilados.tamanio() < maxJubilados)) {
			vertice = cola.desencolar();
			if (vertice != null) {
				ListaGenerica<Arista<Persona>> aristas = grafo.listaDeAdyacentes(vertice);
				aristas.comenzar();
				while (!aristas.fin() && jubilados.tamanio() < maxJubilados) {
					arista = aristas.proximo();
					adyacente = arista.verticeDestino();
					j = adyacente.getPosicion();
					if (!visitados[j]) {
						visitados[j] = true;
						cola.encolar(adyacente);
						if (adyacente.dato().esJubilado()) {
							jubilados.agregarFinal(adyacente.dato());
						}
					}
				}
			} else {
				--distancia;
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
	}

}
