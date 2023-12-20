package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Acc_ControlPartidasPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int empresa;
	
	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=2)
	private String tipopartida;
	
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int anioperiodo;
	
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int mesperiodo;
	
	@Column(unique=true, nullable=false)
	private int numeropartida;

	public Acc_ControlPartidasPK() {
	}

	public Acc_ControlPartidasPK(int empresa, String tipopartida, int anioperiodo, int mesperiodo,
			int numeropartida) {
		this.empresa = empresa;
		this.tipopartida = tipopartida;
		this.anioperiodo = anioperiodo;
		this.mesperiodo = mesperiodo;
		this.numeropartida = numeropartida;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public String getTipopartida() {
		return tipopartida;
	}

	public void setTipopartida(String tipopartida) {
		this.tipopartida = tipopartida;
	}

	public int getAnioperiodo() {
		return anioperiodo;
	}

	public void setAnioperiodo(int anioperiodo) {
		this.anioperiodo = anioperiodo;
	}

	public int getMesperiodo() {
		return mesperiodo;
	}

	public void setMesperiodo(int mesperiodo) {
		this.mesperiodo = mesperiodo;
	}

	public int getNumeropartida() {
		return numeropartida;
	}

	public void setNumeropartida(int numeropartida) {
		this.numeropartida = numeropartida;
	}

	@Override
	public String toString() {
		return "Acc_ControlPartidas [empresa=" + empresa + ", tipopartida=" + tipopartida + ", anioperiodo="
				+ anioperiodo + ", mesperiodo=" + mesperiodo + ", numeropartida=" + numeropartida + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anioperiodo, empresa, mesperiodo, numeropartida, tipopartida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acc_ControlPartidasPK other = (Acc_ControlPartidasPK) obj;
		return anioperiodo == other.anioperiodo && empresa == other.empresa && mesperiodo == other.mesperiodo
				&& numeropartida == other.numeropartida && Objects.equals(tipopartida, other.tipopartida);
	}

	

		
}
