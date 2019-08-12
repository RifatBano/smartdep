package com.cg.smartdeploy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Roles {

	@Id
	private int roleId;
	
	private String roleDescription;
	
	
	
}
