package ar.edu.unju.fi.ejercicio7.main;
import ar.edu.unju.fi.ejercicio7.model.Producto2;
import ar.edu.unju.fi.ejercicio7.interfaces.funcionales.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        ArrayList<Producto2> productos = new ArrayList<>();
		        precargarProductos(productos);
		        int opcion;
		        do {
		            mostrarMenu();
		            opcion = scanner.nextInt();
		            scanner.nextLine();
		            switch (opcion) {
		                case 1:
		                    mostrarProductos(productos);
		                    break;
		                case 2:
		                    mostrarProductosSinStock(productos);
		                    break;
		                case 3:
		                    incrementarPrecios(productos);
		                    break;
		                case 4:
		                	mostrarProductosElectrohogar(productos);
		                    break;
		                case 5:
		                    ordenarProductosPorPrecioDescendente(productos);
		                    break;
		                case 6:
		                	mostrarNombresEnMayusculas(productos);
		                    break;
		                case 7:
		                    System.out.println("Saliendo del programa...");
		                    break;
		                default:
		                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
		            }
		        } while (opcion != 7);

		        scanner.close();
		    }

	private static void precargarProductos( ArrayList<Producto2> productos) {
    	if(productos.isEmpty()) {
    		productos.add(new Producto2("001", "Celular", 400.0, Producto2.OrigenFabricacion.ARGENTINA, Producto2.Categoria.TELEFONIA, true));
            productos.add(new Producto2("002", "Computadora", 700.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.INFORMATICA, true));
            productos.add(new Producto2("003", "Licuadora", 100.0, Producto2.OrigenFabricacion.URUGUAY, Producto2.Categoria.ELECTROHOGAR, false));
            productos.add(new Producto2("004", "Televisor", 200.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.ELECTROHOGAR, true));
            productos.add(new Producto2("005", "Destornillador", 50.0, Producto2.OrigenFabricacion.ARGENTINA, Producto2.Categoria.HERRAMIENTAS, true));
            productos.add(new Producto2("006", "Lavarropa", 300.0, Producto2.OrigenFabricacion.BRASIL, Producto2.Categoria.ELECTROHOGAR, false));
            productos.add(new Producto2("007", "Tablet", 150.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.TELEFONIA, true));
            productos.add(new Producto2("008", "Smartwatch", 100.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.INFORMATICA, false));
            productos.add(new Producto2("009", "Mouse", 20.0, Producto2.OrigenFabricacion.URUGUAY, Producto2.Categoria.INFORMATICA, true));
            productos.add(new Producto2("010", "Teclado", 25.0, Producto2.OrigenFabricacion.ARGENTINA, Producto2.Categoria.INFORMATICA, false));
            productos.add(new Producto2("011", "Monitor", 40.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.INFORMATICA, true));
            productos.add(new Producto2("012", "Tornillo", 3.0, Producto2.OrigenFabricacion.ARGENTINA, Producto2.Categoria.HERRAMIENTAS, true));
            productos.add(new Producto2("013", "Heladera", 900.0, Producto2.OrigenFabricacion.ARGENTINA, Producto2.Categoria.ELECTROHOGAR, true));
            productos.add(new Producto2("014", "Parlante", 90.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.INFORMATICA, false));
            productos.add(new Producto2("015", "Auriculares", 60.0, Producto2.OrigenFabricacion.CHINA, Producto2.Categoria.INFORMATICA, false));
    	}
	}
		    private static void mostrarMenu() {
		        System.out.println("Menú de opciones:");
		        System.out.println("1-Mostrar productos");
		        System.out.println("2-Mostrar los productos faltantes");
		        System.out.println("3-Incrementar los precios de los productos en un 20%");
		        System.out.println("4-Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta. ");
		        System.out.println("5-Ordenar los productos por precio de forma descendente");
		        System.out.println("6-Mostrar los productos con los nombres en mayúsculas");
		        System.out.println("7-Salida");
		        System.out.print("Ingrese una opcion por favor:");
		    }
			private static void mostrarProductos(ArrayList<Producto2> productos) {
			    System.out.println("Productos: ");
			    Consumer<Producto2> activosConsumer = p -> {
			        if (p.estado()) {
			            System.out.println(p);
			        }
			    };
			    productos.forEach(activosConsumer::accept);
			}
			private static void mostrarProductosSinStock(ArrayList<Producto2> productos) {
		        System.out.println("Productos que no tienen stock: ");
		        Predicate<Producto2> inactivosPredicate = producto -> !producto.estado();
		        productos.stream()
		                .filter(inactivosPredicate)
		                .forEach(System.out::println);
		    }
			 private static ArrayList<Producto2> incrementarPrecios(ArrayList<Producto2> productos) {
			        System.out.println("Se incrementa los productos en un 20%");
			        Function<Producto2, Producto2> incrementarPrecioFunction = producto -> {
			            double precioIncrementado = producto.getPrecioUnitario() * 1.20;
			            producto.setPrecioUnitario(precioIncrementado);
			            return producto;
			        };
			  return productos.stream()
			                        .map(incrementarPrecioFunction)
			                        .collect(Collectors.toCollection(ArrayList::new));
			    }
			   private static void mostrarProductosElectrohogar(ArrayList<Producto2> productos) {
			        System.out.println("Productos de electrohogar que tienen stock:");
			        Predicate<Producto2> electrohogarDisponible = producto ->
			                producto.getCategoria() == Producto2.Categoria.ELECTROHOGAR && producto.estado();
			        productos.stream()
			                .filter(electrohogarDisponible)
			                .forEach(System.out::println);
			    }
			   private static void ordenarProductosPorPrecioDescendente(List<Producto2> productos) {
			        System.out.println("Productos ordenados en forma descendente");
			        productos.sort(Comparator.comparing(Producto2::getPrecioUnitario).reversed());
			        productos.forEach(System.out::println);
			    }
			    private static void mostrarNombresEnMayusculas(ArrayList<Producto2> productos) {
			        System.out.println("Nombre en mayusucula de todos los productos ingresados:");
			        Function<Producto2, String> toUpperCase = p -> p.getDescripcion().toUpperCase();
			        productos.stream()
			                .map(toUpperCase)
			                .forEach(System.out::println);
			    }
		}