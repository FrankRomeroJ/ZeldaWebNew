package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
	
	@EmbeddedId
	private Acc_TipopartidaPK llave;
	
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@MapsId("empresaFK")
	@JoinColumn(name="empresa")
	private Empresa empresa;
	
	
	public Acc_Tipopartida() {
	super();
	}


	public Acc_Tipopartida(Acc_TipopartidaPK llave, String descripcion, Empresa empresa) {
		super();
		this.llave = llave;
		this.descripcion = descripcion;
		this.empresa = empresa;
	}


	public Acc_TipopartidaPK getLlave() {
		return llave;
	}


	public void setLlave(Acc_TipopartidaPK llave) {
		this.llave = llave;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "Acc_Tipopartida [llave=" + llave + ", descripcion=" + descripcion + ", empresa=" + empresa + "]";
	}
	
}
