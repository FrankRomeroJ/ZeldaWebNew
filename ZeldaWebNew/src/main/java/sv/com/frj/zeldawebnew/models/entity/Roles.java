package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@NamedQuery(name="Roles.findAll", query="SELECT r FROM Roles r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="rol",referencedColumnName = "rol")
	private Grupos_roles grupos_roles;

	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private Users users;

	public Roles() {
	}
	
	

	public Roles(Long id, Grupos_roles grupos_roles, Users users) {
		super();
		this.id = id;
		this.grupos_roles = grupos_roles;
		this.users = users;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Grupos_roles getGrupos_roles() {
		return grupos_roles;
	}

	public void setGrupos_roles(Grupos_roles grupos_roles) {
		this.grupos_roles = grupos_roles;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", grupos_roles=" + grupos_roles + ", users=" + users + "]";
	}

	

}