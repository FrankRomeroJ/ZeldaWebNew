package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="acc_tipopartida")
public class Acc_Tipopartida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="codigo")
	private String codigo;
	
	
	@Column(name="descripcion")
	private String descripcion;
	
	
	
	
	public Acc_Tipopartida() {
	super();
	}




	public Acc_Tipopartida(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	@Override
	public String toString() {
		return "Acc_Tipopartida [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}




	
}
