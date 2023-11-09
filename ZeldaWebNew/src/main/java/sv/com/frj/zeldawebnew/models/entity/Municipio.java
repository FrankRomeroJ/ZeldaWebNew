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
@Table(name = "municipio")
public class Municipio implements Serializable{

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
	private Departamento departamento;

	
	
	public Municipio() {
	}


		
	public Municipio(Integer id, String descripcion, Departamento departamento) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.departamento = departamento;
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


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	@Override
	public String toString() {
		return "Municipio [id=" + id + ", descripcion=" + descripcion + ", departamento=" + departamento + "]";
	}



	


	
	
}
