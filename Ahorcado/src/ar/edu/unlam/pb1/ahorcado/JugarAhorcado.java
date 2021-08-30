
package ar.edu.unlam.pb1.ahorcado;

import java.util.Scanner;

public class JugarAhorcado {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String letra;
		String persona;
		String palabra;
		Integer win = 0;
		System.out.println("Jugador 1, ingresá tu nombre: ");
		persona = teclado.next();
		System.out.println(persona + ", ingresa una palabra en secreto para que tu oponente adivine");
		palabra = teclado.next();
		Jugador jugador1 = new Jugador(persona, "Palabra");
		for(int clear = 0; clear < 1000; clear++) { System.out.println("\n") ; }
		System.out.println("Jugador 2, ingresá tu nombre: ");
		persona = teclado.next();
		Jugador jugador2 = new Jugador(persona, palabra);
		System.out.println(persona + ", ingresa una palabra en secreto para que tu oponente adivine");
		palabra = teclado.next();
		jugador1.setPalabra(palabra);
		for(int clear = 0; clear < 1000; clear++) { System.out.println("\n") ; }

		sortear(jugador1, jugador2);

		jugar(jugador1, jugador2);

	}
	


	private static void sortear(Jugador jugador1, Jugador jugador2) {
		Double sorteo;
		sorteo = 1 * Math.random();
		if (sorteo > 0.5) {
			System.out.println("Comienza " + jugador1.getName());
			jugador1.turnar();
		} else {
			System.out.println("Comienza " + jugador2.getName());
			jugador2.turnar();
		}
	}

	private static void jugar(Jugador jugador1, Jugador jugador2) {
		Integer win = 0;
		Integer ronda = 0;
		while (win == 0 && (jugador1.getVidas()>0 && jugador2.getVidas()>0)) {
			if (jugador1.getTurno()) {
				System.out.println(jugador1.getName() + ", adivina la palabra: ");
				System.out.println(jugador1.getPalabraOculta());
				win = turno(jugador1);
				jugador1.turnar();
				jugador2.turnar();
			} else if (jugador2.getTurno()) {
				System.out.println(jugador2.getName() + ", adivina la palabra: ");
				System.out.println(jugador2.getPalabraOculta());
				win = turno(jugador2);
				jugador1.turnar();
				jugador2.turnar();
			}
			ronda += 1;
		}
	}

	private static Integer turno(Jugador jugador) {
		Integer win = 0;
		Scanner teclado = new Scanner(System.in);
		Character letra = 'a';
		jugador.getPalabraOculta();
		System.out.println(jugador.getName() + ", tus opciones son:");
		System.out.println("1) Adivinar letra");
		System.out.println("2) Arriesgar palabra");
		System.out.println("3) Terminar juego");
		System.out.println("Te quedan " + jugador.getVidas() + " vidas.");
		Integer select = teclado.nextInt();
		switch (select) {
		case 1:
			System.out.println(jugador.getName() + ", ingresa una letra:");
			letra = teclado.next().charAt(0);
			String oculta = jugador.getPalabraOculta().toUpperCase();
			jugador.setPalabraOculta(letra);
			System.out.println(jugador.getPalabraOculta());
			if (oculta.equalsIgnoreCase(jugador.getPalabraOculta().toUpperCase())) {
				jugador.pierdeVida();
				System.out.println(	"Ups! no adividaste. " + jugador.getName() + ", te quedan " + jugador.getVidas() + " vidas.");
				if(jugador.getVidas()==0) {
					System.out.println(jugador.getName() + " has perdido el juego");
				}
			} else {
				System.out.println("Perfecto, " + jugador.getName() + "!");
			}
			break;
		case 2:
			System.out.println("Arriesga la palabra:");
			String arriesgue = teclado.next();
			String palabra = jugador.getPalabra();

			if (arriesgue.toUpperCase().equals(palabra.toUpperCase())) {
				System.out.println("Muy bien, " + jugador.getName() + ".Ganaste!!!!");
				win = 1;
			} else {
				System.out.println("Incorrecto, " + jugador.getName() + ":( . Pierdes el juego");
				win = 1;
			}
			break;
		case 3:
			System.out.println("Adiós");
			win = 1;
			break;
		default:
			System.out.println("Ninguna de las opciones es correcta");
			break;
		}

		return win;
	}

}
