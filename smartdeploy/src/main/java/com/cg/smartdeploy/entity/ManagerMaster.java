package com.cg.smartdeploy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="MANAGERMASTER")
public class ManagerMaster {

	@Id
	@Column(name="MANAGERID")
	private String managerId;
	
	@Column(name="MANAGERNAME")
	private String managerName;
	
	@Column(name="PROJECTID")
	private int projectId;
	
	
	
	@Column(name="MANAGERPASSWORD")
	private String managerPassword;
	
	@Column(name="ROLEID")
	private int roleId;

	
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		
		return "ManagerMaster [managerId=" + managerId + ", managerName=" + managerName + ", projectId=" + projectId
				+ ", managerPassword=" + managerPassword + ", roleId=" + roleId + "]";
	}

	
	
	
}
