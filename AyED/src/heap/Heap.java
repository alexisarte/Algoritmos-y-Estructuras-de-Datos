package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

	List<Integer> elements;
	
	public Heap(List<Integer> dato) {
		this.elements = new ArrayList<>();
		this.elements.add(null); // centinela
	}

	public void insert(int x) {
		this.elements.add(x);	// Agrega temporalmente al final
		this.percolateUp(this.elements.size());
	}

	public void percolateUp(Integer i) {
		Integer elementToInsert = this.elements.get(i);
		
		// Si el padre es mayor al hijo, baja al padre a la posicion del hijo
		while ((i / 2) > 0 && elementToInsert.compareTo(this.elements.get(i / 2)) > 0) {
			this.elements.set(i, this.elements.get(i/2));
			i = i / 2;
		}
		this.elements.set(i, elementToInsert);	// Ubicación correcta del elemento a filtrar
	}
	
	public Integer deleteMin(int x) {
		Integer minimum = null;
		
		if (!this.elements.isEmpty()) {
			minimum = this.elements.get(1);
			this.percolateDown(1);
		}
		return minimum;
	}
	
	public void percolateDown(Integer p) {
		Integer posHijoMenor;
		Boolean stopPercolate = false;
		Integer candidato = this.elements.remove(this.elements.size()); // elimina y guarda el ultimo elemento
		
		while (2 * p <= this.elements.size() && !stopPercolate) { 
			// hijo izquierso
			posHijoMenor = 2 * p;
			if (posHijoMenor != this.elements.size()) {
				// si el hijo derecho es menor al izquierdo, me quedo con su posicion
				if (this.elements.get(posHijoMenor + 1).compareTo(this.elements.get(posHijoMenor)) < 0) {
					posHijoMenor++; 
				}
				// Si el menor de los hijos es menor al padre, entonces sube el hijo
				if (this.elements.get(posHijoMenor).compareTo(candidato) < 0) {
					this.elements.set(p, this.elements.get(posHijoMenor));
					p = posHijoMenor;
					
				} else {
					stopPercolate = true;
				}
			}
		}
		this.elements.set(p, candidato);
	}
	
	public int size() {
		return this.elements.size();
	}
	

}
