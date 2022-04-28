package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio5.AreaEmpresa;

public class CrearArbolGeneral {

//					-2				Nivel 0
//				  /     \				
//				-1	    -8			Nivel 1
//			  /     \  	 |
//			 -5     -4  -13			Nivel 2
//			  |   /  |  \
//			 18 -7  11   -3			Nivel 3
//			  |        / | | \
//			 -83 	 33 -6 17 9		Nivel 4
	
	public ArbolGeneral<Integer> crearArbolDeEnteros() {
		
		ArbolGeneral<Integer> arbol1 = new ArbolGeneral<Integer>(-2);
		ArbolGeneral<Integer> arbol2 = new ArbolGeneral<Integer>(-1);
		ArbolGeneral<Integer> arbol3 = new ArbolGeneral<Integer>(-8);
		ArbolGeneral<Integer> arbol4 = new ArbolGeneral<Integer>(-5);
		ArbolGeneral<Integer> arbol5 = new ArbolGeneral<Integer>(-4);
		ArbolGeneral<Integer> arbol6 = new ArbolGeneral<Integer>(-13);
		ArbolGeneral<Integer> arbol7 = new ArbolGeneral<Integer>(18);
		ArbolGeneral<Integer> arbol8 = new ArbolGeneral<Integer>(-7);
		ArbolGeneral<Integer> arbol9 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> arbol10 = new ArbolGeneral<Integer>(-3);
		ArbolGeneral<Integer> arbol11 = new ArbolGeneral<Integer>(-83);
		ArbolGeneral<Integer> arbol12 = new ArbolGeneral<Integer>(33);
		ArbolGeneral<Integer> arbol13 = new ArbolGeneral<Integer>(-6);
		ArbolGeneral<Integer> arbol14 = new ArbolGeneral<Integer>(17);
		ArbolGeneral<Integer> arbol15 = new ArbolGeneral<Integer>(9);
		
		arbol1.agregarHijo(arbol2);
		arbol1.agregarHijo(arbol3);
		arbol2.agregarHijo(arbol4);
		arbol2.agregarHijo(arbol5);
		arbol3.agregarHijo(arbol6);
		arbol4.agregarHijo(arbol7);
		arbol5.agregarHijo(arbol8);
		arbol5.agregarHijo(arbol9);
		arbol5.agregarHijo(arbol10);
		arbol7.agregarHijo(arbol11);
		arbol10.agregarHijo(arbol12);
		arbol10.agregarHijo(arbol13);
		arbol10.agregarHijo(arbol14);
		arbol10.agregarHijo(arbol15);
		
		return arbol1;
	}


	public ArbolGeneral<AreaEmpresa> crearArbolObjeto() {
		
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijos = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosJ = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosK = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosL = new ListaEnlazadaGenerica<>();

		// Nivel 2
		hijosJ.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('A', 4)));
		hijosJ.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('B', 7)));
		hijosJ.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('C', 5)));

		hijosK.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('D', 6)));
		hijosK.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('E', 10)));
		hijosK.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('F', 18)));

		hijosL.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('G', 9)));
		hijosL.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('H', 12)));
		hijosL.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('I', 19)));

		// Nivel 1
		ArbolGeneral<AreaEmpresa> nodoJ = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('J', 13), hijosJ);
		ArbolGeneral<AreaEmpresa> nodoK = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('K', 25), hijosK);
		ArbolGeneral<AreaEmpresa> nodoL = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('L', 10), hijosL);

		hijos.agregarFinal(nodoJ);
		hijos.agregarFinal(nodoK);
		hijos.agregarFinal(nodoL);
		
		// Nivel 0
		ArbolGeneral<AreaEmpresa> arbol = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa('M', 20), hijos);

		return arbol;
	}

	public ArbolGeneral<String> crearArbolString() {

		ListaEnlazadaGenerica<ArbolGeneral<String>> hijos = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijosG = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijosJ = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijosC = new ListaEnlazadaGenerica<>();
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijosD = new ListaEnlazadaGenerica<>();

		// Nivel 3
		hijosG.agregarFinal(new ArbolGeneral<String>("L"));

		hijosJ.agregarFinal(new ArbolGeneral<String>("M"));
		hijosJ.agregarFinal(new ArbolGeneral<String>("N"));

		// Nivel
		hijos.agregarFinal(new ArbolGeneral<String>("B"));
		ArbolGeneral<String> nodoC = new ArbolGeneral<String>("C", hijosC);
		hijosC.agregarFinal(new ArbolGeneral<String>("F"));
		ArbolGeneral<String> nodoG = new ArbolGeneral<String>("G", hijosG);
		hijosC.agregarFinal(nodoG);

		ArbolGeneral<String> nodoD = new ArbolGeneral<String>("D", hijosD);
		hijosD.agregarFinal(new ArbolGeneral<String>("H"));
		hijosD.agregarFinal(new ArbolGeneral<String>("I"));
		ArbolGeneral<String> nodoJ = new ArbolGeneral<String>("J", hijosJ);
		hijosD.agregarFinal(nodoJ);
		hijosD.agregarFinal(new ArbolGeneral<String>("K"));

		hijos.agregarFinal(nodoC);
		hijos.agregarFinal(nodoD);
		hijos.agregarFinal(new ArbolGeneral<String>("E"));

		// Nivel 0
		ArbolGeneral<String> arbol = new ArbolGeneral<String>("A", hijos);

		return arbol;
	}

}
