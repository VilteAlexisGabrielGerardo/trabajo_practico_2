package ar.edu.unju.fi.ejercicio2.main;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        ArrayList<Efemeride> efemerides = new ArrayList<>();
		        int opcion;
		        do {
		            Menu();
		            opcion = scanner.nextInt();
		            switch (opcion) {
		                case 1:
		                    crearEfemeride(scanner, efemerides);
		                    break;
		                case 2:
		                    mostrarEfemerides(efemerides);
		                    break;
		                case 3:
		                    eliminarEfemeride(scanner, efemerides);
		                    break;
		                case 4:
		                    modificarEfemeride(scanner, efemerides);
		                    break;
		                case 5:
		                    System.out.println("Un gusto, gracias por elegirnos");
		                    break;
		                default:
		                    System.out.println("Opción inválida");
		            }
		        } while (opcion != 5);
		        scanner.close();
		    }
			private static void Menu() {
				 System.out.println("Menú de acciones:");
		            System.out.println("1 - Crear efeméride");
		            System.out.println("2 - Mostrar efemérides");
		            System.out.println("3 - Eliminar efeméride");
		            System.out.println("4 - Modificar efeméride");
		            System.out.println("5 - Salir");
		            System.out.print("Seleccione una opción: ");
			}
			//Se crea efemerides con arraylist, y el uso de enum para los meses, se pide por teclado el ingreso de los datos
		    private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {;
		    System.out.print("Codigo que desee: ");
		    int codigo = scanner.nextInt();
		    System.out.print("Mes entre (1-12): ");
		    int mesIndex = scanner.nextInt();
		    while (mesIndex < 1 || mesIndex > 12) {
		        System.out.println("Mes invalido. Ingrese un número entre 1 y 12.");
		        System.out.print("Mes (1-12): ");
		        mesIndex = scanner.nextInt();
		    }
		    Mes mes = Mes.values()[mesIndex - 1];    
		    System.out.print("Dia(NOMBRE): ");
		    String dia = scanner.next().toUpperCase();
		    while (!Arrays.asList("LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO").contains(dia)) {
		        System.out.println("Dia invalido");
		        System.out.print("Dia: ");
		        dia = scanner.next().toUpperCase();
		    }
		    System.out.print("Detalle: ");
		    String detalle = scanner.next();
		    scanner.nextLine();
		    Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
		    efemerides.add(efemeride);
		    System.out.println("Efemeride creada correctamente");
		    }
		    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
		        System.out.println("Efemerides:");
		        for (Efemeride efemeride : efemerides) {
		            System.out.println("Codigo: " + efemeride.getCodigo());
		            System.out.println("Mes: " + efemeride.getMes());
		            System.out.println("Dia: " + efemeride.getDia());
		            System.out.println("Detalle: " + efemeride.getDetalle());
		        }
		    }
		    //Elimina la arraylist deseada por el usuario
		    private static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
		    	System.out.println("Eliminar Efemeride:");
		        System.out.println("Lista de efemerides:");
		        for (Efemeride efemeride : efemerides) {
		            System.out.println("Codigo: " + efemeride.getCodigo() + ", Mes: " + efemeride.getMes() + ", Dia: " + efemeride.getDia());
		        }
		        System.out.print("Ingrese el codigo que desea eliminar: ");
		        int codigoEliminar = scanner.nextInt();
		        Efemeride efemerideEliminar = null;
		        for (Efemeride efemeride : efemerides) {
		            if (efemeride.getCodigo() == codigoEliminar) {
		                efemerideEliminar = efemeride;
		                break;
		            }
		        }
		        if (efemerideEliminar != null) {
		            efemerides.remove(efemerideEliminar);
		            System.out.println("Efemeride eliminada");
		        } else {
		            System.out.println("No se encontro ninguna efemeride");
		        }
		    }	
		    //Modifica la efemeride que desee el usuario, asingandole un nuevo dia, nuevo mes y nuevo detalles
		    private static void modificarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
		    	 System.out.println("Modificar Efemeride:");
		    	    System.out.println("Lista de efemerides:");
		    	    for (Efemeride efemeride : efemerides) {
		    	        System.out.println("Código: " + efemeride.getCodigo() + ", Mes: " + efemeride.getMes() + ", Día: " + efemeride.getDia());
		    	    }
		    	    System.out.print("Ingrese el código de la efemeride que desea modificar: ");
		    	    int codigoModificar = scanner.nextInt();
		    	    Efemeride efemerideModificar = null;
		    	    for (Efemeride efemeride : efemerides) {
		    	        if (efemeride.getCodigo() == codigoModificar) {
		    	            efemerideModificar = efemeride;
		    	            break;
		    	        }
		    	    }
		    	    if (efemerideModificar != null) {
		    	        System.out.println("Ingrese los nuevos datos:");
		    	        System.out.print("Nuevo mes (1-12): ");
		    	        int nuevoMesIndex = scanner.nextInt();
		    	        while (nuevoMesIndex < 1 || nuevoMesIndex > 12) {
		    	            System.out.println("Mes inválido. Ingrese un número entre 1 y 12.");
		    	            System.out.print("Nuevo mes (1-12): ");
		    	            nuevoMesIndex = scanner.nextInt();
		    	        }
		    	        Mes nuevoMes = Mes.values()[nuevoMesIndex - 1];
		    	        System.out.print("Nuevo dia: ");
		    	        String nuevoDia = scanner.nextLine();
		    	        scanner.nextLine(); 
		    	        System.out.print("Nuevo detalle: ");
		    	        String nuevoDetalle = scanner.nextLine();
		    	        efemerideModificar.setMes(nuevoMes);
		    	        efemerideModificar.setDia(nuevoDia);
		    	        efemerideModificar.setDetalle(nuevoDetalle);
		    	        System.out.println("Efemeride modificada");
		    	    } else {
		    	        System.out.println("No se encontro ninguna efemeride con el código ingresado");
		    	    }
		    }
	}