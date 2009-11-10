package modelo;

import java.util.Vector;


public class Comanda {
	
	private Vector<ItemComanda> itemsComanda;
	private Mozo mozo; //ver si hace falta
	private float total;
	
	
	public Comanda(Mozo mozo) {
		super();
		this.itemsComanda = new Vector<ItemComanda>();
		this.mozo = mozo;
		this.total = 0;
	}
	
	public void agregarItemComanda (int cant, ItemDeCarta itemCarta){
		itemsComanda.add(new ItemComanda(cant, itemCarta));
	}

	public float getTotal() {
		for (int i = 0; i<itemsComanda.size(); i++){
			total = total + itemsComanda.elementAt(i).getSubtotal();
		}
		return total;
	}

	public Mozo getMozo() {
		return mozo;
	}
}
