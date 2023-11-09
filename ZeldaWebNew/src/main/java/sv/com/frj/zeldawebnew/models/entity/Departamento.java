package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="pais_id", referencedColumnName = "id")
	private Pais pais;

	public Departamento() {
		
	}

	public Departamento(Integer id, String descripcion, Pais pais) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.pais = pais;
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Departamentos [id=" + id + ", descripcion=" + descripcion +  ", pais=" + pais + "]";
	}
	

		
	
}
