package application;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Role.class)
	private List<Role> roleHistory;
	@ElementCollection
	private Map<String, String> metadata;

	Employee() {
	}

	public Employee(String name, Role role, List<Role> roleHistory, Map<String, String> metadata) {
		this.name = name;
		this.role = role;
		this.roleHistory = roleHistory;
		this.metadata = metadata;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public List<Role> getRoleHistory() {
		return roleHistory;
	}

	public void setRoleHistory(List<Role> roleHistory) {
		this.roleHistory = roleHistory;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(role, employee.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", roleHistory=" + roleHistory + ", metadata=" + metadata + "]";
	}

}