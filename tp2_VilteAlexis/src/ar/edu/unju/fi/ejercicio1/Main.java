package ar.edu.unju.fi.ejercicio1;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Main {
	public static void main(String[] args) {	
		        Scanner scanner = new Scanner(System.in);
		        ArrayList<Producto> listaProductos = new ArrayList<>();
		        int opcion = 0; 
		        try {
		        do {
		        		mostrarmenu();	        		
		        			opcion = scanner.nextInt();
			                scanner.nextLine(); 
		            switch (opcion) {
		                case 1:
		                    crearProducto(scanner, listaProductos);
		                    break;
		                case 2:
		                    mostrarProductos(listaProductos);
		                    break;
		                case 3:
		                    modificarProducto(scanner, listaProductos);
		                    break;
		                case 4:
		                    System.out.println("Mucho gusto, hasta la proxima");
		                    break;
		                default:
		                    System.out.println("Ingrese una opcion comprendida entre 1 y 4");
		                    }
		        } while (opcion != 4);
		        }catch (InputMismatchException e) {
		            System.out.println("Debe tipear un numero");
		        } finally {
		            scanner.close();
		        }
	}
			private static void mostrarmenu() {
	            System.out.println("Menu de opciones:");
	            System.out.println("1 - Crear Producto");
	            System.out.println("2 - Mostrar productos");
	            System.out.println("3 - Modificar producto");
	            System.out.println("4 - Salir");
	            System.out.print("Ingrese la opcion que desee: ");
			}
		    // Creacion de un nuevo producto, el cual el usuario desee, con origen y categoria hechos por enum.
		    private static void crearProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
		        System.out.println("**************************:");
		        System.out.print("Codigo: ");
		        String codigo = scanner.next();
		        System.out.print("Descripcion: ");
		        String descripcion = scanner.next();
		        System.out.print("Precio Unitario: ");
		        double precioUnitario = scanner.nextDouble();
		        System.out.println("\n--- Origen de Fabricacion ---");
		        for (int i = 0; i < OrigenFabricacion.values().length; i++) {
		            System.out.println((i + 1) + " - " + OrigenFabricacion.values()[i]);
		        }
		        System.out.print("Elija una opcion: ");
		        int opcionOrigen = scanner.nextInt();
		        OrigenFabricacion origenFabricacion = OrigenFabricacion.values()[opcionOrigen - 1];
		        System.out.println("\n--- Categoria ---");
		        for (int i = 0; i < Categoria.values().length; i++) {
		            System.out.println((i + 1) + " - " + Categoria.values()[i]);
		        }
		        System.out.print("Elija una opción: ");
		        int opcionCategoria = scanner.nextInt();
		        Categoria categoria = Categoria.values()[opcionCategoria - 1];
		        Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
		        listaProductos.add(producto);
		        System.out.println("Producto creado correctamente.");
		    }
		    // Muestra de todos los productos ingresados por el usuario
		    private static void mostrarProductos(ArrayList<Producto> listaProductos) {
		        System.out.println("Productos:");
		        for (Producto producto : listaProductos) {
		            System.out.println("Codigo: " + producto.getCodigo());
		            System.out.println("Descripcion: " + producto.getDescripcion());
		            System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
		            System.out.println("Origen de Fabricacion: " + producto.getOrigenFabricacion());
		            System.out.println("Categoria: " + producto.getCategoria());
		        	}
		    }
		    // Modificacion del producto que desee el usuario
		    private static void modificarProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
		        System.out.println("Modificar Producto:");
		        System.out.println("Lista:");
		        for (int i = 0; i < listaProductos.size(); i++) {
		            System.out.println((i + 1) + " - " + listaProductos.get(i).getDescripcion());
		        }
		        System.out.print("Seleccione el número del producto: ");
		        int opcionProducto = scanner.nextInt();
		        Producto producto = listaProductos.get(opcionProducto - 1);
		        System.out.println("¿Qué desea modificar?");
		        System.out.println("1 - Descripcion");
		        System.out.println("2 - Precio Unitario");
		        System.out.println("3 - Origen de Fabricacion");
		        System.out.println("4 - Categoria");
		        System.out.println("5 - Volver al menu principal");
		        System.out.print("Seleccione una opción: ");
		        int opcionModificacion = scanner.nextInt();
		        switch (opcionModificacion) {
		            case 1:
		                System.out.print("Nueva descripción: ");
		                String nuevaDescripcion = scanner.next();
		                producto.setDescripcion(nuevaDescripcion);
		                System.out.println("Descripcion modificada");
		                break;
		            case 2:
		                System.out.print("Nuevo precio unitario: ");
		                double nuevoPrecioUnitario = scanner.nextDouble();
		                producto.setPrecioUnitario(nuevoPrecioUnitario);
		                System.out.println("Precio unitario modificado");
		                break;
		            case 3:
		                System.out.println("--- Origen de Fabricacion ---");
		                for (int i = 0; i < Producto.OrigenFabricacion.values().length; i++) {
		                    System.out.println((i + 1) + " - " + Producto.OrigenFabricacion.values()[i]);
		                }
		                System.out.print("Seleccione una opcion: ");
		                int opcionOrigen = scanner.nextInt();
		                Producto.OrigenFabricacion nuevoOrigen = Producto.OrigenFabricacion.values()[opcionOrigen - 1];
		                producto.setOrigenFabricacion(nuevoOrigen);
		                System.out.println("Origen de fabricación modificado");
		                break;
		            case 4:
		                System.out.println("--- Categoria ---");
		                for (int i = 0; i < Producto.Categoria.values().length; i++) {
		                    System.out.println((i + 1) + " - " + Producto.Categoria.values()[i]);
		                }
		                System.out.print("Seleccione una opcion: ");
		                int opcionCategoria = scanner.nextInt();
		                Producto.Categoria nuevaCategoria = Producto.Categoria.values()[opcionCategoria - 1];
		                producto.setCategoria(nuevaCategoria);
		                System.out.println("Categoria modificada");
		                break;
		            case 5:
		                System.out.println("Ingresando al menu nuevamente");
		                break;
		            default:
		                System.out.println("La opcion no es valida");
		        }
		    }
		}

