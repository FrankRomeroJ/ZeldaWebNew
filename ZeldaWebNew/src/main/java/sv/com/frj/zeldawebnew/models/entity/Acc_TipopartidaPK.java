package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class Acc_TipopartidaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Column(name="empresa")
	private Integer empresaFK;
	
	@Column(name="codigo")
	private String codigo;
	
	
	
	
	public Acc_TipopartidaPK() {
	super();
	}

	public Acc_TipopartidaPK(Integer empresaFK, String codigo) {
		super();
		this.empresaFK = empresaFK;
		this.codigo = codigo;
	}

	public Integer getEmpresaFK() {
		return empresaFK;
	}

	public void setEmpresaFK(Integer empresaFK) {
		this.empresaFK = empresaFK;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Acc_TipopartidaPK [empresaFK=" + empresaFK + ", codigo=" + codigo + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(codigo, empresaFK);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acc_TipopartidaPK other = (Acc_TipopartidaPK) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(empresaFK, other.empresaFK);
	}



}
