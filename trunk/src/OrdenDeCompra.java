import java.util.Vector;

public class OrdenDeCompra {
//	private String numero;
	private int numero;
	private Vector <ItemDePedido> itemsDePedido;
	private Proveedor proveedor;
	
//	Constructor de instancia OrdenDecompra
//	-------------------------------------------------------------	
	public OrdenDeCompra (int numero, Proveedor proveedor){
//		this.numero = proveedor.getCuit();
		this.numero = numero;
		itemsDePedido = new Vector<ItemDePedido>();
		this.proveedor = proveedor;
	}

//	Metodos sets y gets para los atributos de la clase OrdenDecompra
//	-------------------------------------------------------------	
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
		ItemDePedido itemp = new ItemDePedido(produ);
		this.itemsDePedido.add(itemp);
	}
}