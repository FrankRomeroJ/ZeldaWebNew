package sv.com.frj.zeldawebnew.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private boolean enabled;

	private String password;

	private String username;

	
	//bi-directional many-to-one association to Roles
	@OneToMany(mappedBy="users", cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private Set<Roles> roles;
	

	public Users() {
		this.roles= new HashSet<Roles>();
	}


	public Users(boolean enabled, String password, String username) {
		super();
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.roles= new HashSet<Roles>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean  enabled) {
		this.enabled = enabled;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	


	public Set<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", enabled=" + enabled + ", password=" + password + ", username=" + username + "]";
	}




}