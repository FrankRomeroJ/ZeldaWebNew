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
	private Integer reg_depto;
	
	private String descripcion;
	private Integer iddepto;
	
	
	
	@ManyToOne
	@JoinColumn(name="idpais",referencedColumnName = "idpais")
	private Paises paises;

	public Departamentos() {
		
	}

	public Departamentos(Integer reg_depto, Integer iddepto, String descripcion, Paises paises) {
		super();
		this.reg_depto = reg_depto;
		this.iddepto = iddepto;
		this.descripcion = descripcion;
		this.paises = paises;
		
	}

	public Integer getReg_depto() {
		return reg_depto;
	}

	public void setReg_depto(Integer reg_depto) {
		this.reg_depto = reg_depto;
	}

	public Integer getIddepto() {
		return iddepto;
	}

	public void setIddepto(Integer iddepto) {
		this.iddepto = iddepto;
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
		return "Departamentos [reg_depto=" + reg_depto + ", descripcion=" + descripcion + ", iddepto=" + iddepto
				+ ", paises=" + paises + "]";
	}
	

	


		
	
}
