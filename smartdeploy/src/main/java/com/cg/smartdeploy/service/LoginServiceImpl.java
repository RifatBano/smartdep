package com.cg.smartdeploy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.smartdeploy.dao.LoginDatabase;
import com.cg.smartdeploy.entity.BenchEmployee;
import com.cg.smartdeploy.entity.DateHelper;
import com.cg.smartdeploy.entity.ManagerMaster;
import com.cg.smartdeploy.exception.ProgramException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDatabase dao;
	
	

	public ManagerMaster login(ManagerMaster employees)throws ProgramException {
		
		return dao.loginDb(employees);
	}



	public List<Integer> demandReportingDb(LocalDate startDate, LocalDate endDate) throws ProgramException {
		
		System.out.println(startDate);
		return dao.demandReportingDbDao(startDate, endDate);
	}



	
	public List<BenchEmployee> getBenchEmployee() {
		
		return dao.getBenchEmployeeDetails();
	}



	@Override
	public void deployService(List<String> employeesList) throws ProgramException{
		
		dao.deployServiceDao(employeesList);
	}

}
