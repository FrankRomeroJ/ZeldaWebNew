package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Acc_CatalogoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name="empresa")
	private int empresaPK;
	
	@Column(name="numcuenta")
	private String numcuenta;

	public Acc_CatalogoPK() {
	}

	public Acc_CatalogoPK(int empresaPK, String numcuenta) {
		this.empresaPK = empresaPK;
		this.numcuenta = numcuenta;
	}

	public int getEmpresaPK() {
		return empresaPK;
	}

	public void setEmpresaPK(int empresaPK) {
		this.empresaPK = empresaPK;
	}

	public String getNumcuenta() {
		return numcuenta;
	}

	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}

	@Override
	public String toString() {
		return "Acc_CatalogoPK [empresaPK=" + empresaPK + ", numcuenta=" + numcuenta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empresaPK, numcuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acc_CatalogoPK other = (Acc_CatalogoPK) obj;
		return empresaPK == other.empresaPK && Objects.equals(numcuenta, other.numcuenta);
	}
	
	
}
