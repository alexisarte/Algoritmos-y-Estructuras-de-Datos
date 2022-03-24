package tp02.ejercicio4;

import java.util.Scanner;

import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese la cadena a balancear");
		System.out.print(evaluarBalance(s.next()) ? "Balanceada" : "Desbalanceada");
		s.close();
	}

	public static boolean evaluarBalance(String cadena) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				pila.apilar(c);
			} else if (c == ')') {
				if (pila.esVacia() || pila.desapilar() != '(') {
					return false;
				}
			} else if (c == ']') {
				if (pila.esVacia() || pila.desapilar() != '[') {
					return false;
				}
			} else if (c == '}') {
				if (pila.esVacia() || pila.desapilar() != '{') {
					return false;
				}
			}
		}
		return pila.esVacia();
	}
	
	
}
