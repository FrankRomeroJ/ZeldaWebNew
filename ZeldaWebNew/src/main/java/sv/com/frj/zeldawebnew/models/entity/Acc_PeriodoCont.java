package sv.com.frj.zeldawebnew.models.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="acc_periodocont")
public class Acc_PeriodoCont {
	
	@EmbeddedId
	private Acc_PeriodoContPK llave;
	
	@ManyToOne
	@MapsId("empresaPK")
	@JoinColumn(name="empresa")
	private Empresa empresa;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name= "fechaapertura" )
	@Temporal(TemporalType.DATE)
	private Calendar fechaApertura;
	
	
	@Column(name="fechacierre")
	@Temporal(TemporalType.DATE)
	private Calendar fechaCierre;


	
	
	public Acc_PeriodoCont() {
	}




	public Acc_PeriodoCont(Acc_PeriodoContPK llave, Empresa empresa, String estatus, Calendar fechaApertura,
			Calendar fechaCierre) {
		this.llave = llave;
		this.empresa = empresa;
		this.estatus = estatus;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
	}




	public Acc_PeriodoContPK getLlave() {
		return llave;
	}




	public void setLlave(Acc_PeriodoContPK llave) {
		this.llave = llave;
	}




	public Empresa getEmpresa() {
		return empresa;
	}




	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}




	public String getEstatus() {
		return estatus;
	}




	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}




	public Calendar getFechaApertura() {
		return fechaApertura;
	}




	public void setFechaApertura(Calendar fechaApertura) {
		this.fechaApertura = fechaApertura;
	}




	public Calendar getFechaCierre() {
		return fechaCierre;
	}




	public void setFechaCierre(Calendar fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	
	

}
