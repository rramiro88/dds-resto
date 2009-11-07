import java.util.Vector;

public abstract class ItemDeCarta {
	private String name;
	private float price;
	private Vector <Ingrediente> ingredientes;
	boolean disponible;
	private int nroItem;
	private static int ultimoNroItem = 0;

	
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
	private int getProximoNroItem(){
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

//	Metodos con Ingredientes
//	-------------------------------------------------------------	
	public Ingrediente buscarIngrediente (Producto prod){
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

	public void agregarIngrediente(Producto prod, float cant){
		Ingrediente com = buscarIngrediente (prod);
		if (com == null){
			com = new Ingrediente (prod, cant);
			ingredientes.add(com);
			System.out.println("Ingrediente agregado con exito.");
		}
	}
	
	public void eliminarIngrediente(Producto prod){
		Ingrediente com = buscarIngrediente (prod);
		if (com != null){
			ingredientes.remove(com);
			System.out.println("Ingrediente eliminado con exito.");
		}
	}

	public void modificarIngrediente(Producto prod, float cant){
		Ingrediente com = buscarIngrediente (prod);
		if (com != null){
			com.setProducto(prod);
			com.setCantidad(cant);
			System.out.println("Ingrediente modificado exitosamente.");
		}
	}

	public void listarIngredientes (){
		Vector <Ingrediente> ingreList = this.getIngredientes();
		for (int i=0; i<ingreList.size(); i++){
 			Ingrediente ingred = ingreList.elementAt(i);
 			System.out.println("Producto: "+ ingred.getProducto());
 			System.out.println("Cantidad: "+ ingred.getCantidad());
 			System.out.println(" ");
		}
	}

	public boolean esPreparable(int cantidadItemsDeCarta){
		for (int i=0; i<ingredientes.size(); i++){
			Ingrediente ing = ingredientes.elementAt(i);
//			if (!ing.esSuficiente(ing.getCantidad()*cantidad)){
			if (ing.esSuficiente(cantidadItemsDeCarta * ing.getCantidad())){
				return false;
			}
		}
		return true;
	}
	
	public void preparar (int cantidad){
		for (int i=0; i<ingredientes.size(); i++){
			Ingrediente ing = ingredientes.elementAt(i);
			ing.usar((ing.getCantidad()*cantidad));
		}
	}
	
}