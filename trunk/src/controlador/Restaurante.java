package controlador;

import java.util.Vector;

import modelo.*;


public class Restaurante {
	static private Restaurante restaurante = null;

	private boolean mesasAsignadas;
	private boolean open;

	//	La fecha y el dia se cargan como String al inciciar el Sistema.
	//	Se leen desde la hora y fecha configurada en el sistema operativo.
	private String fecha;	//	Formato dd/mm/aaaa
	private String dia;		//	lunes - martes - miercoles - jueves - viernes - sabado - domingo
	
	private Carta cartaActiva;

	private Vector <ItemDeCarta>	itemsCarta;
	private Vector <Carta> 			cartas;
	private Vector <Mozo> 			mozos;
	private Vector <Mesa> 			mesas;
	private Vector <Comanda> 		comandas;
	private Vector <Proveedor> 		proveedores;
	private Vector <OrdenDeCompra> 	ordenesCompra;
	private Vector <Producto> 		productos;

//	Constructor de instancia Restaurante
//	-------------------------------------------------------------	
	private Restaurante (){
		itemsCarta 		= new Vector <ItemDeCarta>();
		cartas 			= new Vector <Carta>();
		mozos 			= new Vector <Mozo> ();
		mesas 			= new Vector <Mesa> ();
		comandas 		= new Vector <Comanda> ();
		proveedores 	= new Vector <Proveedor>();
		ordenesCompra 	= new Vector <OrdenDeCompra>();
		productos 		= new Vector <Producto>();
		open			= false;

/**		-------------------------------------------------------------
 **		Metodos que cargan datos - USAR EN LAS PRUEBAS Y BORRAR	!!!! 
 **		-------------------------------------------------------------
 **/
		//	Mesas 12 (10 habilitadas, 2 deshabilitadas)
		for (int i=0; i<5; i++)
			altaDeMesa(true);
		for (int i=0; i<2; i++)
			altaDeMesa(false);
		for (int i=0; i<5; i++)
			altaDeMesa(true);
		//	Mozos
		altaDeMozo("Cacho Garay", 15, true);
		altaDeMozo("Jorge Buenaventua", 20, true);
		altaDeMozo("Chichilo Viale", 9, false);
		altaDeMozo("Flaco Pailos", 12, true);

		//	Proveedores
		altaDeProveedor("99999999995", "La Vaca Loca", "Lavalle 111");
		altaDeProveedor("21636582139", "La Botilleria de Jose", "Alsina 888");
		altaDeProveedor("20123456783", "Verduleria El Choclo Feliz", "Marcelo T 231");
		Proveedor prov = buscarProveedor("99999999995");
		Proveedor prov2 = buscarProveedor("21636582139");
		Proveedor prov3 = buscarProveedor("20123456783");
		//	Productos
		altaDeProducto("lomo", 1000, 100, 5000, prov);
		altaDeProducto("pollo", 1500, 80, 2000, prov);
		altaDeProducto("papa", 800, 100, 1200, prov3);
		altaDeProducto("ravioles", 1000, 550, 1000, prov2);
		altaDeProducto("tomate", 1000, 550, 1000, prov3);		
		altaDeProducto("vino tinto", 20, 18, 8, prov2);
		altaDeProducto("gaseosa naranja", 20, 4, 8, prov2);		
		//	Items de Carta		
		altaDePlato("pollo con papas", 18);
		ItemDeCarta polloPapas = buscarItemDeCarta ("pollo con papas");
		polloPapas.agregarIngrediente(buscarProducto("pollo"), 120);
		polloPapas.agregarIngrediente(buscarProducto("papa"), 85);
		altaDePlato("ravioles con tuco", 12);
		ItemDeCarta raviolesTuco = buscarItemDeCarta ("ravioles con tuco");
		raviolesTuco.agregarIngrediente(buscarProducto("ravioles"), 230);
		raviolesTuco.agregarIngrediente(buscarProducto("tomate"), 35);
		altaDeBebida("gaseosa naranja", 8);
		ItemDeCarta gaseosa = buscarItemDeCarta ("gaseosa naranja");
		gaseosa.agregarIngrediente(buscarProducto("gaseosa naranja"), 1);
		altaDeBebida("vino tinto", 16);
		ItemDeCarta vinoT = buscarItemDeCarta ("vino tinto");
		vinoT.agregarIngrediente(buscarProducto("vino tinto"), 1);
		//	Cartas
		altaDeCarta("martes");
		Carta carta = buscarCarta("martes");
		//ltaDeCarta("lunes");
		//Carta carta = buscarCarta("lunes");
		carta.agregarItemCarta(vinoT);
		carta.agregarItemCarta(raviolesTuco);
		setCartaActiva(carta);
		
		
	}
/**				BORRAR LOS DATOS INGRESADOS ARRIBA
 **	------------------------------------------------------------	**/	

	
//	SINGLETON Restaurante getRestaurante()
//	-------------------------------------------------------------
	static public Restaurante getRestaurante(){
		if (restaurante == null){
			restaurante = new Restaurante();
		}
		return restaurante;
	}
	
//	Metodos sets y gets para los atributos de Restaurante
//	-------------------------------------------------------------	
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
	public void setMozos(Vector<Mozo> mozos) {
		this.mozos = mozos;
	}
	
	public Vector<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(Vector<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Vector<Comanda> getComandas() {
		return comandas;
	}
	public void setComandas(Vector<Comanda> comandas) {
		this.comandas = comandas;
	}

	public Vector<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(Vector<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Vector<OrdenDeCompra> getOrdenesCompra() {
		return ordenesCompra;
	}
	public void setOrdenesCompra(Vector<OrdenDeCompra> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}

	public Vector<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Vector<Producto> productos) {
		this.productos = productos;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return fecha;
	}

	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
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

	public Carta getCartaActiva() {
		return cartaActiva;
	}
	
	public void setCartaActiva(Carta cartaActiva) {
		this.cartaActiva = cartaActiva;
	}

//	Metodos de jornada (apertura y cierre)
//	-------------------------------------------------------------		
	public boolean abrirJornada(){
		if (isOpen()){
			System.out.println("El restaurant ya se encuentra abierto");
			return true;
		}else{
			if ((mozos == null) || (mesas == null)){
				System.out.println("No hay mozos para atender o mesas para servir. Crearlos!!!");
				return false;
			}else{
				asignarMesas();
				setOpen(true);
				//	Para abrir la jornada tambien hay que asignar la carta activa del dia
				setCartaActiva(buscarCarta(dia));
				System.out.println("Restaurante ABIERTO!!!");
				return true;
			}
		}
	}
	
	public boolean cerrarJornada(){
		for (int i = 0; i<mesas.size(); i++){
			if (mesas.elementAt(i).getComanda() != null){
				System.out.println("Hay mesa/s con comandas en curso. Se deben cerrar previamente.");
				return false;
			}else{
				pagarMozos();
				generarOrdenesDeCompra();
				setOpen(false);
			}
		}
		return true;
	}

/**
  * -----------------------------------------------------------------------------
  * ------------------  ABM - BUSCAR de las clases del NEGOCIO  -----------------
  * ----------------------------------------------------------------------------- 
  * 
  **/	
	
//	ABM - BUSCAR	Items De Carta (platos o bebidas)
//	-----------------------------------------------------
	private ItemDeCarta buscarItemDeCarta (String nombre){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNombre().equals(nombre)){
				System.out.println("Item de Carta existente");
				return idecarta;
			}
		}
		System.out.println("Item de Carta NO existe");
 		return null;
	}
	/*	Metodo buscar items de carta segun un nro de identificacion	- NO LO USAMOS	
 	private ItemDeCarta buscarItemDeCarta (int nro){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNroItem() == nro){
				System.out.println("item existente");
				return idecarta;
			}
		}
		System.out.println("item NO existe");
 		return null;
	}	*/	
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
			System.out.println("Item eliminado con exito.");
		}
	}

	public void modificarItemDeCarta (String nombre, float precio){
		ItemDeCarta itcar = buscarItemDeCarta(nombre);
		if (itcar != null){
			itcar.setNombre(nombre);
			itcar.setPrecio(precio);
			System.out.println("Item modificado con exito.");
		}
	}

	
//	ABM - BUSCAR	Cartas
//	-----------------------------------------------------
	private Carta buscarCarta (String dia){
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

	//	Comprueba que el dia de semana sea valido
	public boolean diaValido (String dia){
		if (dia.equalsIgnoreCase("lunes"))
			return true;
		else
			if (dia.equalsIgnoreCase("martes"))
				return true;
			else
				if (dia.equalsIgnoreCase("miercoles"))
					return true;
				else
					if (dia.equalsIgnoreCase("jueves"))
						return true;
					else
						if (dia.equalsIgnoreCase("viernes"))
							return true;
						else
							if (dia.equalsIgnoreCase("sabado"))
								return true;
							else
								if (dia.equalsIgnoreCase("domingo"))
									return true;
								else
									return false;
	}
	
	public boolean altaDeCarta (String dia){
		boolean valido = diaValido(dia);
		//	Revisa que el dia sea valido
		if (valido){
			Carta letter = buscarCarta(dia);
			//	Revisa que la carta no halla sido creada
			if (letter == null){
				letter = new Carta (dia);
				cartas.add(letter);
				System.out.println("Carta creada con exito.");
			}
		}
		return valido;
	}

	public boolean bajaDeCarta (String dia){
		boolean valido = diaValido(dia);
		//	Revisa que el dia sea valido
		if (valido){
			Carta letter = buscarCarta(dia);
			//	Revisa que la carta exista
			if (letter != null){
				cartas.remove(letter);
				System.out.println("Carta eliminada con exito.");
			}
		}
		return valido;
	}

	//	Ya se valido que la carta a modificar exista
	//	La modificacion consiste en cambiar una carta de un dia a otro.
	public void modificarCarta (String diaViejo, String diaNuevo){
		boolean validoViejo = diaValido(diaViejo);
		boolean validoNuevo = diaValido(diaNuevo);
		//	Revisa que ambos dias sean validos
		if (validoViejo && validoNuevo){
			//	Revisa que no exista una carta con el mismo nombre a asignar
			//	para que no pueda haber dos cartas del mismo dia.
			Carta letterVieja = buscarCarta(diaViejo);
			Carta letterNueva = buscarCarta(diaNuevo);
			if (letterVieja != null && letterNueva == null ){
				letterVieja.setDia(diaNuevo);
				System.out.println("Dia de Carta modificado con exito.");
			}else{
				System.out.println("La Carta No puede modificarse. Carta inexistente.");
			}
		}
	}

	//	Carga un plato o bebida en la carta
	public void cargarCarta (String nombreCarta, String nombreItem){
		Carta letter = buscarCarta(nombreCarta);
		if (letter != null){
			ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
			if (itemc != null){
				letter.agregarItemCarta(itemc);
				System.out.println("Carga de item en carta exitosa.");
			}
		}
		
	}

	//	Elimina un plato o bebida existentes de una carta
	public void descargarCarta (String nombreCarta, String nombreItem){
		Carta letter = buscarCarta(nombreCarta);
		if (letter != null){
			ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
			if (itemc == null){
				letter.eliminarItemCarta(itemc);
				System.out.println("Item eliminado de la carta con exito.");
			}
		}
	}

	
//	ABM - BUSCAR	Productos
//	-----------------------------------------------------
	private Producto buscarProducto (String nombre){
 		for (int i=0; i<productos.size(); i++){
			Producto prod = productos.elementAt(i);
			if (prod.getNombre().equals(nombre)){
				System.out.println("Producto existente");
				return prod;
			}
		}
		System.out.println("Producto NO existe");
 		return null;
	}
	
	public void altaDeProducto (String nombre, int cantidad, int pedido, int reab, Proveedor prov){
		Producto prod = buscarProducto(nombre);
		if (prod == null){
			prod = new Producto(nombre, cantidad, pedido, reab, prov);
			productos.add(prod);
			System.out.println("Producto creado con exito.");
		}
	}
	
	public void altaDeProductoFromView (String nombre, int cantidad, int pedido, int reab, String cuit){
		Proveedor proveedor = buscarProveedor(cuit);
		Producto prod = buscarProducto(nombre);
		if ((prod == null) && (proveedor != null)){
			prod = new Producto(nombre, cantidad, pedido, reab, proveedor);
			productos.add(prod);
			System.out.println("Producto creado con exito.");
		}
	}

	public void bajaDeProducto (String nombre){
		Producto prod = buscarProducto(nombre);
		if (prod != null){
			productos.remove(prod);
			System.out.println("Producto eliminado con exito.");
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
			System.out.println("Producto modificado con exito.");
		}		
	}

	//	Actualizar stock cuando ingresa mercaderia nueva
	public void ingresarMercaderia (String produc, float cantidad){
		Producto prod = buscarProducto(produc);
		if (prod != null){
			prod.setCantidad(prod.getCantidad()+cantidad);
			System.out.println("Stock de producto actualizado con exito.");
		}
	}


//	ABM - BUSCAR	Ordenes de Compra
//	-----------------------------------------------------
	private OrdenDeCompra buscarOrdenDeCompra (String cuitProv, String date){
	 	for (int i=0; i<ordenesCompra.size(); i++){
	 		OrdenDeCompra ord = ordenesCompra.elementAt(i);
	 		//	Busca la orden de compra segun el Proveedor
	 		if (ord.getCuitProveedor().equals(cuitProv)){
	 			//	Compara fechas
				if(ord.getFecha().equals(date)){
					System.out.println("Orden de compra existente");
					return ord;
				}
			}
		}
		System.out.println("La orden de compra NO existe");
		return null;
	}

	/*	Genera un vector con productos bajo punto de pedido, correspondientes
		a un mismo proveedor. El vector se utiliza en altaDeOrdenDeCompra.		*/
	public Vector<Producto> productosBajoPuntoPedido(Proveedor bajoProve){
		Vector<Producto> produc = new Vector <Producto>();
		for (int i= 0; i<productos.size(); i++){
			Producto prod = productos.elementAt(i);
			if (prod.getProveedor().equals(bajoProve)){
				if (prod.getCantidad()<=prod.getPuntoped()){
					produc.add(prod);
				}
			}
		}
		return produc;	//	Vector con los productos (de un proveedor) bajos en stock. 
	}

	/*	Genera las ordenes automaticamente para los productos
		bajos en stock. Es UNA orden por proveedor, por dia.		*/
	public int altaDeOrdenDeCompra (String cuitProv){
		Proveedor prov = buscarProveedor(cuitProv);
		OrdenDeCompra ord = buscarOrdenDeCompra(cuitProv, fecha);
		if (prov != null && ord == null){
			//	Vector generado por productosBajoPuntoPedido
			Vector<Producto> itemsApedir = productosBajoPuntoPedido(prov);
			//	Revisa que el vector de productos a pedir no esté vacío.
			if (!itemsApedir.isEmpty()){
				ord = new OrdenDeCompra(prov, fecha);
				//	Carga los items de pedido
				for (int i= 0; i<itemsApedir.size(); i++){
					Producto prod = itemsApedir.elementAt(i);
					ord.agregarItemDePedido(prod, prod.getPuntoreab());
				}
				//	Agrega la orden de compra al vector de ordenes de compra
				ordenesCompra.add(ord);
				System.out.println("Orden de compra creada y cargada con exito.");
				// Devuelve uno para contabilizar las ordenes de compra creadas.
				return 1;
			}
		}
		//	Devuelve cero si no se creo la orden de compra.
		return 0;
	}

	public void bajaDeOrdenDeCompra (String cuitProv, String date){
		OrdenDeCompra ord = buscarOrdenDeCompra(cuitProv, date);
		if (ord != null){
			ordenesCompra.remove(ord);
			System.out.println("Orden eliminada con exito.");
		}
	}

	public void modificarOrdenDeCompra(String cuitProv, String date){
		//	Valida la existencia del proveedor
		Proveedor prov = buscarProveedor(cuitProv);
		//	Valida la existencia de la orden de compra
		OrdenDeCompra ord = buscarOrdenDeCompra(cuitProv, date);
		if (prov != null && ord != null){
				ord.setCuitProveedor(cuitProv);
				ord.setFecha(date);
				System.out.println("Orden de Compra modificada exitosamente.");
		}
	}

	//	Genera todas las ordenes de compra para los productos bajos en stock
	public int generarOrdenesDeCompra(){
		int ord = 0;
		for (int i=0; i<proveedores.size(); i++){
			Proveedor prov = proveedores.elementAt(i);
			int ord1 = altaDeOrdenDeCompra (prov.getCuit());
			ord = ord + ord1;
		}
		return ord;
	}
	

	
//	ABM - BUSCAR	Mozos
//	-----------------------------------------------------
	private Mozo buscarMozo (int id){
 		for (int i=0; i<mozos.size(); i++){
			Mozo m = mozos.elementAt(i);
			if (m.getId()==id){
				System.out.println("Mozo existente");
				return m;
			}
		}
		System.out.println("Mozo NO existe");
 		return null;
	}

	public void altaDeMozo (String nombre, int comision, boolean habilitado){
		Mozo mozo = new Mozo (nombre, comision, habilitado);
		mozos.add(mozo);
		System.out.println("Mozo creado con exito.");
	}
	
	public void bajaDeMozo (int idMozo){
		Mozo garzon = buscarMozo(idMozo);
		if (garzon != null){
			mozos.remove(garzon);
			System.out.println("Mozo eliminado con exito.");
		}
	}

	public void modificarMozo(int id, String nombre, int comision, boolean habilitado){
		Mozo m = buscarMozo(id);
		if (m != null){
			m.setNombre(nombre);
			m.setComision(comision);
			m.setHabilitado(habilitado);
			System.out.println("Mozo modificado con exito.");

		}
	}
	
	//----------------------------------------------------------
	//	METODOS CON MESAS
	//----------------------------------------------------------
	public int getCantMesasHabilitadas (){
		int mesasOk = 0;
		for (int i=0; i<mesas.size(); i++){
			if (mesas.elementAt(i).isHabilitada()){
				mesasOk++;
			}
		}
		return mesasOk;
 	}
	
//	Asigna las mesas a cada mozo.
	//	Tengo que ver cuantos son los mozos habilitados.
	//	Va a determinar cuantas mesas quedan habilitadas y que mozo atiende que mesa.
	public void asignarMesas(){
		int indice=0;
		int i=0, j=0;
		
		int mozosHab = getCantMozosHabilitados();
		int mesasHab = getCantMesasHabilitadas();
		
		if (!mozos.isEmpty() && !mesas.isEmpty()){
			if (mozosHab >= mesasHab){
				while (i<mesas.size() && j<mozos.size()){
					Mesa mesa = mesas.elementAt(i);
					Mozo mozo = mozos.elementAt (j);
					if (mozo.isHabilitado() && mesa.isHabilitada()){
						mesas.elementAt(i).setMozo(mozos.elementAt(j));
						mesas.elementAt(i).setAsignada(true);
						i++;
						j++;
					}else{
						// La mesa esta habilitada pero el mozo no
						if (mesa.isHabilitada())
							j++;
						else	// La mozo esta habilitado pero la mesa no
							i++;
					}
				}
			}else{
				int mesasXmozo = mesasHab / mozosHab;
				for (i=0; i<mozos.size(); i++){
					j=0;
					Mozo mozo = mozos.elementAt (i);
					if (mozo.isHabilitado()){
						while (j<mesasXmozo){
							if (mesas.elementAt(indice).isHabilitada()){
								mesas.elementAt(indice).setMozo(mozos.elementAt(i));
								mesas.elementAt(indice).setAsignada(true);
								indice++;
								j++;
							}else
								indice++;
						}
					}else{
						continue;
					}
				}
			}
			setMesasAsignadas(true);
			System.out.println("Mesas asignadas.");
		}else{
			System.out.println("No hay mozos habilitados o mesas disponibles");
		}
	}
	
	
	//----------------------------------------------------------
	//	METODOS CON MOZOS
	//----------------------------------------------------------
	public int getCantMozosHabilitados (){
		int mozosOk = 0;
		for (int i=0; i<mozos.size(); i++){
			if (mozos.elementAt(i).isHabilitado()){
				mozosOk++;
			}
		}
		return mozosOk;
 	}
	
	/*public int mozosTotales(){
		return (mozos.size());
	}*/
	/*Mozo mozoNuevo = buscarMozo(idMozo);
		if (mozoNuevo == null){
			Mozo pibenuevo = new Mozo (nombre, idMozo, comision);
			mozos.add(pibenuevo);
			System.out.println("Mozo creado con exito.");
		}else{
			System.out.println("El id de Mozo ya existe.");
		}
	}*/
	public void habilitarMozo (int idMozo){
		Mozo mozoHab = buscarMozo(idMozo);
		if (mozoHab != null){
			mozoHab.setHabilitado(true);
			System.out.println("Mozo" +idMozo+ "habilitado con exito.");
		}else{
			System.out.println("Mozo" +idMozo+ "NO habilitado. Id no existente.");
		}
	}
	
	public void deshabilitarMozo (int idMozo){
		Mozo mozoHab = buscarMozo(idMozo);
		if (mozoHab != null){
			mozoHab.setHabilitado(false);
			System.out.println("Mozo" +idMozo+ "Inhabilitado con exito.");
		}else{
			System.out.println("Mozo" +idMozo+ "NO Inhabilitado. Id no existente.");
		}
	}
	
	/*public void asignarMesaMozo (int mesa, int mozo){
		mesas.elementAt(mesa).setMozo(mozos.elementAt(mozo));
		mesas.elementAt(mesa).setHabilitada();
	}*/

	
	/*	private Mozo buscarMozo(int id){
		int i = 0;
		while (i < mozos.size()){
			Mozo m = mozos.elementAt(i);
			if (m.getId() == id)
				return m;
			else
				i++;
		}
		System.out.println("El mozo " + id + " no existe");
		return null;	
	}	*/	
	
	private Vector<Comanda> buscarComandasMozo(Mozo mozo){
		Vector<Comanda> comandasMozo = new Vector<Comanda>();
		for (int i = 0; i<comandas.size(); i++){
			if (comandas.elementAt(i).getMozo().equals(mozo)){
				comandasMozo.add(comandas.elementAt(i));
			}
		}
		return comandasMozo;
	}
	/*public void modificarComisionMozo(int id, int comision){
		Mozo m = buscarMozo(id);
		if (m != null)
			m.setComision(comision);
	}
	
	public void modificarNombreMozo(int id, String nombre){
		Mozo m = buscarMozo(id);
		if (m != null)
			m.setNombre(nombre);
	}*/
	public void pagarMozos(){
		float totalMozo;
		int cantMozos = mozos.size();
		//Vector <Mozo> moz = getMozos();
		for (int j=0; j<cantMozos; j++){
			totalMozo = 0;
			//Mozo mozo = restaurante.buscarMozo(j);
			Mozo mozo = mozos.elementAt(j);
			if (mozo != null){
				Vector<Comanda> comandasMozo = buscarComandasMozo(mozo);
				if (comandasMozo != null){
					for (int i=0; i<comandasMozo.size(); i++){
						totalMozo = totalMozo + comandasMozo.elementAt(i).getTotal();
					}
					totalMozo = (totalMozo * mozo.getComision()) / 100; 
				}
			}
			System.out.println("Mozo: " + mozo.getNombre() + " $ " + Float.toString(totalMozo));		
		}
	}
	
	
//	ABM - BUSCAR	Mesas
//	-----------------------------------------------------
	private Mesa buscarMesa(int id){
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

	public void altaDeMesa (boolean habilitada){
		Mesa mesaNew = new Mesa (habilitada);
		mesas.add(mesaNew);
		System.out.println("Mesa creada con exito.");
	}

	public void bajaDeMesa(int id){
		Mesa table = buscarMesa(id);
		if (table != null){
			mesas.remove(table);
			System.out.println("Mesa eliminada con exito.");
		}
	}

	public int cantidadMesas (){
 		return (mesas.size());
 	}
	/*public void altaDeMesa (int numeroMesa){
		Mesa mesaNueva = buscarMesa(numeroMesa);
		if (mesaNueva == null){
			Mesa mesaNew = new Mesa (numeroMesa);
			mesas.add(mesaNew);
			System.out.println("Mesa creada con exito.");
		}else{
			System.out.println("La Mesa ya existe.");
		}
	}
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
	public void abrirMesa (Mesa m){
		Comanda c = m.abrirMesa();
		comandas.add(c);
	}
	
	public void agregarItemComanda(int nroMesa, String nombreItemCarta, int cant){
		Mesa m = buscarMesa(nroMesa);
		if (m != null){
			if (! m.isOcupada())
				abrirMesa(m);
			ItemDeCarta itemCarta = cartaActiva.buscarItemDeCarta(nombreItemCarta);
			if ((itemCarta != null) && itemCarta.esPreparable(cant)){
				m.agregarItemComanda(cant, itemCarta);
			}else{
				System.out.println("En la carta del dia no existe el item o no faltan materias primas." + nombreItemCarta);
			}
		}else{
			System.out.println("No existe la mesa " + nroMesa + " o no esta ocupada");
		}
		System.out.println("Agregado OK");
	}

	
//	ABM - BUSCAR	Proveedores
//	-----------------------------------------------------
	 public Proveedor buscarProveedor (String cuit){
	 	for (int i=0; i<proveedores.size(); i++){
	 		Proveedor prov = proveedores.elementAt(i);
			if (prov.getCuit().equals(cuit)){
				System.out.println("Proveedor existente");
				return prov;
			}
		}
		System.out.println("El proveedor NO existe");
		return null;
	}

	public void altaDeProveedor (String cuit, String razonsocial, String domicilio){
		Proveedor prov = buscarProveedor(cuit);
		if (prov == null){
			prov = new Proveedor(cuit, razonsocial, domicilio);
			proveedores.add(prov);
			System.out.println("Proveedor creado con exito.");
		}
	}

	public void bajaDeProveedor (String cuit){
		Proveedor prov = buscarProveedor(cuit);
		if (prov != null){
			proveedores.remove(prov);
			System.out.println("Proveedor eliminado con exito.");
		}
	}

	public boolean modificarProveedor(String cuit, String razonsocial, String domicilio){
		Proveedor prov = buscarProveedor(cuit);
		if (prov != null){
			prov.setCuit(cuit);
			prov.setDomicilio(domicilio);
			prov.setRazonsocial(razonsocial);
			System.out.println("Proveedor modificado exitosamente.");
			return true;
		}
		return false;
	}

	
//	Metodos que operan con Vectores View
//	-----------------------------------------------------

	//	CARTAS
	public CartaView getCartaView(String dia){
		Carta car = buscarCarta(dia);
		if (car!=null)
			return car.getCartaView();
		return null;
	}
	
	public Vector<CartaView> getCartasView(){
		Vector<CartaView> cv = new Vector<CartaView>();
		for (int i=0; i<cartas.size(); i++){
			cv.add(cartas.elementAt(i).getCartaView());
		}	
		return cv;
	}
	
	// ITEMS DE CARTA ACTIVA
	public Vector<ItemDeCartaView> getItemsDeCartaView(){
		Vector<ItemDeCartaView> icv = new Vector<ItemDeCartaView>();
		for (int i=0; i<cartaActiva.getItemsCarta().size(); i++){
			icv.add(cartaActiva.getItemsCarta().elementAt(i).getItemDeCartaView());
		}	
		return icv;
	}
	
	//	PRODUCTOS
	public Vector<ProductoView> getProductosView(){
		Vector<ProductoView> mv = new Vector<ProductoView>();
		for (int i= 0; i < productos.size(); i++){
			mv.add(productos.elementAt(i).getProductoView());
		}	
		return mv;
	}
	// Falta mover
	public Vector getProductosViewVector(){ 
		Vector mv = new Vector();
		for (int i= 0; i < productos.size(); i++){
			mv.add(productos.elementAt(i).getProductoView().toVector());
		}	
		return mv;
	}
	
	//	PROVEEDORES
	public Vector<ProveedorView> getProveedoresView(){ 
		Vector<ProveedorView> mv = new Vector<ProveedorView>();
		for (int i= 0; i < proveedores.size(); i++){
			mv.add(proveedores.elementAt(i).getProveedorView());
		}
		return mv;
	}

	//	MOZOS		
 	public Vector<MozoView> getMozosView(){ 
		Vector<MozoView> mv = new Vector<MozoView>();
		for (int i= 0; i < mozos.size(); i++)
		{
			mv.add(mozos.elementAt(i).getMozoView());
		}
		return mv;
	}

 	//	MESAS
 	public Vector<MesaView> getMesasView(){ 
		Vector<MesaView> mv = new Vector<MesaView>();
		for (int i= 0; i < mesas.size(); i++){
			mv.add(mesas.elementAt(i).getMesaView());
		}
		return mv;
 	}
 	
 	public void cerrarMesa (int nroMesa){
 		Mesa mesa = buscarMesa(nroMesa);
 		mesa.cerrarMesa();
 	}
 	
 	public float getTotalComanda(int nroMesa){
 		float totalMesa = 0;
 		Mesa m = buscarMesa(nroMesa);
 		if ((m != null) && (m.isOcupada())){
 			totalMesa = m.getTotal();
 		}else
 			System.out.println("Si llegamos aca estamos en problemas");
 		return totalMesa;
 	}
 		
}
