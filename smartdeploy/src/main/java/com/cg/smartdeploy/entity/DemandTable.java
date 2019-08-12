package com.cg.smartdeploy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMANDTABLE")
public class DemandTable {
	
@Id
@Column(name="REQUESTID")
private int requestId;

@Column(name="MANAGERID")
private String managerId;

@Column(name="REQUESTDATE")
private LocalDate requestDate;

@Column(name="REQUESTRAISED")
private int requestRaised;

@Column(name="REQUESTFULLFILL")
private int requestFullfill;

public int getRequestId() {
	return requestId;
}

public void setRequestId(int requestId) {
	this.requestId = requestId;
}

public String getManagerId() {
	return managerId;
}

public void setManagerId(String managerId) {
	this.managerId = managerId;
}

public LocalDate getRequestDate() {
	return requestDate;
}

public void setRequestDate(LocalDate requestDate) {
	this.requestDate = requestDate;
}

public int getRequestRaised() {
	return requestRaised;
}

public void setRequestRaised(int requestRaised) {
	this.requestRaised = requestRaised;
}

public int getRequestFullfill() {
	return requestFullfill;
}

public void setRequestFullfill(int requestFullfill) {
	this.requestFullfill = requestFullfill;
}



}
