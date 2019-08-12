package com.cg.smartdeploy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BENCHEMPLOYEE")
public class BenchEmployee {
	
	@Id
	@Column(name="EMPLOYEEID")
	private String employeeId;
	
	@Column(name="EMPLOYEENAME")
	private String employeeName;
	
	@Column(name="SKILL")
	private String skill;
	
	@Column(name="GRADE")
	private String grade;
	
	@Column(name="TRAININGSTARTDATE")
	private LocalDate trainingStartDate; 
	
	@Column(name="TRAININGCOMPLETIONDATE")
	private LocalDate trainingCompletionDate;
	
	
	@Column(name="MANAGERID")
	private String managerId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public LocalDate getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(LocalDate trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public LocalDate getTrainingCompletionDate() {
		return trainingCompletionDate;
	}

	public void setTrainingCompletionDate(LocalDate trainingCompletionDate) {
		this.trainingCompletionDate = trainingCompletionDate;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "BenchEmployee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", skill=" + skill
				+ ", grade=" + grade + ", trainingStartDate=" + trainingStartDate + ", trainingCompletionDate="
				+ trainingCompletionDate + ", managerId=" + managerId + "]";
	}
	
	

}
