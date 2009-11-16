package modelo;

import java.util.Vector;

public class Comanda {
	private Vector<ItemComanda> itemsComanda;
	private Mozo mozo; //ver si hace falta
	//private float total;
	
//	Constructor de instancia Comanda
//	-------------------------------------------------------------	
	public Comanda(Mozo mozo) {
		super();
		this.itemsComanda = new Vector<ItemComanda>();
		this.mozo = mozo;
		//this.total = 0;
	}
	
//	Metodos que operan con Comandas
//	-------------------------------------------------------------	
	public void agregarItemComanda (int cant, ItemDeCarta itemCarta){
		itemsComanda.add(new ItemComanda(cant, itemCarta));
	}

	public float getTotal() {
		float totalComanda = 0;
		for (int i = 0; i<itemsComanda.size(); i++){
			totalComanda = totalComanda + itemsComanda.elementAt(i).getSubtotal();
		}
		return totalComanda;
	}

	public Mozo getMozo() {
		return mozo;
	}
}
