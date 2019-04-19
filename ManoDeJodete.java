package juego;
public class ManoDeJodete {
    Carta[] vacio;
	
	public ManoDeJodete(){
		vacio= new Carta[40];
	}
	public void mostrar(){
		for(int i=0; i<vacio.length;i++){
			if(vacio[i]!=null){
			System.out.println("palo: " + vacio[i].palo + " numero: " + vacio[i].numero );
			}
		}
	}
	public void recibirCarta(Carta c) {
		if (c==null) {
			throw new java.lang.NullPointerException("No hay más cartas en el mazo");
		}
			for( int p= 0; p<vacio.length; p++) {
					if (vacio[p]==null) {
						vacio[p]= new Carta(c.palo, c.numero);
						return;
					}
				}
				
	}
	
	public Carta jugarCarta(int i) {
		Carta aux= vacio[i];
		vacio[i]=null;
		return aux;
	}
	
	public int cantidadDeCartas() {
		int cantcartas=0; 
		for(int i= 0; i<vacio.length;i++) {
			if (vacio[i]!=null) {
				cantcartas++;
			}
		}
		return cantcartas;
	}
	
	public void acomodar01() {
			
			for (int i=0;i<vacio.length-1;i++) {
				if (vacio[i]==null && vacio[i+1]!=null) {
					Carta xdd= vacio[i+1];
					vacio[i+1]=null;
					vacio[i]=xdd;
				}
		}
	return;
	}
	public boolean puedejugarla(Carta uno, Carta dos){
		if (uno==null) {
			throw new java.lang.NullPointerException("No existe esa carta, pa'");
		}
		if (uno.numero==dos.numero) {
			return true;
		}
		if(uno.palo==dos.palo) {
			return true;
		}
	return false;	
	}
}
