package juego;
import java.util.Random;


public class Mazo {
	Carta[] mazo= new Carta[48];
	
	public Mazo(){
		int posicion= 0;
		for (int palo= 1; palo<=4; palo++){
			for (int numero= 1; numero<=12; numero++){
				mazo[posicion++]= new Carta(palo,numero);
			}
		}
		mezclar();
	}
	public void mezclar(){
		Random r= new Random();
		for(int k=0; k<1000; k++){
			int i= r.nextInt(mazo.length);
			int j= r.nextInt(mazo.length);
			Carta aux= mazo[i];
			this.mazo[i] = this.mazo[j];
			this.mazo[j] = aux;
		}
		
	}
	public void acomodarmazo() {

		for (int i=0;i<mazo.length-1;i++) {
			if (mazo[i]==null && mazo[i+1]!=null) {
				Carta xdd= mazo[i+1];
				mazo[i+1]=null;
				mazo[i]=xdd;
			}
		}
		return;
	}
	public int cantidadDeCartasMazo() {
		int cantcartas=0; 
		for(int i= 0; i<mazo.length;i++) {
			if (mazo[i]!=null) {
				cantcartas++;
			}
		}
		return cantcartas;
	}
}
