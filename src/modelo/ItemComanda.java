package modelo;

public class ItemComanda {
	private int cantidad;
	private ItemDeCarta itemCarta;
	
	public ItemComanda(int cant, ItemDeCarta itemCarta){
		super();
		this.cantidad = cant;
		this.itemCarta = itemCarta;
		itemCarta.preparar(cant);
	}
	
	public float getSubtotal(){
		return cantidad * itemCarta.getPrecio();
	}
}
