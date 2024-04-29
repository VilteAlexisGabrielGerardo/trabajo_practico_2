package ar.edu.unju.fi.ejercicio4.main;
import ar.edu.unju.fi.ejercicio4.model.Jugador;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Main {
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        byte opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextByte();
            scanner.nextLine();
            try {
                switch (opcion) {
                    case 1:
                        altaJugador();
                        break;
                    case 2:
                        mostrarTodosJugadores();
                        break;
                    case 3:
                        modificarPosicionJugador();
                        break;
                    case 4:
                        eliminarJugador();
                        break;
                    case 5:
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Se ejecutó correctamente la opción elegida");
            }
        } while (opcion != 5);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("***** Menú *****");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar todos los jugadores");
        System.out.println("3 - Modificar la posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.println("----------------");
        System.out.print("Seleccione una opción: ");
    }

    // Aca se da el alta del jugador utilizando los enum seleccionados de posiciones
    private static void altaJugador() {
        System.out.println("Ingrese los datos del jugador:");
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del jugador: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        System.out.print("Nacionalidad del jugador: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Estatura: ");
        double estatura = scanner.nextDouble();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
        String posicionStr = scanner.nextLine();
        Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());
        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
    }

    private static void mostrarTodosJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }
    //Modificamos la posicion utilizando enums
    private static void modificarPosicionJugador() {
        System.out.println("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido del jugador: ");
        String apellido = scanner.nextLine();
        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                encontrado = true;
                System.out.print("Nueva posicion (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
                String nuevaPosicionStr = scanner.nextLine();
                Posicion nuevaPosicion = Posicion.valueOf(nuevaPosicionStr.toUpperCase());
                jugador.setPosicion(nuevaPosicion);
                System.out.println("Se ha modificado correctamente");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado");
        }
    }
    // Eliminacion del jugador usando iterator
    private static void eliminarJugador() {
        System.out.println("Nombre del jugador a eliminar: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido del jugador a eliminar: ");
        String apellido = scanner.nextLine();
        boolean encontrado = false;
        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                encontrado = true;
                iterator.remove();
                System.out.println("Jugador eliminado correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado");
        }
    }
}