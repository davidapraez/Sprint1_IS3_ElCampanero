package clases;

public class Factura {
	String idfactura,idhangar,idavion, aerolinea,facturado;
	
	
	

	public Factura(String idfactura, String idhangar, String idavion, String aerolinea, String facturado) {
		this.idfactura = idfactura;
		this.idhangar = idhangar;
		this.idavion = idavion;
		this.aerolinea = aerolinea;
		this.facturado = facturado;
	}

	public String getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(String idfactura) {
		this.idfactura = idfactura;
	}

	public String getIdhangar() {
		return idhangar;
	}

	public void setIdhangar(String idhangar) {
		this.idhangar = idhangar;
	}

	public String getIdavion() {
		return idavion;
	}

	public void setIdavion(String idavion) {
		this.idavion = idavion;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getFacturado() {
		return facturado;
	}

	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}
	
	
	
	

}
