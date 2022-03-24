package parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

/**
 * @author Alexis
 *
 */
public class BuscadorDeCaminos {

	private Grafo<String> bosque;

	public BuscadorDeCaminos(Grafo<String> bosque) {
		this.bosque = bosque;
	}

	public ListaGenerica<String> recorridoMasCortoYSeguro() {
		ListaGenerica<String> caminoMasCorto = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		Vertice<String> casaCaperucita = buscarCasaCaperucita("Buenos Aires");
		if (casaCaperucita != null ) {
			boolean[] visitados = new boolean[this.bosque.listaDeVertices().tamanio() + 1];
			this.recorridoMasCortoYSeguro(casaCaperucita.getPosicion(), "Asuncion", visitados, caminoMasCorto, caminoActual);
		}
		return caminoMasCorto;
	}
	
	private void recorridoMasCortoYSeguro(int i, String casaAbuelita, boolean[] visitados, ListaGenerica<String> caminoMasCorto,
			ListaGenerica<String> caminoActual) {
		Vertice<String> verticeActual = this.bosque.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(verticeActual.dato());
		visitados[i] = true;
		Arista<String> adyacenteActual;
//		System.out.println("Estoy en: " + verticeActual.dato());
		if (!verticeActual.dato().equals(casaAbuelita)) {
			ListaGenerica<Arista<String>> adyacentes = this.bosque.listaDeAdyacentes(verticeActual);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				adyacenteActual = adyacentes.proximo();
				if (!visitados[adyacenteActual.verticeDestino().getPosicion()] && adyacenteActual.peso() < 5) {
					this.recorridoMasCortoYSeguro(adyacenteActual.verticeDestino().getPosicion(), casaAbuelita, visitados,
							caminoMasCorto, caminoActual);
				}
			}
		} else if (caminoActual.tamanio() < caminoMasCorto.tamanio() || caminoMasCorto.tamanio() == 0) {
			clear(caminoMasCorto);
			clonar(caminoActual, caminoMasCorto);
		}
		visitados[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	private Vertice<String> buscarCasaCaperucita(String casaCaperucita) {
		ListaGenerica<Vertice<String>> listaDeVertices = this.bosque.listaDeVertices();
		Vertice<String> verticeActual;
		listaDeVertices.comenzar();
		while (!listaDeVertices.fin()) {
			verticeActual = listaDeVertices.proximo();
			if (verticeActual.dato().equals(casaCaperucita))
				return verticeActual;
		}
		return null;
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
