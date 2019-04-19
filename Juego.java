package juego;

import java.util.Scanner;

public class Juego {
	
	public static void main(String[] args) {
		Mazo m= new Mazo();
		ManoDeJodete manojugador= new ManoDeJodete();
		Carta pozo;
		Scanner scan= new Scanner(System.in);
		for(int i=0; i<=4; i++) { //le doy 5 cartas al jugador
			manojugador.recibirCarta(m.mazo[0]);
			m.mazo[0]=null; //las quito del mazo
			m.acomodarmazo();// las acomodo
		  }
		manojugador.mostrar();
		
		pozo= new Carta(m.mazo[0].palo, m.mazo[0].numero);
		m.mazo[0]=null;//la quito del mazo

		m.acomodarmazo();//acomodo nuevamente el mazo
		System.out.println("Carta en la mesa: " + "PALO: " + pozo.palo + " NUMERO: " + pozo.numero);
		System.out.println(manojugador.cantidadDeCartas());
		while(manojugador.cantidadDeCartas()!=0) {
			int control= manojugador.cantidadDeCartas(); //para saber la cantidad inicial
			boolean nohay=true;//para saber si hay cartas que podes tirar 
			
			for(int i= 0; i<control; i++) { 
				if(manojugador.puedejugarla(manojugador.vacio[i], pozo)) { //verifico si puede jugar carta o no
					System.out.println("*Podes jugar: " + i );
					nohay=false;
				}
				else {
					if(i==control-1 && nohay==true) {
						System.out.println("---No podes jugar nada, recibis una carta :v");
						manojugador.recibirCarta(m.mazo[0]);//le doy una carta al player
						m.mazo[0]=null;//la elimino del mazo;
						m.acomodarmazo();//acomodo nuevamente el mazo
						
					}
				}
				if(i==control-1 && nohay==false) {
					System.out.println("---Ingrese la carta que desea jugar");
					int numero= scan.nextInt();
					if(manojugador.puedejugarla(manojugador.vacio[numero], pozo)) { //verifico si la carta que ingresa el player es valida
						pozo = manojugador.jugarCarta(numero);
						manojugador.acomodar01();
					}
					else {// si no es valida, alto loro :v
						System.out.println("Usted quizo tirar una carta no valida, por lo tanto, recibe una extra");
						manojugador.recibirCarta(m.mazo[0]);//le doy una carta al player
						m.mazo[0]=null;//la elimino del mazo;
						m.acomodarmazo();//acomodo nuevamente el mazo
					}
				}

			}
		control= manojugador.cantidadDeCartas(); //para saber la cantidad inicial
		nohay=true;//para saber si hay cartas que podes tirar 	
		System.out.println("Actualizacion de estado");
		System.out.println("Carta en la mesa: "+ "Palo: " + pozo.palo + " Numero: " + pozo.numero);
		manojugador.mostrar();
		//System.out.println(m.cantidadDeCartasMazo() + "Cantidad mazo");
		if (manojugador.cantidadDeCartas()==0) {
			System.out.println("você gana!KKKKK");
			}
		}
	}
	
}

