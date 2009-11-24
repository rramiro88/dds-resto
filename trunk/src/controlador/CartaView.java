package controlador;

import java.util.Vector;


public class CartaView {
	private String dia;

//	Constructor de instancia Carta
//	-------------------------------------------------------------	
	public CartaView (String day){
		this.dia = day;
	}

	//	REVISARLO - NO SE SI SIRVE
	public Vector toVector(){
		Vector v = new Vector();
		v.add(dia);
		return v;
	}
	
//	Metodo get para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	
	public String getDia() {
		return dia;
	}

}
