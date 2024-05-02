package ar.edu.unju.fi.ejercicio5.main;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.Producto1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
		public class Main {
		    private static ArrayList<Producto1> productos = new ArrayList<>();
		    private static Scanner scanner = new Scanner(System.in);
		    public static void main(String[] args) {
		    	byte opcion;
		    	precargarProductos(productos);
		        do {
		            mostrarMenu();
		            try {
		                opcion = scanner.nextByte();
		                scanner.nextLine(); 
		                switch (opcion) {
		                    case 1:
		                        mostrarProductos();
		                        break;
		                    case 2:
		                        realizarCompra();
		                        break;
		                    case 3:
		                        System.out.println("Muchas gracias por elegirnos");
		                        break;
		                    default:
		                        System.out.println("Opcion incorrecta");
		                }
		            } catch (InputMismatchException e) {
		                System.out.println("Debe ingresar un numero");
		                scanner.nextLine();
		                opcion = 0;
		            }
		        } while (opcion != 3);
		        scanner.close();
		    }
		    private static void mostrarMenu() {
		        System.out.println("++++++Menú+++++++");
		        System.out.println("1-Mostrar productos");
		        System.out.println("2-Realizar compra");
		        System.out.println("3-Salir");
		        System.out.println("++++++++++++++++++");
		        System.out.print("Seleccione una opcion: ");
		    }
		    //la precarga de productos se hace reciclando el codigo del ejercicio 1 y agregando valores
		    private static void precargarProductos( ArrayList<Producto1> productos) {
		    	if(productos.isEmpty()) {
		    		productos.add(new Producto1("001", "Celular", 400.0, Producto1.OrigenFabricacion.ARGENTINA, Producto1.Categoria.TELEFONIA, true));
		            productos.add(new Producto1("002", "Computadora", 700.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.INFORMATICA, true));
		            productos.add(new Producto1("003", "Licuadora", 100.0, Producto1.OrigenFabricacion.URUGUAY, Producto1.Categoria.ELECTROHOGAR, false));
		            productos.add(new Producto1("004", "Televisor", 200.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.ELECTROHOGAR, true));
		            productos.add(new Producto1("005", "Destornillador", 50.0, Producto1.OrigenFabricacion.ARGENTINA, Producto1.Categoria.HERRAMIENTAS, true));
		            productos.add(new Producto1("006", "Lavarropa", 300.0, Producto1.OrigenFabricacion.BRASIL, Producto1.Categoria.ELECTROHOGAR, false));
		            productos.add(new Producto1("007", "Tablet", 150.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.TELEFONIA, true));
		            productos.add(new Producto1("008", "Smartwatch", 100.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.INFORMATICA, false));
		            productos.add(new Producto1("009", "Mouse", 20.0, Producto1.OrigenFabricacion.URUGUAY, Producto1.Categoria.INFORMATICA, true));
		            productos.add(new Producto1("010", "Teclado", 25.0, Producto1.OrigenFabricacion.ARGENTINA, Producto1.Categoria.INFORMATICA, false));
		            productos.add(new Producto1("011", "Monitor", 40.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.INFORMATICA, true));
		            productos.add(new Producto1("012", "Tornillo", 3.0, Producto1.OrigenFabricacion.ARGENTINA, Producto1.Categoria.HERRAMIENTAS, true));
		            productos.add(new Producto1("013", "Heladera", 900.0, Producto1.OrigenFabricacion.ARGENTINA, Producto1.Categoria.ELECTROHOGAR, true));
		            productos.add(new Producto1("014", "Parlante", 90.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.INFORMATICA, false));
		            productos.add(new Producto1("015", "Auriculares", 60.0, Producto1.OrigenFabricacion.CHINA, Producto1.Categoria.INFORMATICA, false));
		    	}
		    }
		    private static void mostrarProductos() {
		    	if(productos.isEmpty()) {
		            System.out.println("No hay productos disponibles en este momento");
		        } else {
		            System.out.println("Lista de productos: ");
		            for (Producto1 producto : productos) {
		                System.out.println("Codigo: " + producto.getCodigo());
		                System.out.println("Nombre del producto: " + producto.getDescripcion());
		                System.out.println("Precio por unidad:$" + producto.getPrecioUnitario());
		                System.out.println("Origen de Fabricacion: " + producto.getOrigenFabricacion());
		                System.out.println("Categoria: " + producto.getCategoria());
		                System.out.println("Stock : " + (producto.estado() ? "Disponible" : "No disponible"));
		                System.out.println("------------------------");
		            }
		    }
		    	}
		    //Se realiza la opcion 3 que es de comprar el producto, agregandolos por codigo y luego sumando el total
		    //Dentro del mismo metodo realizo un switch para pedir al usuario si pagan con tarjeta o efectivo.
		    private static void realizarCompra() {
		        ArrayList<Producto1> productosSeleccionados = new ArrayList<>();
		        System.out.println("Ingrese el codigo de los productos que desee comprar(0 para salir):");
		        String codigoProducto;
		        do {
		            System.out.print("Codigo : ");
		            codigoProducto = scanner.nextLine();
		            Producto1 productoSeleccionado = null;
		            for (Producto1 producto : productos) {
		                if (producto.getCodigo().equals(codigoProducto)) {
		                    productoSeleccionado = producto;
		                    break;
		                }
		            }

		            if (productoSeleccionado != null && productoSeleccionado.estado()) {
		                productosSeleccionados.add(productoSeleccionado);
		                System.out.println("El producto fue agregado a su carrito");
		            } else if (productoSeleccionado == null) {
		                System.out.println("Codigo de producto no existente");
		            } else {
		                System.out.println("Producto no disponible");
		            }
		        } while (!codigoProducto.equals("0"));
		        System.out.println("Productos adquiridos");
		        double totalCompra = 0.0;
		        for (Producto1 producto : productosSeleccionados) {
		            System.out.println(producto.getCodigo() + " - " + producto.getDescripcion() + " - Precio: " + producto.getPrecioUnitario());
		            totalCompra += producto.getPrecioUnitario();
		        }
		        System.out.println("Total de la compra: " + totalCompra);
		        System.out.println("Con que metodo desea pagar?");
		        System.out.println("1-Pago en efectivo");
		        System.out.println("2-Pago con tarjeta");
		        int opcionPago = scanner.nextInt();
		        switch (opcionPago) {
		        case 1:
		            Pago pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
		            pagoEfectivo.realizarPago(totalCompra); 
		            pagoEfectivo.imprimirRecibo(); 
		            break;
		        case 2:
		            System.out.print("Ingrese el número de tarjeta: ");
		            String numeroTarjeta = scanner.next();
		            Pago pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), totalCompra);
		            pagoTarjeta.realizarPago(totalCompra); 
		            pagoTarjeta.imprimirRecibo(); 
		            break;
		            }
		    }
	}