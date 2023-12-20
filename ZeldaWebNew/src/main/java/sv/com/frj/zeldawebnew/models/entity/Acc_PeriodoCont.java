package sv.com.frj.zeldawebnew.models.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="acc_periodocont")
public class Acc_PeriodoCont {
	
	@EmbeddedId
	private Acc_PeriodoContPK llave;
	
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name= "fechaapertura" )
	@Temporal(TemporalType.DATE)
	private Date fechaApertura;
	
	
	@Column(name="fechacierre")
	@Temporal(TemporalType.DATE)
	private Date fechaCierre;


	
	
	public Acc_PeriodoCont() {
	}


		public Acc_PeriodoCont(Acc_PeriodoContPK llave, String estatus, Date fechaApertura, Date fechaCierre) {
		this.llave = llave;
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



	public String getEstatus() {
		return estatus;
	}




	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}




	public Date getFechaApertura() {
		return fechaApertura;
	}




	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}




	public Date getFechaCierre() {
		return fechaCierre;
	}




	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	
	

}
