package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="acc_controlpartidas")
public class Acc_Controlpartidas implements Serializable{

	private static final long serialVersionUID =1L;
	
	@EmbeddedId
	private Acc_ControlPartidasPK controlPartidasPK;

	@Column(name = "usuario",nullable=false, length=50)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaingreso")
	private Calendar fechaingreso;

	@ManyToOne
	@JoinColumn(name="empresa",nullable=false, insertable=false, updatable=false)
	private Empresa empresa;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="anioperiodo", referencedColumnName="aniocontable", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="mesperiodo", referencedColumnName="mescontable", nullable=false, insertable=false, updatable=false)
		})
	private Acc_PeriodoCont periodocont;
	
	@ManyToOne
	@JoinColumn(name="tipopartida",referencedColumnName="codigo", nullable=false, insertable=false, updatable=false)
	private Acc_Tipopartida tipopartida;

	public Acc_Controlpartidas() {
	}

	public Acc_Controlpartidas(Acc_ControlPartidasPK controlPartidasPK, String usuario, Calendar fechaingreso,
			Empresa empresa, Acc_PeriodoCont periodocont, Acc_Tipopartida tipopartida) {
		this.controlPartidasPK = controlPartidasPK;
		this.usuario = usuario;
		this.fechaingreso = fechaingreso;
		this.empresa = empresa;
		this.periodocont = periodocont;
		this.tipopartida = tipopartida;
	}

	public Acc_ControlPartidasPK getControlPartidasPK() {
		return controlPartidasPK;
	}

	public void setControlPartidasPK(Acc_ControlPartidasPK controlPartidasPK) {
		this.controlPartidasPK = controlPartidasPK;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Calendar getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Calendar fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Acc_PeriodoCont getPeriodocont() {
		return periodocont;
	}

	public void setPeriodocont(Acc_PeriodoCont periodocont) {
		this.periodocont = periodocont;
	}

	public Acc_Tipopartida getTipopartida() {
		return tipopartida;
	}

	public void setTipopartida(Acc_Tipopartida tipopartida) {
		this.tipopartida = tipopartida;
	}

	@Override
	public String toString() {
		return "Acc_ControlPartidas [controlPartidasPK=" + controlPartidasPK + ", usuario=" + usuario
				+ ", fechaingreso=" + fechaingreso + ", empresa=" + empresa + ", periodocont=" + periodocont
				+ ", tipopartida=" + tipopartida + "]";
	}

	


	

}
