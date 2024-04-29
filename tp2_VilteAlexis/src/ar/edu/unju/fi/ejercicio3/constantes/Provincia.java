package ar.edu.unju.fi.ejercicio3.constantes;
	public enum Provincia {
	    JUJUY(811000, 53200),
	    SALTA(1300000, 155488),
	    TUCUMAN(1593000, 222350),
	    CATAMARCA(368000, 102000),
	    LA_RIOJA(362000, 89680),
	    SANTIAGO_DEL_ESTERO(1060000, 136000);

	    private int cantidadPoblacion;
	    private int superficie;

	    private Provincia(int cantidadPoblacion, int superficie) {
	        this.cantidadPoblacion = cantidadPoblacion;
	        this.superficie = superficie;
	    }

	    public int getCantidadPoblacion() {
	        return cantidadPoblacion;
	    }

	    public void setCantidadPoblacion(int cantidadPoblacion) {
	        this.cantidadPoblacion = cantidadPoblacion;
	    }

	    public int getSuperficie() {
	        return superficie;
	    }

	    public void setSuperficie(int superficie) {
	        this.superficie = superficie;
	    }

	    public double calcularDensidadPoblacional() {
	        return (double) cantidadPoblacion / superficie;
	    }
	}