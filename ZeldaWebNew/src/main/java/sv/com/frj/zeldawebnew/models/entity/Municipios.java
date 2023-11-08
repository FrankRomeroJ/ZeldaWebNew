package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipios")
public class Municipios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;  
	
	
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="departamento_id", referencedColumnName = "id")
	private Departamentos departamentos;

	
	
	public Municipios() {
	}


	public Municipios(Integer id, String descripcion, Departamentos departamentos) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.departamentos = departamentos;
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


	public Departamentos getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}


	@Override
	public String toString() {
		return "Municipios [id=" + id + ", descripcion=" + descripcion + ", departamentos=" + departamentos + "]";
	}


	


	
	
}
