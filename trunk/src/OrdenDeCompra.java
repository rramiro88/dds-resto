
import java.util.Vector;

/**
 * Las ordenes de compra se identifican por el n° de CUIT del proveedor.
 * Para diferenciar entre ordenes a nombre de un mismo proveedor se 
 * utiliza la fecha dia-mes-año (formato: dd/mm/aaaa) en que fueron generadas.
 * 
 * **/

	public class OrdenDeCompra {
		//	private int numero;
		private String numero;
		private Vector<Producto> itemsDePedido;
		private Proveedor proveedor;
		private String fecha;	//	La fecha se debe escribir en formato dd/mm/aaaa
	
//	Constructor de instancia OrdenDecompra
//	-------------------------------------------------------------	
/**	
	La orden de compra recibe un proveedor y un vector de productos
	bajo punto de pedido que corresponde a ESE proveedor.
**/	
	public OrdenDeCompra (Proveedor prov, String date, Vector <Producto> itemsApedir){
//		this.numero = numero;
		this.numero = prov.getCuit();
		itemsDePedido = itemsApedir;
		this.proveedor = prov;
		this.fecha = date;
	}

//	Metodos sets y gets para los atributos de la clase OrdenDecompra
//	-------------------------------------------------------------	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String cuit) {
		this.numero = cuit;
	}

	public Vector<Producto> getItemsDePedido() {
		return itemsDePedido;
	}
	public void setItemsDePedido(Vector<Producto> itemsDePedido) {
		this.itemsDePedido = itemsDePedido;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

/*	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
*/
	
//	Metodos que operan con items de pedido
//	-------------------------------------------------------------

/*	public void cargarItemPedido (Producto produ){
		ItemDePedido itemp = new ItemDePedido(produ);
		this.itemsDePedido.add(itemp);
	}
*/
}