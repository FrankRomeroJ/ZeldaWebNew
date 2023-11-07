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
@Table(name="municipios")
public class Municipios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reg_municipio;
	
	
	private Integer idmunicipio;
	
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="iddepto",referencedColumnName = "reg_depto")
	private Departamentos departamentos;

	
	
	public Municipios() {
	}



	public Municipios(Integer reg_municipio, Integer idmunicipio, String descripcion, Departamentos departamentos) {
		super();
		this.reg_municipio = reg_municipio;
		this.idmunicipio = idmunicipio;
		this.descripcion = descripcion;
		this.departamentos = departamentos;
	}





	public Integer getReg_municipio() {
		return reg_municipio;
	}



	public void setReg_municipio(Integer reg_municipio) {
		this.reg_municipio = reg_municipio;
	}



	public Integer getIdmunicipio() {
		return idmunicipio;
	}



	public void setIdmunicipio(Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
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
		return "Municipios [reg_municipio=" + reg_municipio + ", idmunicipio=" + idmunicipio + ", descripcion="
				+ descripcion + ", departamentos=" + departamentos + "]";
	}



	
	
}
