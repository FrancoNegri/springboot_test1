package application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

	private @Id @GeneratedValue Long id;
	private String position;
	private Long salary;

	public Role() {
	}

	public Role(String position, Long salary) {
		this.position = position;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (position == null ? 0 : position.hashCode());
		result = prime * result + (salary == null ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Role other = (Role) obj;
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (salary == null) {
			if (other.salary != null) {
				return false;
			}
		} else if (!salary.equals(other.salary)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Role [position=" + position + ", salary=" + salary + "]";
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}