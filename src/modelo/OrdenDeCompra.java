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
	public Proveedor getProveedor() {
		return proveedor;
	}

	public String getFecha() {
		return fecha;
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

	
}
