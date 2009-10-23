import java.util.Vector;

public class OrdenDeCompra {
	private int numero;
	private Vector <ItemDePedido> itemsDePedido;
	private Proveedor proveedor;

	public OrdenDeCompra (int numero, Proveedor proveedor){
		this.numero = numero;
		itemsDePedido = new Vector<ItemDePedido>();
		this.proveedor = proveedor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Vector<ItemDePedido> getItemsDePedido() {
		return itemsDePedido;
	}

	public void setItemsDePedido(Vector<ItemDePedido> itemsDePedido) {
		this.itemsDePedido = itemsDePedido;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

//	Metodos que operan con items de pedido
//	-------------------------------------------------------------
	
	public void cargarItemPedido (Producto produ){
		ItemDePedido itemp = new ItemDePedido(produ.getPuntoreab(), produ);
		this.itemsDePedido.add(itemp);
	}
	
}