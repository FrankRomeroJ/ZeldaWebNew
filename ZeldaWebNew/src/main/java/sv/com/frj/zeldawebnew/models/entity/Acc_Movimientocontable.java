package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the acc_movimientocontable database table.
 * 
 */
@Entity
@Table(name="acc_movimientocontable")
public class Acc_Movimientocontable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Acc_MovimientocontablePK id;

	private float abonos;

	private float cargos;

	@Column(length=150)
	private String concepto;

	@Column(nullable=false, length=2)
	private String cuenta;

	@Column(nullable=false, length=12)
	private String cuentacontable;

	@Column(nullable=false)
	private int diapartida;

	@Column(nullable=false, length=100)
	private String documento;

	@Column(nullable=false, length=1)
	private String estatus;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechacreacion;

	@Temporal(TemporalType.DATE)
	private Date fechamodificacion;

	@Column(nullable=false)
	private Time horacreacion;

	private Time horamodificacion;

	@Column(nullable=false, length=2)
	private String mayor;

	@Column(nullable=false, length=1)
	private String rubro;

	@Column(nullable=false, length=100)
	private String scta1;

	@Column(nullable=false, length=100)
	private String scta2;

	@Column(nullable=false, length=100)
	private String scta3;

	@Column(nullable=false, length=100)
	private String scta4;

	@Column(nullable=false, length=2)
	private String tipopartida;

	@Column(nullable=false, length=50)
	private String usuariocreacion;

	@Column(length=50)
	private String usuariomodifcacon;

	//bi-directional many-to-one association to AccPeriodocont
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="aniopartida", referencedColumnName="aniocontable", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="mespartida", referencedColumnName="mescontable", nullable=false, insertable=false, updatable=false)
		})
	private Acc_PeriodoCont accPeriodocont;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empresa", nullable=false, insertable=false, updatable=false)
	private Empresa empresaBean;

	public Acc_Movimientocontable() {
	}

	public Acc_MovimientocontablePK getId() {
		return this.id;
	}

	public void setId(Acc_MovimientocontablePK id) {
		this.id = id;
	}

	public float getAbonos() {
		return this.abonos;
	}

	public void setAbonos(float abonos) {
		this.abonos = abonos;
	}

	public float getCargos() {
		return this.cargos;
	}

	public void setCargos(float cargos) {
		this.cargos = cargos;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCuentacontable() {
		return this.cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}

	public int getDiapartida() {
		return this.diapartida;
	}

	public void setDiapartida(int diapartida) {
		this.diapartida = diapartida;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechamodificacion() {
		return this.fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public Time getHoracreacion() {
		return this.horacreacion;
	}

	public void setHoracreacion(Time horacreacion) {
		this.horacreacion = horacreacion;
	}

	public Time getHoramodificacion() {
		return this.horamodificacion;
	}

	public void setHoramodificacion(Time horamodificacion) {
		this.horamodificacion = horamodificacion;
	}

	public String getMayor() {
		return this.mayor;
	}

	public void setMayor(String mayor) {
		this.mayor = mayor;
	}

	public String getRubro() {
		return this.rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getScta1() {
		return this.scta1;
	}

	public void setScta1(String scta1) {
		this.scta1 = scta1;
	}

	public String getScta2() {
		return this.scta2;
	}

	public void setScta2(String scta2) {
		this.scta2 = scta2;
	}

	public String getScta3() {
		return this.scta3;
	}

	public void setScta3(String scta3) {
		this.scta3 = scta3;
	}

	public String getScta4() {
		return this.scta4;
	}

	public void setScta4(String scta4) {
		this.scta4 = scta4;
	}

	public String getTipopartida() {
		return this.tipopartida;
	}

	public void setTipopartida(String tipopartida) {
		this.tipopartida = tipopartida;
	}

	public String getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public String getUsuariomodifcacon() {
		return this.usuariomodifcacon;
	}

	public void setUsuariomodifcacon(String usuariomodifcacon) {
		this.usuariomodifcacon = usuariomodifcacon;
	}

	public Acc_PeriodoCont getAccPeriodocont() {
		return this.accPeriodocont;
	}

	public void setAccPeriodocont(Acc_PeriodoCont accPeriodocont) {
		this.accPeriodocont = accPeriodocont;
	}

	public Empresa getEmpresaBean() {
		return this.empresaBean;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresaBean = empresaBean;
	}

}