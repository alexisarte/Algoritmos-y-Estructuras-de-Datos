package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {

	private Grafo<String> mapaCiudades;

	public Mapa(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	private Vertice<String> buscarVertice(String datoVertice) {
		ListaGenerica<Vertice<String>> listaDeVertices = this.mapaCiudades.listaDeVertices();
		Vertice<String> verticeActual;
		listaDeVertices.comenzar();
		while (!listaDeVertices.fin()) {
			verticeActual = listaDeVertices.proximo();
			if (verticeActual.dato().equals(datoVertice))
				return verticeActual;
		}
		return null;
	}

	// Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a
	// ciudad2 en caso que se pueda llegar, si no retorna la lista vacía. (Sin tener
	// en cuenta el combustible).
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		Vertice<String> origen = buscarVertice(ciudad1);
		if (origen != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.devolverCamino(origen, ciudad2, visitados, camino);
		}
		return camino;
	}

	private void devolverCamino(Vertice<String> verticeActual, String ciudad2, boolean[] visitados,
			ListaGenerica<String> camino) {
		visitados[verticeActual.getPosicion()] = true;
		camino.agregarFinal(verticeActual.dato());
		Vertice<String> adyacente;
		Arista<String> arista;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			aristas.comenzar();
			while (!aristas.fin() && !camino.incluye(ciudad2)) {
				arista = aristas.proximo();
				adyacente = arista.verticeDestino();
				if (!visitados[adyacente.getPosicion()]) {
					this.devolverCamino(adyacente, ciudad2, visitados, camino);
				}
			}
		}
		// No es necesario desmarcar los vertices ya visitados porque se retorna el
		// primer camino encontrado.
		if (!camino.incluye(ciudad2)) {
			camino.eliminarEn(camino.tamanio());
		}
	}

	// Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2,
	// sin pasar por las ciudades que están contenidas en la lista ciudades pasada
	// por parámetro, si no existe camino retorna la lista vacía. (Sin tener en
	// cuenta el combustible).
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		Vertice<String> verticeOrigen = buscarVertice(ciudad1);
		Vertice<String> vertice = null;
		if (verticeOrigen != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			ciudades.comenzar();
			while (!ciudades.fin()) {
				vertice = buscarVertice(ciudades.proximo());
				if (vertice != null) {
					visitados[vertice.getPosicion()] = true;
				}
			}
			this.devolverCamino(vertice, ciudad2, visitados, camino);
		}
		return camino;
	}

	// Retorna la lista de ciudades que forman el camino más corto para llegar de
	// ciudad1 a ciudad2, si no existe camino retorna la lista vacía. (Las rutas
	// poseen la distancia). (Sin tener en cuenta el combustible).
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoMasCorto = new ListaEnlazadaGenerica<>();
		Vertice<String> origen = buscarVertice(ciudad1);
		if (origen != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.caminoMasCorto(origen, ciudad2, visitados, caminoActual, caminoMasCorto);
		}
		return caminoMasCorto;
	}

	private void caminoMasCorto(Vertice<String> verticeActual, String ciudad2, boolean[] visitados,
			ListaGenerica<String> caminoActual, ListaGenerica<String> caminoMasCorto) {
		visitados[verticeActual.getPosicion()] = true;
		caminoActual.agregarFinal(verticeActual.dato());
		Vertice<String> adyacente;
		Arista<String> arista;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			aristas.comenzar();
			while (!aristas.fin()) {
				arista = aristas.proximo();
				adyacente = arista.verticeDestino();
				if (!visitados[adyacente.getPosicion()]) {
					this.caminoMasCorto(adyacente, ciudad2, visitados, caminoActual, caminoMasCorto);
				}
			}
		} else if ((caminoActual.tamanio() < caminoMasCorto.tamanio()) || (caminoMasCorto.tamanio() == 0)) {
			caminoMasCorto.comenzar();
			while (!caminoMasCorto.fin()) {
				caminoMasCorto.eliminar(caminoMasCorto.proximo());
			}
			caminoActual.comenzar();
			while (!caminoActual.fin()) {
				caminoMasCorto.agregarFinal(caminoActual.proximo());
			}
		}
		visitados[verticeActual.getPosicion()] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	// Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a
	// ciudad2. El auto no debe quedarse sin combustible y no puede cargar. Si no
	// existe camino retorna la lista vacía.
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		Vertice<String> origen = buscarVertice(ciudad1);
		if (origen != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.caminoSinCargarCombustible(origen, ciudad2, visitados, camino, tanqueAuto);
		}
		return camino;
	}

	private void caminoSinCargarCombustible(Vertice<String> verticeActual, String ciudad2, boolean[] visitados,
			ListaGenerica<String> camino, int tanqueAuto) {
		visitados[verticeActual.getPosicion()] = true;
		camino.agregarFinal(verticeActual.dato());
		Vertice<String> adyacente;
		Arista<String> arista;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			aristas.comenzar();
			while (!aristas.fin() && !camino.incluye(ciudad2)) {
				arista = aristas.proximo();
				adyacente = arista.verticeDestino();
				if (!visitados[adyacente.getPosicion()] && !(tanqueAuto <= arista.peso())) {
					this.caminoSinCargarCombustible(adyacente, ciudad2, visitados, camino, tanqueAuto - arista.peso());
				}
			}
		}
		if (!camino.incluye(ciudad2)) {
			camino.eliminarEn(camino.tamanio());
		}
	}

	// Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a
	// ciudad2 teniendo en cuenta que el auto debe cargar la menor cantidad de
	// veces. El auto no se debe quedar sin combustible en medio de una ruta, además
	// puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
	// retorna la lista vacía.
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		Camino camino = new Camino();
		Vertice<String> origen = buscarVertice(ciudad1);
		if (origen != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.caminoConMenorCargaDeCombustible(origen, ciudad2, visitados, caminoActual, camino, tanqueAuto,
					tanqueAuto, 0);
		}
		return camino.getLista();
	}

	private void caminoConMenorCargaDeCombustible(Vertice<String> verticeActual, String ciudad2, boolean[] visitados,
			ListaGenerica<String> caminoActual, Camino camino, int tanqueAuto, int tanqueLleno, int cantCargas) {
		visitados[verticeActual.getPosicion()] = true;
		caminoActual.agregarFinal(verticeActual.dato());
		Vertice<String> adyacente;
		Arista<String> arista;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> aristas = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			aristas.comenzar();
			while (!aristas.fin()) {
				arista = aristas.proximo();
				adyacente = arista.verticeDestino();
				if (!visitados[adyacente.getPosicion()]) {
					if (tanqueLleno > arista.peso()) { // Si el costo de la ruta es menor que el tanque lleno
						if (tanqueAuto > arista.peso()) {
							this.caminoConMenorCargaDeCombustible(adyacente, ciudad2, visitados, caminoActual, camino,
									(tanqueAuto - arista.peso()), tanqueLleno, cantCargas);
						} else {
							// Si el auto se quedara sin combustible en medio de una ruta, se carga en la
							// ciudad actual y se continua con la ruta de la ciudad siguiente.
							this.caminoConMenorCargaDeCombustible(adyacente, ciudad2, visitados, caminoActual, camino,
									(tanqueLleno - arista.peso()), tanqueLleno, ++cantCargas);
						}
					}
				}
			}
		} else {
			if (cantCargas < camino.getCosto()) {
				camino.setCosto(cantCargas);
				camino.setLista(caminoActual.clonar());
			}
		}
		visitados[verticeActual.getPosicion()] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

}
