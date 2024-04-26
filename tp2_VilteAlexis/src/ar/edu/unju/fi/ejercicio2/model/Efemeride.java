package ar.edu.unju.fi.ejercicio2.model;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
public class Efemeride {
	private int codigo;
    private Mes mes;
    private String dia;
    private String detalle;
    public Efemeride(int codigo, Mes mes, String dia, String detalle) {
        this.codigo = codigo;
        this.mes = mes;
        this.dia = dia;
        this.detalle = detalle;
    }
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Mes getMes() {
		return mes;
	}
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	
}
