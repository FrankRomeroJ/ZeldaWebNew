package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
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
@Table(name="empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
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
	private Pais pais;

	
	@ManyToOne
	@JoinColumn(name="departamento_id", referencedColumnName = "id")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="municipio_id", referencedColumnName = "id")
	private Municipio municipio;

	public Empresa() {
		super();
	}


	public Empresa(Integer id, @NotEmpty String razon_social, @NotEmpty String nit, @NotEmpty String registro_iva,
			@NotEmpty String direccion, @NotEmpty String giro, @NotEmpty String nombre_corto,
			@NotEmpty String representante_legal, @NotEmpty @Pattern(regexp = "[0-9]{4}-[0-9]{4}") String telefono,
			@NotEmpty @Email String email, Pais pais, Departamento departamento, Municipio municipio) {
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
		this.pais = pais;
		this.departamento = departamento;
		this.municipio = municipio;
	}







	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
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



	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais= pais;
	}



	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	public Municipio getMunicipio() {
		return municipio;
	}



	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public boolean isSelected(Integer id){
        if (id != null) {
            return id.equals(id);
        }
        return false;
    } 


	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razon_social=" + razon_social + ", nit=" + nit + ", registro_iva="
				+ registro_iva + ", direccion=" + direccion + ", giro=" + giro + ", nombre_corto=" + nombre_corto
				+ ", representante_legal=" + representante_legal + ", telefono=" + telefono + ", email=" + email
				+ ", pais=" + pais + ", departamento=" + departamento + ", municipio=" + municipio + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(departamento, direccion, email, giro, id, municipio, nit, nombre_corto, pais, razon_social,
				registro_iva, representante_legal, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(email, other.email) && Objects.equals(giro, other.giro)
				&& Objects.equals(id, other.id) && Objects.equals(municipio, other.municipio)
				&& Objects.equals(nit, other.nit) && Objects.equals(nombre_corto, other.nombre_corto)
				&& Objects.equals(pais, other.pais) && Objects.equals(razon_social, other.razon_social)
				&& Objects.equals(registro_iva, other.registro_iva)
				&& Objects.equals(representante_legal, other.representante_legal)
				&& Objects.equals(telefono, other.telefono);
	}



		
}
