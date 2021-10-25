package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity 	//POJO
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Table(name="Department")
public class Department {
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", hodName=" + hodName + ", employees="
				+ employees + "]";
	}
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int deptId;
	
	@Column(name="dept_name")
	String  deptName;
	
	@Column(name="hod_name")
	String hodName;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)	//,mappedBy="department"	//department is the name of property not column name
	@JoinColumn(name="department")
	private Set<Employee> employees;	//
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}