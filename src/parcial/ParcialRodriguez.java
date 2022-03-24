package parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class ParcialRodriguez {

	public ListaGenerica<Integer> resolver(Grafo<Integer> datos, Integer origen, Integer destino) {
		boolean[] visitados = new boolean[datos.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<Integer> caminoMasCorto = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<Integer> caminoActual = new ListaEnlazadaGenerica<>();
		int cantidadAdyacentes = 0, maxAdyacentes = 0;
		Vertice<Integer> verticeOrigen = buscarOrigenYDestino(datos, origen, destino);
		if (verticeOrigen != null) {
			this.resolver(verticeOrigen.getPosicion(), datos, destino, visitados, caminoMasCorto, caminoActual, maxAdyacentes, cantidadAdyacentes);
		}
		return caminoMasCorto;
	}
	
	private void resolver(int i, Grafo<Integer> datos, Integer destino, boolean[] visitados,
			ListaEnlazadaGenerica<Integer> caminoMasCorto, ListaEnlazadaGenerica<Integer> caminoActual, int maxAdyacentes,
			int cantidadAdyacentes) {
		visitados[i] = true;
		int j = 0;
		Vertice<Integer> vertice = datos.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(vertice.dato());
		ListaGenerica<Arista<Integer>> adyacentes = datos.listaDeAdyacentes(vertice);
		System.out.println("Estoy en: " + vertice.dato());
		System.out.println("Cantidad de adyacentes: " + cantidadAdyacentes);
		if (!vertice.dato().equals(destino)) {
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<Integer> arista = adyacentes.proximo();
				j = arista.verticeDestino().getPosicion();
				if (!visitados[j]) {
					this.resolver(j, datos, destino, visitados, caminoMasCorto, caminoActual, maxAdyacentes, cantidadAdyacentes + adyacentes.tamanio());
				}
			}
		} else if ((caminoActual.tamanio() <= caminoMasCorto.tamanio() || caminoMasCorto.tamanio() == 0) ) {
			System.out.println("Actualizando camino");
			clear(caminoMasCorto);
			clonar(caminoActual, caminoMasCorto);
			maxAdyacentes = cantidadAdyacentes;
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());	
	}

	private Vertice<Integer> buscarOrigenYDestino(Grafo<Integer> datos, Integer origen, Integer destino) {
		ListaGenerica<Vertice<Integer>> listaDeVertices = datos.listaDeVertices();
		Vertice<Integer> verticeActual, verticeOrigen = null, verticeDestino = null;
		listaDeVertices.comenzar();
		while (!listaDeVertices.fin()) {
			verticeActual = listaDeVertices.proximo();
			if (verticeActual.dato().equals(origen)) {
				verticeOrigen = verticeActual;
			} else if (verticeActual.dato().equals(destino)) {
				verticeDestino = verticeActual;
			}
			if (verticeOrigen != null && verticeDestino!= null) {
				return verticeOrigen;
			}
		}
		return null;
	}
	
	private void clear(ListaGenerica<Integer> lista) {
		lista.comenzar();
		while (!lista.fin())
			lista.eliminar(lista.proximo());
	}

	private void clonar(ListaGenerica<Integer> listaActual, ListaGenerica<Integer> lista) {
		listaActual.comenzar();
		while (!listaActual.fin()) {
			lista.agregarFinal(listaActual.proximo());
		}
	}

}
