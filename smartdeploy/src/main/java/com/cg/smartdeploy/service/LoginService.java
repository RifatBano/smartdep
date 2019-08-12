package com.cg.smartdeploy.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.smartdeploy.entity.BenchEmployee;
import com.cg.smartdeploy.entity.ManagerMaster;
import com.cg.smartdeploy.exception.ProgramException;

public interface LoginService {
	
	public ManagerMaster login(ManagerMaster master) throws ProgramException;
	
	public List<Integer> demandReportingDb(LocalDate startDate,LocalDate endDate) throws ProgramException;

	public List<BenchEmployee> getBenchEmployee();
	
	public void deployService(List<String> employeesList) throws ProgramException;

}
