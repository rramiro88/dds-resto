import java.util.Vector;

public class Restaurante {
	private Vector <ItemDeCarta> itemsCarta;
	private Vector <Carta> cartas;
	private Vector<Mozo> mozos;
	private Vector<Comanda> comandas;
	private Vector<Mesa> mesas;
	private Vector <Proveedor> proveedores;
	private Vector <OrdenDeCompra> ordenesCompra;
	private Vector <Producto> productos;

	private boolean mesasAsignadas;

	private boolean open;

	public Restaurante (){
		itemsCarta = new Vector <ItemDeCarta>();
		cartas = new Vector <Carta>();
		productos = new Vector <Producto>();
		
		mozos = new Vector <Mozo> ();
		comandas = new Vector <Comanda> ();
		mesas = new Vector <Mesa> ();
	}
	
	public Vector<ItemDeCarta> getItemsCarta() {
		return itemsCarta;
	}
	public void setItemsCarta(Vector<ItemDeCarta> itemsCarta) {
		this.itemsCarta = itemsCarta;
	}
	public Vector<Carta> getCartas() {
		return cartas;
	}
	public void setCartas(Vector<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Vector<Mozo> getMozos() {
		return mozos;
	}
	
	public Vector<Mesa> getMesas() {
		return mesas;
	}
	public boolean isMesasAsignadas() {
		return mesasAsignadas;
	}
	public void setMesasAsignadas(boolean mesasAsignadas) {
		this.mesasAsignadas = mesasAsignadas;
	}

	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

//	Metodos que operan con platos o bebidas (Items De Carta)
//	-------------------------------------------------------------	
	public ItemDeCarta buscarItemDeCarta (String nombre){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNombre().equals(nombre)){
				System.out.println("item existente");
				return idecarta;
			}
		}
		System.out.println("item NO existe");
 		return null;
	}
	
	public ItemDeCarta buscarItemDeCarta (int nro){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNroItem() == nro){
				System.out.println("item existente");
				return idecarta;
			}
		}
		System.out.println("item NO existe");
 		return null;
	}

	public void altaDePlato (String nombre, float precio){
		ItemDeCarta itemc = buscarItemDeCarta(nombre);
		if (itemc == null){
			Plato redondo = new Plato (nombre, precio);
			itemsCarta.add(redondo);
			System.out.println("Plato creado con exito.");
		}
	}

	public void altaDeBebida (String nombre, float precio){
		ItemDeCarta itemc = buscarItemDeCarta(nombre);
		if (itemc == null){
			Bebida vaso = new Bebida (nombre, precio);
			itemsCarta.add(vaso);
			System.out.println("Bebida creada con exito.");
		}
	}	
	
	public void bajaDeItemDeCarta (String nombre){
		ItemDeCarta itemc = buscarItemDeCarta(nombre);
		if (itemc != null){
			itemsCarta.remove(itemc);
		}
	}
	
	public void listarItemsCarta (){
		Vector <ItemDeCarta> itcart = this.getItemsCarta();
		for (int i=0;i<itcart.size();i++){
			ItemDeCarta c = (ItemDeCarta)itcart.elementAt(i);
			//	Listar items de carta disponibles
			if (c.disponible){
				System.out.print("id: "+ c.getNroItem());
				System.out.print("	Nombre: "+ c.getNombre());
				System.out.println("	$ "+ c.getPrecio());
				System.out.println("-----");
			}
		}
	}
	
	
	
//	Metodos que operan con Carta
//	-------------------------------------------------------------
	public Carta buscarCarta (String dia){
 		for (int i=0; i<cartas.size(); i++){
			Carta car = cartas.elementAt(i);
			if (car.getDia().equals(dia)){
				System.out.println("carta existente");
				return car;
			}
		}
		System.out.println("carta NO existe.");
 		return null;
	}

	public void altaDeCarta (String dia){
		Carta letter = buscarCarta(dia);
		if (letter == null){
			letter = new Carta (dia);
			cartas.add(letter);
			System.out.println("Carta creada con exito.");
		}
	}

	public void bajaDeCarta (String dia){
		Carta letter = buscarCarta(dia);
		if (letter != null){
			cartas.remove(letter);
			System.out.println("Carta eliminada con exito.");
		}
	}
	
	public void cargarCarta (String nombreCarta, String nombreItem){
		Carta letter = buscarCarta(nombreCarta);
		if (letter != null){
			ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
			if (itemc != null){
				letter.agregarItemCarta(itemc);
			}
		}
		
	}

	public void descargarCarta (String nombreCarta, String nombreItem){
		Carta letter = buscarCarta(nombreCarta);
		if (letter != null){
			ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
			if (itemc == null){
				letter.eliminarItemCarta(itemc);
			}
		}
	}

	public void detalleCarta (String nombreCarta){
		Carta letter = buscarCarta(nombreCarta);
		if (letter != null){
			Vector <ItemDeCarta> it = letter.getItemsCarta();
			System.out.println("");
			System.out.println("Nombre: "+ letter.getDia());
			System.out.println("Activa: "+ letter.isHabilitada());
			System.out.println("");
			for (int i=0; i<it.size(); i++){
				ItemDeCarta car = it.elementAt(i);
				System.out.print("Item: "+ car.getNombre());
				System.out.print("		Precio: "+ car.getPrecio());
			}
		}
	}


//	Metodos que operan con Productos
//	-------------------------------------------------------------
	public Producto buscarProducto (String materia){
 		for (int i=0; i<productos.size(); i++){
			Producto prod = productos.elementAt(i);
			if (prod.getNombre().equals(materia)){
				System.out.println("producto existente");
				return prod;
			}
		}
		System.out.println("producto NO existe.");
 		return null;
	}
	
	public void altaDeProducto (String materia, float cantidad, float pedido, float reab, Proveedor prov){
		Producto prod = buscarProducto(materia);
		if (prod == null){
			prod = new Producto(materia, cantidad, pedido, reab, prov);
			productos.add(prod);
			System.out.println("Producto creado con exito.");
		}
	}

	public void bajaDeProducto (String nombre){
		Producto prod = buscarProducto(nombre);
		if (prod != null){
			productos.remove(prod);
			System.out.println("producto eliminado con exito.");
		}
	}
	
	public void modificarProducto (String name, float canti, float puntop, float puntor, Proveedor prov){
		Producto prod = buscarProducto(name);
		if (prod != null){
			prod.setNombre(name);
			prod.setCantidad(canti);
			prod.setPuntoped(puntop);
			prod.setPuntoreab(puntor);
			prod.setProveedor(prov);
		}		
	}

	// Actualizar stock cuando ingresa mercaderia nueva
	public void ingresarMercaderia (String produc, float cantidad){
		Producto prod = buscarProducto(produc);
		if (prod != null){
			float viejaCantidad = prod.getCantidad();
			float nuevaCantidad = viejaCantidad + cantidad;
			prod.setCantidad(nuevaCantidad);
		}
	}

//	Metodos que operan con Ordenes de Compra
//	-------------------------------------------------------------

	 public OrdenDeCompra buscarOrden (int nro){
	 	for (int i=0; i<proveedores.size(); i++){
	 		OrdenDeCompra ord = ordenesCompra.elementAt(i);
			if (ord.getNumero()==(nro)){
				System.out.println("Existe la orden de compra");
				return ord;
			}
		}
		System.out.println("La orden de compra NO existe");
		return null;
	}

	public void altaDeOrden (int nro, int cuit){
		Proveedor prov = buscarProveedor(cuit);
		OrdenDeCompra ord = buscarOrden (nro);
		if (prov != null){
			if (ord == null){
				ord = new OrdenDeCompra(nro, prov);
				ordenesCompra.add(ord);
				System.out.println("Orden de compra creada con exito.");
			}
		}
	}

	public void bajaDeOrden (int nro){
		OrdenDeCompra ord = buscarOrden (nro);
		if (ord != null){
			ordenesCompra.remove(nro);
			System.out.println("Orden eliminada con exito.");
		}
	}

	public void modificarOrden(int cuit, int nro){
		Proveedor prov = buscarProveedor(cuit);
		OrdenDeCompra ord = buscarOrden (nro);
		if (prov != null){
			if (ord != null){
				ord.setNumero(nro);
				ord.setProveedor(prov);
				System.out.println("Proveedor modificado exitosamente.");
			}
		}
	}
	
	public void cargarOrdenCompra (int nro){
		OrdenDeCompra ord = buscarOrden (nro);
		if (ord != null){
			for (int i=0; i<productos.size();i++){
				Producto prod = productos.elementAt(i);
				if (!prod.isDisponible() && prod.getProveedor().equals(ord.getProveedor())){
					ord.cargarItemPedido(prod);
				}
			}
		}
	}

//	Metodos que operan con Mozos
//	-------------------------------------------------------------
	public int cantidadMozos (){
 		//return (mozos.size());
		int mozosOk = 0;
		for (int i=0; i<mozos.size();i++){
			Mozo m = mozos.elementAt(i);
			if (m.getHabilitado()){
				mozosOk++;
			}
		}
		return mozosOk;
 	}
	
	public int mozosTotales(){
		return (mozos.size());
	}
	
	public void altaDeMozo (String nombre, int idMozo, float comision){
		Mozo mozoNuevo = buscarMozo(idMozo);
		if (mozoNuevo == null){
			Mozo pibenuevo = new Mozo (nombre, idMozo, comision);
			mozos.add(pibenuevo);
			System.out.println("Mozo creado con exito.");
		}else{
			System.out.println("El id de Mozo ya existe.");
		}
	}
	
	public void habilitarMozo (int idMozo){
		Mozo mozoHab = buscarMozo(idMozo);
		if (mozoHab != null){
			mozoHab.setHabilitado();
			System.out.println("Mozo" +idMozo+ "habilitado con exito.");
		}else{
			System.out.println("Mozo" +idMozo+ "NO habilitado. Id no existente.");
		}
	}
	
	public void deshabilitarMozo (int idMozo){
		Mozo mozoHab = buscarMozo(idMozo);
		if (mozoHab != null){
			mozoHab.setNoHabilitado();
			System.out.println("Mozo" +idMozo+ "Inhabilitado con exito.");
		}else{
			System.out.println("Mozo" +idMozo+ "NO Inhabilitado. Id no existente.");
		}
	}
	
	
	public void asignarMesaMozo (int mesa, int mozo){
		mesas.elementAt(mesa).setMozo(mozos.elementAt(mozo));
		mesas.elementAt(mesa).setHabilitada();
	}
	
	private Mozo buscarMozo(int id){
		int i = 0;
		while (i < mozos.size()){
			Mozo m = mozos.elementAt(i);
			if (m.getIdMozo() == id)
				return m;
			else
				i++;
		}
		System.out.println("El mozo " + id + " no existe");
		return null;	
	}
	
	private Vector<Comanda> buscarComandasMozo(Mozo mozo){
		Vector<Comanda> comandasMozo = new Vector<Comanda>();
		for (int i = 0; i<comandas.size(); i++){
			if (comandas.elementAt(i).getMozo().equals(mozo)){
				comandasMozo.add(comandas.elementAt(i));
			}
		}
		return comandasMozo;
	}
	
	
	public void modificarComisionMozo(int id, float comision){
		Mozo m = buscarMozo(id);
		if (m != null)
			m.setComision(comision);
	}
	
	
	public void modificarNombreMozo(int id, String nombre){
		Mozo m = buscarMozo(id);
		if (m != null)
			m.setNombre(nombre);
	}
	
	
	public void bajaDeMozo (int idMozo){
		Mozo garzon = buscarMozo(idMozo);
		if (garzon != null){
			mozos.remove(garzon);
			System.out.println("Mozo eliminado con exito.");
		}
	}
	
	
	public void pagarMozos(){
		int cantMozos = mozosTotales();
		//Vector <Mozo> moz = getMozos();
		for (int j=0;j<cantMozos;j++)
		{
			float totalMozo = 0;
			//Mozo mozo = restaurante.buscarMozo(j);
			Mozo mozo = mozos.elementAt(j);
			if (mozo != null){
				Vector<Comanda> comandasMozo = buscarComandasMozo(mozo);
				if (comandasMozo != null){
					for (int i=0; i<comandasMozo.size(); i++){
						totalMozo = totalMozo + comandasMozo.elementAt(i).getTotal();
					}
					totalMozo = totalMozo * (1 + mozo.getComision()); 
				}
			}
			System.out.println("Mozo: " +mozo.getNombre());
			System.out.println("A pagar: " +totalMozo);
			System.out.println(" ");
		}
	}
	
//	Metodos que operan con Mesas
//	-------------------------------------------------------------
	public int cantidadMesas (){
 		return (mesas.size());
 	}
	
	public void altaDeMesa (int numeroMesa){
		Mesa mesaNueva = buscarMesa(numeroMesa);
		if (mesaNueva == null){
			Mesa mesaNew = new Mesa (numeroMesa);
			mesas.add(mesaNew);
			System.out.println("Mesa creada con exito.");
		}else{
			System.out.println("La Mesa ya existe.");
		}
	}
	
	/*
	public void habilitarMesa (int idMesa){
		Mesa mesaHab = buscarMesa(idMesa);
		if (mesaHab != null){
			mesaHab.setHabilitada();
			System.out.println("Mesa " +idMesa+ "habilitada con exito.");
		}else{
			System.out.println("Mesa " +idMesa+ "NO habilitada Id no existente.");
		}
	}
	
	public void deshabilitarMesa (int idMesa){
		Mesa mesaHab = buscarMesa(idMesa);
		if (mesaHab != null){
			mesaHab.setNoHabilitada();
			System.out.println("Mesa" +idMesa+ "Inhabilitada con exito.");
		}else{
			System.out.println("Mesa" +idMesa+ "NO Inhabilitada. Id no existente.");
		}
	}
	*/
	
	public Mesa buscarMesa(int id){
		int i = 0;
		while (i < mesas.size()){
			Mesa m = mesas.elementAt(i);
			if (m.getNroMesa() == id)
				return m;
			else
				i++;
		}
		System.out.println("La mesa " + id + " no existe");
		return null;
	}
	
	public void abrirMesa (Mesa m){
		Comanda c = m.abrirMesa();
		comandas.add(c);	
	}
	
	
	public void agregarItemComanda(int nroMesa, int nroItemCarta, int cant){
		Mesa m = buscarMesa(nroMesa);
		if ((m != null) && (m.isOcupada())){
			ItemDeCarta itemCarta = buscarItemDeCarta(nroItemCarta);
			if ((itemCarta != null) && itemCarta.esPreparable(cant)){
				m.agregarItemComanda(cant, itemCarta);
			}else{
				System.out.println("No existe el item de carta " + nroItemCarta);
			}
		}else{
			System.out.println("No existe la mesa " + nroMesa + " o no esta ocuapada");
		}
		System.out.println("Agregado OK");
	}
	
	
	public void bajaDeMesa(int id){
		Mesa table = buscarMesa(id);
		if (table != null){
			mesas.remove(table);
			System.out.println("Mesa eliminada con exito.");
		}
	}

//	Metodos que operan con Proveedores
//	-------------------------------------------------------------
	 private Proveedor buscarProveedor (int cuit){
	 	for (int i=0; i<proveedores.size(); i++){
	 		Proveedor prov = proveedores.elementAt(i);
			if (prov.getCuit()==(cuit)){
				System.out.println("Existe el proveedor");
				return prov;
			}
		}
		System.out.println("El proveedor NO existe");
		return null;
	}

	public void altaDeProveedor (int cuit, String razonsocial, String domicilio){
		Proveedor prov = buscarProveedor(cuit);
		if (prov == null){
			prov = new Proveedor(razonsocial, domicilio, cuit);
			proveedores.add(prov);
			System.out.println("Proveedor creado con exito.");
		}
	}

	public void bajaDeProveedor (int cuit){
		Proveedor prov = buscarProveedor(cuit);
		if (prov != null){
			proveedores.remove(prov);
			System.out.println("Proveedor eliminado con exito.");
		}
	}

	public void modificarProveedor(int cuit, String razonsocial, String domicilio){
		Proveedor prov = buscarProveedor(cuit);
		if (prov != null){
			prov.setCuit(cuit);
			prov.setDomicilio(domicilio);
			prov.setRazonsocial(razonsocial);
			System.out.println("Proveedor modificado exitosamente.");
		}
	}

}