package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio5.Camino;

public class VisitaOslo {

	private Vertice<String> buscarOrigen(String datoVertice, ListaGenerica<Vertice<String>> listaDeVertices) {
		listaDeVertices.comenzar();
		while (!listaDeVertices.fin()) {
			Vertice<String> verticeActual = listaDeVertices.proximo();
			if (verticeActual.dato().equals(datoVertice))
				return verticeActual;
		}
		return null;
	}

	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,
			ListaGenerica<String> lugaresRestringidos) {
		Camino camino = new Camino();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<String>> listaDeVertices = lugares.listaDeVertices();
		Vertice<String> verticeOrigen = this.buscarOrigen("Ayuntamiento", listaDeVertices);
		if (verticeOrigen != null) {
			boolean[] visitados = new boolean[listaDeVertices.tamanio() + 1];
			this.paseoEnBici(verticeOrigen.getPosicion(), lugares, destino, maxTiempo, lugaresRestringidos, visitados,
					caminoActual, camino, 0);
		}
		System.out.println("\n" + "El recorrido se hace en " + camino.getCosto() + " minutos");
		return camino.getLista();
	}

	private boolean paseoEnBici(int i, Grafo<String> lugares, String destino, int maxTiempo,
			ListaGenerica<String> lugaresRestringidos, boolean[] visitados, ListaGenerica<String> caminoActual,
			Camino camino, int costoActual) {
		boolean ok = false;
		Vertice<String> verticeActual = lugares.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
		System.out.println("Estoy en: " + verticeActual.dato());
		if (!verticeActual.dato().equals(destino)) {
			ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin() && !caminoActual.incluye(destino) && !ok) {
				adyacenteActual = adyacentes.proximo();
				if (!(visitados[adyacenteActual.verticeDestino().getPosicion()])
						&& !((costoActual + adyacenteActual.peso()) > maxTiempo)
						&& !(lugaresRestringidos.incluye(adyacenteActual.verticeDestino().dato()))) {
					ok = this.paseoEnBici(adyacenteActual.verticeDestino().getPosicion(), lugares, destino, maxTiempo,
							lugaresRestringidos, visitados, caminoActual, camino, costoActual + adyacenteActual.peso());
				}
			}
		} else {
			camino.clonar(caminoActual);
			camino.setCosto(costoActual);
			return true;
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
		return ok;
	}

}
