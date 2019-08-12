package com.cg.smartdeploy.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.smartdeploy.entity.BenchEmployee;
import com.cg.smartdeploy.entity.ManagerMaster;
import com.cg.smartdeploy.exception.ProgramException;

public interface LoginDatabase {

	public  ManagerMaster loginDb(ManagerMaster employees) throws ProgramException;
	public List<Integer> demandReportingDbDao(LocalDate startDate,LocalDate endDate) throws ProgramException;

	public List<BenchEmployee> getBenchEmployeeDetails();
	
	public void deployServiceDao(List<String> list) throws ProgramException;

}
