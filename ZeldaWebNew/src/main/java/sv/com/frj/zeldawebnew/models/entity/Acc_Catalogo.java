package sv.com.frj.zeldawebnew.models.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="acc_catalogo")
public class Acc_Catalogo {


	
	@EmbeddedId
	private Acc_CatalogoPK llave;
	
	@ManyToOne
	@MapsId("empresaPK")
	@JoinColumn(name="empresa")
	private Empresa empresa;
	
	
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="nivel")
	private Integer nivel;
	@Column(name="naturaleza")
	private String naturaleza;
	@Column(name="rubro")
	private String rubro;
	@Column(name="mayor")
	private String mayor;
	@Column(name="scta")
	private String scta;
	@Column(name="scta1")
	private String scta1;
	@Column(name="scta2")
	private String scta2;
	@Column(name="scta3")
	private String scta3;
	@Column(name="scta4")
	private String scta4;
	@Column(name="estatus")
	private String estatus;
	@Column(name="efecto")
	private String efecto;
	@Column (name="tipcuenta")
	private String tipcuenta;
	@Column (name="saliniejerc")
	private float saliniejerc;
	@Column (name="cargosejerc")
	private float cargosejerc;
	@Column (name="abonosejerc")
	private float abonosejerc;
	@Column (name="salfinejerc")
	private float salfinejerc;
	
	
	
	public Acc_Catalogo() {
	}



	public Acc_Catalogo(Acc_CatalogoPK llave, Empresa empresa, String descripcion, Integer nivel, String naturaleza,
			String rubro, String mayor, String scta, String scta1, String scta2, String scta3, String scta4,
			String estatus, String efecto, String tipcuenta, float saliniejerc, float cargosejerc, float abonosejerc,
			float salfinejerc) {
		this.llave = llave;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.naturaleza = naturaleza;
		this.rubro = rubro;
		this.mayor = mayor;
		this.scta = scta;
		this.scta1 = scta1;
		this.scta2 = scta2;
		this.scta3 = scta3;
		this.scta4 = scta4;
		this.estatus = estatus;
		this.efecto = efecto;
		this.tipcuenta = tipcuenta;
		this.saliniejerc = saliniejerc;
		this.cargosejerc = cargosejerc;
		this.abonosejerc = abonosejerc;
		this.salfinejerc = salfinejerc;
	}



	public Acc_CatalogoPK getLlave() {
		return llave;
	}



	public void setLlave(Acc_CatalogoPK llave) {
		this.llave = llave;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Integer getNivel() {
		return nivel;
	}



	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}



	public String getNaturaleza() {
		return naturaleza;
	}



	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}



	public String getRubro() {
		return rubro;
	}



	public void setRubro(String rubro) {
		this.rubro = rubro;
	}



	public String getMayor() {
		return mayor;
	}



	public void setMayor(String mayor) {
		this.mayor = mayor;
	}



	public String getScta() {
		return scta;
	}



	public void setScta(String scta) {
		this.scta = scta;
	}



	public String getScta1() {
		return scta1;
	}



	public void setScta1(String scta1) {
		this.scta1 = scta1;
	}



	public String getScta2() {
		return scta2;
	}



	public void setScta2(String scta2) {
		this.scta2 = scta2;
	}



	public String getScta3() {
		return scta3;
	}



	public void setScta3(String scta3) {
		this.scta3 = scta3;
	}



	public String getScta4() {
		return scta4;
	}



	public void setScta4(String scta4) {
		this.scta4 = scta4;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String getEfecto() {
		return efecto;
	}



	public void setEfecto(String efecto) {
		this.efecto = efecto;
	}



	public String getTipcuenta() {
		return tipcuenta;
	}



	public void setTipcuenta(String tipcuenta) {
		this.tipcuenta = tipcuenta;
	}



	public float getSaliniejerc() {
		return saliniejerc;
	}



	public void setSaliniejerc(float saliniejerc) {
		this.saliniejerc = saliniejerc;
	}



	public float getCargosejerc() {
		return cargosejerc;
	}



	public void setCargosejerc(float cargosejerc) {
		this.cargosejerc = cargosejerc;
	}



	public float getAbonosejerc() {
		return abonosejerc;
	}



	public void setAbonosejerc(float abonosejerc) {
		this.abonosejerc = abonosejerc;
	}



	public float getSalfinejerc() {
		return salfinejerc;
	}



	public void setSalfinejerc(float salfinejerc) {
		this.salfinejerc = salfinejerc;
	}



	@Override
	public String toString() {
		return "Acc_Catalogo [llave=" + llave + ", empresa=" + empresa + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", naturaleza=" + naturaleza + ", rubro=" + rubro + ", mayor=" + mayor + ", scta=" + scta
				+ ", scta1=" + scta1 + ", scta2=" + scta2 + ", scta3=" + scta3 + ", scta4=" + scta4 + ", estatus="
				+ estatus + ", efecto=" + efecto + ", tipcuenta=" + tipcuenta + ", saliniejerc=" + saliniejerc
				+ ", cargosejerc=" + cargosejerc + ", abonosejerc=" + abonosejerc + ", salfinejerc=" + salfinejerc
				+ "]";
	}
	
	
	
	
	
	
}
