package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Acc_PeriodoContPK implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Column(name="aniocontable",length=4)
	private int aniocontable;
	@Column(name="mescontable", length=2)
	private int mescontable;
	
	public Acc_PeriodoContPK() {
	
	}
	public Acc_PeriodoContPK(int empresaPK, int aniocontable, int mescontable) {
		
		this.aniocontable = aniocontable;
		this.mescontable = mescontable;
	}

	public int getAniocontable() {
		return aniocontable;
	}
	public void setAniocontable(int aniocontable) {
		this.aniocontable = aniocontable;
	}
	public int getMescontable() {
		return mescontable;
	}
	public void setMescontable(int mescontable) {
		this.mescontable = mescontable;
	}
	@Override
	public String toString() {
		return "Acc_PeriodoContPK [aniocontable=" + aniocontable + ", mescontable=" + mescontable + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(aniocontable, mescontable);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acc_PeriodoContPK other = (Acc_PeriodoContPK) obj;
		return aniocontable == other.aniocontable && mescontable == other.mescontable;
	}
	
	
	
	
}
