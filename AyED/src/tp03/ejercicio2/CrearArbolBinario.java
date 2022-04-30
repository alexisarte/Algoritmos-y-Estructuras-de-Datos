package tp03.ejercicio2;

public class CrearArbolBinario {
	
	public ArbolBinario<Integer> crearArbolInteger() {
//		Nivel 0
		ArbolBinario<Integer> arbol1 = new ArbolBinario<Integer>(1);

//		Nivel 1
		ArbolBinario<Integer> arbol2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> arbol3 = new ArbolBinario<Integer>(3);

//		Nivel 2
		ArbolBinario<Integer> arbol4 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> arbol5 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> arbol6 = new ArbolBinario<Integer>(6);
		
		arbol1.agregarHijoIzquierdo(arbol2);
		arbol1.agregarHijoDerecho(arbol3);
		arbol2.agregarHijoIzquierdo(arbol4);
		arbol2.agregarHijoDerecho(arbol5);
		arbol3.agregarHijoIzquierdo(arbol6);
		
		return arbol1;
	}
	
	public ArbolBinario<Integer> crearArbolInteger2() {

//		Nivel 0
		ArbolBinario<Integer> arbol1 = new ArbolBinario<Integer>(5);

//		Nivel 1
		ArbolBinario<Integer> arbol2 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> arbol3 = new ArbolBinario<Integer>(2);

//		Nivel 2
		ArbolBinario<Integer> arbol4 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> arbol5 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> arbol6 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> arbol7 = new ArbolBinario<Integer>(1);

//		Nivel 3
		ArbolBinario<Integer> arbol8 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> arbol9 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> arbol10 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> arbol11 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> arbol12 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> arbol13 = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> arbol14 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> arbol15 = new ArbolBinario<Integer>(7);

		arbol1.agregarHijoIzquierdo(arbol2);
		arbol1.agregarHijoDerecho(arbol3);
		arbol2.agregarHijoIzquierdo(arbol4);
		arbol2.agregarHijoDerecho(arbol5);
		arbol3.agregarHijoIzquierdo(arbol6);
		arbol3.agregarHijoDerecho(arbol7);
		arbol4.agregarHijoIzquierdo(arbol8);
		arbol4.agregarHijoDerecho(arbol9);
		arbol5.agregarHijoIzquierdo(arbol10);
		arbol5.agregarHijoDerecho(arbol11);
		arbol6.agregarHijoIzquierdo(arbol12);
		arbol6.agregarHijoDerecho(arbol13);
		arbol7.agregarHijoIzquierdo(arbol14);
		arbol7.agregarHijoDerecho(arbol15);

		return arbol1;
	}

	
	public ArbolBinario<String> crearArbolString() {

//		Nivel 0
		ArbolBinario<String> arbol1 = new ArbolBinario<String>("C");

//		Nivel 1
		ArbolBinario<String> arbol2 = new ArbolBinario<String>("A");
		ArbolBinario<String> arbol3 = new ArbolBinario<String>("E");

//		Nivel 2
		ArbolBinario<String> arbol4 = new ArbolBinario<String>("B");
		ArbolBinario<String> arbol5 = new ArbolBinario<String>("D");
		ArbolBinario<String> arbol6 = new ArbolBinario<String>("F");

		
		arbol1.agregarHijoIzquierdo(arbol2);
		arbol1.agregarHijoDerecho(arbol3);
		arbol2.agregarHijoIzquierdo(arbol4);
		arbol3.agregarHijoIzquierdo(arbol5);
		arbol3.agregarHijoDerecho(arbol6);

		return arbol1;
	}

}
