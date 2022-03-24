package parcial;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;
import tp06.ejercicio4.CargarGrafo;

public class TestParcialRodriguez {

	public static void main(String[] args) {
		Grafo<Integer> grafoNuevo = new GrafoImplListAdy<>();
		Vertice<Integer> vert1 = new VerticeImplListAdy<>(1);
		grafoNuevo.agregarVertice(vert1);
		Vertice<Integer> vert2 = new VerticeImplListAdy<>(2);
		grafoNuevo.agregarVertice(vert2);
		Vertice<Integer> vert3 = new VerticeImplListAdy<>(3);
		grafoNuevo.agregarVertice(vert3);
		Vertice<Integer> vert4 = new VerticeImplListAdy<>(4);
		grafoNuevo.agregarVertice(vert4);
		Vertice<Integer> vert5 = new VerticeImplListAdy<>(5);
		grafoNuevo.agregarVertice(vert5);
		Vertice<Integer> vert6 = new VerticeImplListAdy<>(6);
		grafoNuevo.agregarVertice(vert6);
		Vertice<Integer> vert7 = new VerticeImplListAdy<>(7);
		grafoNuevo.agregarVertice(vert7);
		Vertice<Integer> vert8 = new VerticeImplListAdy<>(8);
		grafoNuevo.agregarVertice(vert8);
		Vertice<Integer> vert9 = new VerticeImplListAdy<>(9);
		grafoNuevo.agregarVertice(vert9);
		Vertice<Integer> vert10 = new VerticeImplListAdy<>(10);
		grafoNuevo.agregarVertice(vert10);
		grafoNuevo.conectar(vert1,vert2,0);
		grafoNuevo.conectar(vert1,vert4,0);
		grafoNuevo.conectar(vert2,vert1,0);
		grafoNuevo.conectar(vert2,vert3,0);
		grafoNuevo.conectar(vert2,vert4,0);
		
		grafoNuevo.conectar(vert3,vert2,0);
		grafoNuevo.conectar(vert3,vert4,0);
		grafoNuevo.conectar(vert3,vert7,0);
		grafoNuevo.conectar(vert3,vert9,0);
		
		
		grafoNuevo.conectar(vert4,vert1,0);
		grafoNuevo.conectar(vert4,vert2,0);
		grafoNuevo.conectar(vert4,vert3,0);
		grafoNuevo.conectar(vert4,vert5,0);
		grafoNuevo.conectar(vert4,vert6,0);
		
		grafoNuevo.conectar(vert5,vert4,0);
		
		grafoNuevo.conectar(vert6,vert4,0);
		grafoNuevo.conectar(vert6,vert7,0);
		
		grafoNuevo.conectar(vert7,vert3,0);
		grafoNuevo.conectar(vert7,vert6,0);
		grafoNuevo.conectar(vert7,vert8,0);
		grafoNuevo.conectar(vert7,vert10,0);
		
		grafoNuevo.conectar(vert8,vert7,0);
		grafoNuevo.conectar(vert8,vert9,0);
		
		grafoNuevo.conectar(vert9,vert3,0);
		grafoNuevo.conectar(vert9,vert8,0);
		
		
		
//		CargarGrafo crear = new CargarGrafo();
//		Grafo<Integer> grafo = crear.cargarGrafoInteger();
		
		ParcialRodriguez parcial = new ParcialRodriguez();
		ListaGenerica<Integer> lista = parcial.resolver(grafoNuevo, 1, 10);
		System.out.println(lista.tamanio());
		System.out.println(lista.toString());
	}

}
