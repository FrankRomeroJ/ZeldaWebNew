package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paises")
public class Paises implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpais;
	
	private String nombrepais;
	
	private String iniciales;
	
	private boolean estatus;
	

	public Paises() {
		
		
	}

	public Paises(Integer idpais, String nombrepais, 
			String iniciales, boolean estatus) {
		super();
		this.idpais = idpais;
		this.nombrepais = nombrepais;
		this.iniciales = iniciales;
		this.estatus = estatus;
		
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getNombrepais() {
		return nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}

	public String getIniciales() {
		return iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

	

	@Override
	public String toString() {
		return "Paises [idpais=" + idpais + ", nombrepais=" + nombrepais + ", iniciales=" + iniciales
				+ "estatus" + estatus + "]";
	}

	

	
	
	
	
}
