package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	private String nombrepais;
	
	private boolean estatus;
	

	public Pais() {
		
		
	}

	public Pais(Integer id, String nombrepais, 
			 boolean estatus) {
		super();
		this.id = id;
		this.nombrepais = nombrepais;
		this.estatus = estatus;
		
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrepais() {
		return nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombrepais=" + nombrepais + ", estatus=" + estatus + "]";
	}

	

	
	
	
	
}
