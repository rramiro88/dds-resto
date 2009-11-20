package modelo;

import java.util.Vector;

import controlador.ItemDeCartaView;


public abstract class ItemDeCarta {
	protected String name;
	protected float price;
	protected Vector <Ingrediente> ingredientes;
	public boolean disponible;
	protected int nroItem;
	protected static int ultimoNroItem = 0;

//	Constructor de instancia ItemDeCarta
//	-------------------------------------------------------------	
	public ItemDeCarta (String nombre, float precio){
		this.name = nombre;
		this.price = precio;
		ingredientes = new Vector<Ingrediente>();
		this.disponible = true;
		nroItem = getProximoNroItem();
	}

//	Metodos sets y gets para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	
	protected int getProximoNroItem(){
		return ++ultimoNroItem;		
	}
	public int getNroItem() {
		return nroItem;
	}

	public String getNombre() {
		return name;
	}
	public void setNombre(String name) {
		this.name = name;
	}

	public float getPrecio() {
		return price;
	}
	public void setPrecio(float price) {
		this.price = price;
	}

	public Vector<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Vector<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

//	Metodos que operan con Ingredientes
//	-------------------------------------------------------------	
	private Ingrediente buscarIngrediente (Producto prod){
 		for (int i=0; i<ingredientes.size(); i++){
 			Ingrediente ingred = ingredientes.elementAt(i);
			if (ingred.getProducto().equals(prod)){
				System.out.println("Existe el ingrediente");
				return ingred;
			}
		}
		System.out.println("El ingrediente NO existe en este item de carta");
		return null;
	}

	//	El producto del ingrediente se valida en Restaurante.
	public boolean agregarIngrediente(Producto prod, float cant){
		Ingrediente com = buscarIngrediente (prod);
		if (com == null){
			com = new Ingrediente (prod, cant);
			ingredientes.add(com);
			System.out.println("Ingrediente agregado con exito.");
			return true;
		}
		return false;
	}
	
	//	El producto del ingrediente se valida en Restaurante.
	public boolean eliminarIngrediente(Producto prod){
		Ingrediente com = buscarIngrediente (prod);
		if (com != null){
			ingredientes.remove(com);
			System.out.println("Ingrediente eliminado del plato/bebida con exito.");
			return true;
		}
		return false;
	}

	public boolean modificarIngrediente(Producto prod, float cant){
		Ingrediente com = buscarIngrediente (prod);
		if (com != null){
			com.setProducto(prod);
			com.setCantidad(cant);
			System.out.println("Ingrediente modificado exitosamente.");
			return true;
		}
		return false;
	}

	
//	Metodos para preparar items de carta (platos - bebidas)
//	-------------------------------------------------------------	
	/*	Revisa que la cantidad total de ingrediente alcance para
		preparar el total de items de carta requeridos.				*/
	public boolean esPreparable(int cantidadItemsDeCarta){
		//	Recorre todos los ingredientes del plato o bebida
		for (int i=0; i<ingredientes.size(); i++){
			Ingrediente ing = ingredientes.elementAt(i);
			// Revisa que el ingrediente pueda prepararse
			if (!ing.esSuficiente(cantidadItemsDeCarta * ing.getCantidad()))
				return false;
		}
		return true;
	}
	
	//	Ordena al ingrediente preparar el total de items de carta requeridos
	public void preparar (int cantidadItemsDeCarta){
		for (int i=0; i<ingredientes.size(); i++){
			Ingrediente ing = ingredientes.elementAt(i);
			ing.usar((ing.getCantidad()*cantidadItemsDeCarta));
		}
	}
	
	//	Metodo get que devuelve un ItemDeCartaView para pasar a la vista
	public ItemDeCartaView getItemDeCartaView(){
		ItemDeCartaView icv = new ItemDeCartaView(name, price);
		return icv;
	}
	
}