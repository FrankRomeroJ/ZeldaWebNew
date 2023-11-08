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
@Table(name="departamentos")
public class Departamentos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="paises_id", referencedColumnName = "id")
	private Paises paises;

	public Departamentos() {
		
	}

	public Departamentos(Integer id, String descripcion, Paises paises) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.paises = paises;
		
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

	public Paises getPaises() {
		return paises;
	}

	public void setPaises(Paises paises) {
		this.paises = paises;
	}

	@Override
	public String toString() {
		return "Departamentos [id=" + id + ", descripcion=" + descripcion +  ", paises=" + paises + "]";
	}
	

		
	
}
