package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the grupos_roles database table.
 * 
 */
@Entity
@Table(name="grupos_roles")
@NamedQuery(name="Grupos_roles.findAll", query="SELECT g FROM Grupos_roles g")
public class Grupos_roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idrol;

	private String descripcion;

	//bi-directional many-to-one association to Roles
	@OneToMany(mappedBy="grupos_roles", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private Set<Roles> roles;

	public Grupos_roles() {
		this.roles= new HashSet<Roles>();
	}
	

	public Grupos_roles(String idrol, String descripcion) {
		super();
		this.idrol = idrol;
		this.descripcion = descripcion;
		this.roles= new HashSet<Roles>();
	}


	public String getIdrol() {
		return idrol;
	}


	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public Set<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "Grupos_roles [idrol=" + idrol + ", descripcion=" + descripcion + "]";
	}



}