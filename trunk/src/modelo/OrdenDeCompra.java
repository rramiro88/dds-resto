/**
  * Las ordenes de compra se identifican por el n° de CUIT del proveedor.
  * Para diferenciar entre ordenes a nombre de un mismo proveedor se 
  * utiliza la fecha dia-mes-año (formato: dd/mm/aaaa) en que fueron generadas.
  * La fecha se carga como string y la recibe desde el atributo fecha del sistema
  * al momento de cerrar el día y generar las ordenes de compra.
  * 
  **/

package modelo;

import java.util.Vector;

public class OrdenDeCompra {
	private String 					cuitProveedor;
	private Vector<ItemDePedido> 	itemsDePedido;
	private Proveedor 				proveedor;
	private String 					fecha;	//	La fecha se escribe en formato dd/mm/aaaa

//	Constructor de instancia OrdenDecompra
//	-------------------------------------------------------------	
	public OrdenDeCompra (Proveedor prov, String date){
		this.cuitProveedor = prov.getCuit();
		this.fecha = date;
		this.proveedor = prov;
		itemsDePedido = new Vector<ItemDePedido>();
	}

//	Metodos sets y gets para los atributos de la clase OrdenDecompra
//	-------------------------------------------------------------	
	public String getCuitProveedor() {
		return cuitProveedor;
	}
	public void setCuitProveedor(String cuit) {
		this.cuitProveedor = cuit;
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

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

//	Metodos que operan con Items de Pedido
//	-------------------------------------------------------------	
	private ItemDePedido buscarItemDePedido (Producto prod){
 		for (int i=0; i<itemsDePedido.size(); i++){
 			ItemDePedido itemPed = itemsDePedido.elementAt(i);
			if (itemPed.getProducto().equals(prod)){
				System.out.println("Existe el ItemDePedido en la Orden de Compra");
				return itemPed;
			}
		}
		System.out.println("El ItemDePedido NO existe en esta Orden de Compra");
		return null;
	}

	//	El producto del ItemDePedido se valida en Restaurante.
	public void agregarItemDePedido(Producto prod, float cant){
		ItemDePedido itPed = buscarItemDePedido (prod);
		if (itPed == null){
			itPed = new ItemDePedido (prod, cant);
			itemsDePedido.add(itPed);
			System.out.println("ItemDePedido agregado a la Orden de Compra con exito.");
		}
	}
	
	public void eliminarItemDePedido(Producto prod){
		ItemDePedido itPed = buscarItemDePedido (prod);
		if (itPed != null){
			itemsDePedido.remove(itPed);
			System.out.println("ItemDePedido eliminado con exito.");
		}
	}

	public void modificarItemDePedido(Producto prod, float cant){
		ItemDePedido com = buscarItemDePedido (prod);
		if (com != null){
			com.setProducto(prod);
			com.setCantidad(cant);
			System.out.println("ItemDePedido modificado exitosamente.");
		}
	}

	
}
