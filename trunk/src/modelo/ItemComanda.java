package modelo;

public class ItemComanda {
	private int cantidad;
	private ItemDeCarta itemCarta;
	
//	Constructor de instancia ItemComanda
//	-------------------------------------------------------------	
	public ItemComanda(int cant, ItemDeCarta itemCarta){
		super();
		this.cantidad = cant;
		this.itemCarta = itemCarta;
		itemCarta.preparar(cant);
	}
	
//	Metodos sets y gets para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	
	public float getSubtotal(){
		return (cantidad * itemCarta.getPrecio());
	}
}
