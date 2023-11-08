package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="empresas")
public class Empresas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	private String razon_social;
	@NotEmpty
	private String nit;
	@NotEmpty
	private String registro_iva;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String giro;
	@NotEmpty
	private String nombre_corto;
	@NotEmpty
	private String representante_legal;
	@NotEmpty
	@Pattern(regexp="[0-9]{4}-[0-9]{4}")
	private String telefono;
	@NotEmpty
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name="pais_id",referencedColumnName = "id")
	private Paises paises;

	
	@ManyToOne
	@JoinColumn(name="departamento_id", referencedColumnName = "id")
	private Departamentos departamentos;
	
	@ManyToOne
	@JoinColumn(name="municipio_id", referencedColumnName = "id")
	private Municipios municipios;

	public Empresas() {
		super();
	}

	public Empresas(Integer id, @NotEmpty String razon_social, @NotEmpty String nit,
			@NotEmpty String registro_iva, @NotEmpty String direccion, @NotEmpty String giro,
			@NotEmpty String nombre_corto, @NotEmpty String representante_legal,
			@NotEmpty @Pattern(regexp = "[0-9]{4}-[0-9]{4}") String telefono, @NotEmpty @Email String email,
			Paises paises, Departamentos departamentos, Municipios municipios) {
		super();
		this.id = id;
		this.razon_social = razon_social;
		this.nit = nit;
		this.registro_iva = registro_iva;
		this.direccion = direccion;
		this.giro = giro;
		this.nombre_corto = nombre_corto;
		this.representante_legal = representante_legal;
		this.telefono = telefono;
		this.email = email;
		this.paises = paises;
		this.departamentos = departamentos;
		this.municipios = municipios;
	}

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRegistro_iva() {
		return registro_iva;
	}

	public void setRegistro_iva(String registro_iva) {
		this.registro_iva = registro_iva;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getRepresentante_legal() {
		return representante_legal;
	}

	public void setRepresentante_legal(String representante_legal) {
		this.representante_legal = representante_legal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Paises getPaises() {
		return paises;
	}

	public void setPaises(Paises paises) {
		this.paises = paises;
	}

	public Departamentos getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public Municipios getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Municipios municipios) {
		this.municipios = municipios;
	}

	@Override
	public String toString() {
		return "Empresas [id=" + id + ", razon_social=" + razon_social + ", nit=" + nit
				+ ", registro_iva=" + registro_iva + ", direccion=" + direccion + ", giro=" + giro + ", nombre_corto="
				+ nombre_corto + ", representante_legal=" + representante_legal + ", telefono=" + telefono + ", email="
				+ email + ", paises=" + paises + ", departamentos=" + departamentos + ", municipios=" + municipios
				+ "]";
	}

	
	
	
}
