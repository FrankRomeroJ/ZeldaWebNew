package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the acc_movimientocontable database table.
 * 
 */
@Embeddable
public class Acc_MovimientocontablePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int empresa;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int aniopartida;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int mespartida;

	@Column(unique=true, nullable=false)
	private int numeropartida;

	@Column(unique=true, nullable=false)
	private int regcorrelativo;

	public Acc_MovimientocontablePK() {
	}
	public int getEmpresa() {
		return this.empresa;
	}
	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	public int getAniopartida() {
		return this.aniopartida;
	}
	public void setAniopartida(int aniopartida) {
		this.aniopartida = aniopartida;
	}
	public int getMespartida() {
		return this.mespartida;
	}
	public void setMespartida(int mespartida) {
		this.mespartida = mespartida;
	}
	public int getNumeropartida() {
		return this.numeropartida;
	}
	public void setNumeropartida(int numeropartida) {
		this.numeropartida = numeropartida;
	}
	public int getRegcorrelativo() {
		return this.regcorrelativo;
	}
	public void setRegcorrelativo(int regcorrelativo) {
		this.regcorrelativo = regcorrelativo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Acc_MovimientocontablePK)) {
			return false;
		}
		Acc_MovimientocontablePK castOther = (Acc_MovimientocontablePK)other;
		return 
			(this.empresa == castOther.empresa)
			&& (this.aniopartida == castOther.aniopartida)
			&& (this.mespartida == castOther.mespartida)
			&& (this.numeropartida == castOther.numeropartida)
			&& (this.regcorrelativo == castOther.regcorrelativo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empresa;
		hash = hash * prime + this.aniopartida;
		hash = hash * prime + this.mespartida;
		hash = hash * prime + this.numeropartida;
		hash = hash * prime + this.regcorrelativo;
		
		return hash;
	}
}