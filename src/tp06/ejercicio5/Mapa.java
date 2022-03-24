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

	private Vertice<String> buscarOrigen(String datoVertice) {
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
		Vertice<String> verticeCiudad1 = buscarOrigen(ciudad1);
		if (verticeCiudad1 != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.devolverCamino(verticeCiudad1.getPosicion(), ciudad2, visitados, camino);
		}
		return camino;
	}

	private void devolverCamino(int i, String ciudad2, boolean[] visitados, ListaGenerica<String> camino) {
		Vertice<String> verticeActual = this.mapaCiudades.listaDeVertices().elemento(i);
		camino.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin() && !camino.incluye(ciudad2)) {
				adyacenteActual = adyacentes.proximo();
				if (!visitados[adyacenteActual.verticeDestino().getPosicion()]) {
					this.devolverCamino(adyacenteActual.verticeDestino().getPosicion(), ciudad2, visitados, camino);
				}
			}
		}
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
		Vertice<String> verticeCiudad1 = buscarOrigen(ciudad1);
		if (verticeCiudad1 != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.devolverCaminoExceptuando(verticeCiudad1.getPosicion(), ciudad2, ciudades, visitados, camino);
		}
		return camino;
	}

	private void devolverCaminoExceptuando(int i, String ciudad2, ListaGenerica<String> ciudades, boolean[] visitados,
			ListaGenerica<String> camino) {
		Vertice<String> verticeActual = this.mapaCiudades.listaDeVertices().elemento(i);
		camino.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				adyacenteActual = adyacentes.proximo();
				if (!visitados[adyacenteActual.verticeDestino().getPosicion()]
						&& !ciudades.incluye(adyacenteActual.verticeDestino().dato())) {
					this.devolverCaminoExceptuando(adyacenteActual.verticeDestino().getPosicion(), ciudad2, ciudades,
							visitados, camino);
				}
			}
		}
		if (!camino.incluye(ciudad2)) {
			camino.eliminarEn(camino.tamanio());
		}

	}

	// Retorna la lista de ciudades que forman el camino más corto para llegar de
	// ciudad1 a ciudad2, si no existe camino retorna la lista vacía. (Las rutas
	// poseen la distancia). (Sin tener en cuenta el combustible).
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoMasCorto = new ListaEnlazadaGenerica<>();
		Vertice<String> verticeCiudad1 = buscarOrigen(ciudad1);
		if (verticeCiudad1 != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.caminoMasCorto(verticeCiudad1.getPosicion(), ciudad2, visitados, caminoActual, caminoMasCorto);
		}
		return caminoMasCorto;
	}

	private void caminoMasCorto(int i, String ciudad2, boolean[] visitados, ListaGenerica<String> caminoActual,
			ListaGenerica<String> caminoMasCorto) {
		Vertice<String> verticeActual = this.mapaCiudades.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				adyacenteActual = adyacentes.proximo();
				if (!visitados[adyacenteActual.verticeDestino().getPosicion()]) {
					this.caminoMasCorto(adyacenteActual.verticeDestino().getPosicion(), ciudad2, visitados,
							caminoActual, caminoMasCorto);
				}
			}
		} else if (caminoActual.tamanio() < caminoMasCorto.tamanio() || caminoMasCorto.tamanio() == 0) {
			clear(caminoMasCorto);
			clonar(caminoActual, caminoMasCorto);
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	// Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a
	// ciudad2. El auto no debe quedarse sin combustible y no puede cargar. Si no
	// existe camino retorna la lista vacía.
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		Vertice<String> verticeCiudad1 = buscarOrigen(ciudad1);
		if (verticeCiudad1 != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.caminoSinCargarCombustible(verticeCiudad1.getPosicion(), ciudad2, visitados, caminoActual, camino,
					tanqueAuto);
		}
		return camino;
	}

	private void caminoSinCargarCombustible(int i, String ciudad2, boolean[] visitados,
			ListaGenerica<String> caminoActual, ListaGenerica<String> camino, int tanqueAuto) {
		Vertice<String> verticeActual = this.mapaCiudades.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				adyacenteActual = adyacentes.proximo();
				if (!visitados[adyacenteActual.verticeDestino().getPosicion()]
						&& !(tanqueAuto <= adyacenteActual.peso())) {
					this.caminoSinCargarCombustible(adyacenteActual.verticeDestino().getPosicion(), ciudad2, visitados,
							caminoActual, camino, tanqueAuto - adyacenteActual.peso());
				}
			}
		} else {
			clear(camino);
			clonar(caminoActual, camino);
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	// Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a
	// ciudad2 teniendo en cuenta que el auto debe cargar la menor cantidad de
	// veces. El auto no se debe quedar sin combustible en medio de una ruta, además
	// puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
	// retorna la lista vacía.
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		Camino camino = new Camino();
		Vertice<String> verticeCiudad1 = buscarOrigen(ciudad1);
		if (verticeCiudad1 != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			this.caminoConMenorCargaDeCombustible(verticeCiudad1.getPosicion(), ciudad2, visitados, caminoActual,
					camino, tanqueAuto, tanqueAuto, 0);
		}
		return camino.getLista();
	}

	private void caminoConMenorCargaDeCombustible(int i, String ciudad2, boolean[] visitados,
			ListaGenerica<String> caminoActual, Camino camino, int tanqueAuto, int tanqueAuto2, int contador) {
		Vertice<String> verticeActual = this.mapaCiudades.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
		if (!verticeActual.dato().equals(ciudad2)) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				adyacenteActual = adyacentes.proximo();
				if (!visitados[adyacenteActual.verticeDestino().getPosicion()]) {
					if (tanqueAuto2 > adyacenteActual.peso()) {
						if (tanqueAuto <= adyacenteActual.peso()) {
							this.caminoConMenorCargaDeCombustible(adyacenteActual.verticeDestino().getPosicion(),
									ciudad2, visitados, caminoActual, camino, (tanqueAuto - adyacenteActual.peso()),
									tanqueAuto2, contador);
						} else {
							this.caminoConMenorCargaDeCombustible(adyacenteActual.verticeDestino().getPosicion(),
									ciudad2, visitados, caminoActual, camino, (tanqueAuto2 - adyacenteActual.peso()),
									tanqueAuto2, ++contador);
						}
					}
				}
			}
		} else {
			if (camino.getCosto() > contador) {
				camino.setCosto(contador);
				camino.clear();
				camino.setLista(caminoActual.clonar());
			}
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	private void clear(ListaGenerica<String> lista) {
		lista.comenzar();
		while (!lista.fin())
			lista.eliminar(lista.proximo());
	}

	private void clonar(ListaGenerica<String> listaActual, ListaGenerica<String> lista) {
		listaActual.comenzar();
		while (!listaActual.fin()) {
			lista.agregarFinal(listaActual.proximo());
		}
	}

}
