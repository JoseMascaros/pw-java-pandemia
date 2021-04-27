package pe.edu.upc.pandemia.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	// EmbeddedId primary key
	@Id
	private Integer id;

	@Column(name = "username", length = 30, nullable = false)
	private String username;

	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@Column(name = "enable")
	private boolean enable;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Employee employee;

	// -- Constructor, Getter y Setter
	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
