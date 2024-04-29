package ar.edu.unju.fi.ejercicio3.main;
import ar.edu.unju.fi.ejercicio3.constantes.Provincia;
public class Main {
	public static void main(String[] args) {
		        Provincia[] provincias = Provincia.values();
		        for (Provincia provincia : provincias) {
		            System.out.println("Nombre de la provincia: " + provincia);
		            System.out.println("Cantidad de población de la provincia: " + provincia.getCantidadPoblacion());
		            System.out.println("Superficie de la provincia: " + provincia.getSuperficie());
		            System.out.println("Densidad poblacional de la provincia: " + provincia.calcularDensidadPoblacional());
		            System.out.println();
		        }
	}
}
