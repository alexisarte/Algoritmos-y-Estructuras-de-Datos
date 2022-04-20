package tp02.ejercicio4;

import java.util.Scanner;
import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese la cadena a balancear: ");
		String cadena = s.next();
		boolean answer = balance(cadena);
		s.close();
		
		if (answer == true) {
			System.out.println("Balanceada");
		} else {
			System.out.println("Desbalanceada");
		}
//		System.out.print(evaluarBalance(s.next()) ? "Balanceada" : "Desbalanceada");
	}
	
	public static boolean balance(String cadena) {
		Agrupador test = new Agrupador();
		PilaGenerica<Character> apertura = new PilaGenerica<Character>();
		int i = 0;
		char caracter;
		boolean balanceo = true;
		while (i < cadena.length() && balanceo) {
			caracter = cadena.charAt(i);
			if (test.esAgrupador(caracter)) {
				if (test.esApertura(caracter)) {
					apertura.apilar(caracter);
				}
				if (test.esCierre(caracter)) {
					if (apertura.esVacia()) {
						if (test.match(apertura.tope(), caracter)) {
							apertura.desapilar();
						}
						balanceo = false;
					}
					balanceo = false;
				}
			}
			++i;
		}
		return apertura.esVacia() && (i == cadena.length());
	}
	
	public static boolean evaluarBalance(String cadena) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		char caracter;
		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);
			if (caracter == '(' || caracter == '[' || caracter == '{') {
				pila.apilar(caracter);
			} else if (caracter == ')') {
				if (pila.esVacia() || pila.desapilar() != '(') {
					return false;
				}
			} else if (caracter == ']') {
				if (pila.esVacia() || pila.desapilar() != '[') {
					return false;
				}
			} else if (caracter == '}') {
				if (pila.esVacia() || pila.desapilar() != '{') {
					return false;
				}
			}
		}
		return pila.esVacia();
	}

}
