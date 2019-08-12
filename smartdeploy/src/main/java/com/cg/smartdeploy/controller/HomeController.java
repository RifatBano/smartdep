package com.cg.smartdeploy.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.smartdeploy.entity.BenchEmployee;
import com.cg.smartdeploy.entity.DateHelper;
import com.cg.smartdeploy.entity.ManagerMaster;
import com.cg.smartdeploy.exception.ProgramException;
import com.cg.smartdeploy.service.LoginService;


@RestController
@CrossOrigin
public class HomeController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping(path="/login" ,produces = "application/json" , consumes = "application/json")
	
	public ManagerMaster managerLogin(@RequestBody ManagerMaster managerMaster) throws ProgramException 
	{
		ManagerMaster newobj=service.login(managerMaster);
		System.out.println(newobj);
		
		return newobj;
		
		
	}
	
	@PostMapping(path="/demand" ,produces = "application/json" , consumes = "application/json")
	public List<Integer> pieChartGeneration(@RequestBody DateHelper dateHelper ) throws ProgramException
	{	System.out.println(dateHelper.getBeginDate());
	System.out.println(dateHelper.getEndDate());
	System.out.println("hello1");
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate start=LocalDate.parse(dateHelper.getBeginDate(), dateTimeFormatter);
		LocalDate end=LocalDate.parse(dateHelper.getEndDate(), dateTimeFormatter);

//		dateHelper.setBeginDate(LocalDate.parse(dateHelper.getBeginDate().format(dateTimeFormatter),dateTimeFormatter));
//		dateHelper.setEndDate(LocalDate.parse(dateHelper.getEndDate().format(dateTimeFormatter),dateTimeFormatter));
//		System.out.println(dateHelper.getBeginDate());
//		System.out.println(dateHelper.getEndDate());
//		if((dateHelper.getEndDate().compareTo(dateHelper.getBeginDate()))<=0)
//			throw new ProgramException(ErrorMessages.MESSAGE19);
		System.out.println(start+" "+end);
	List<Integer> temp=service.demandReportingDb(start, end);
		return temp;
	}
	
	//this handler method handle the pie chart click event
	//and display all the employees whose managerid is null
	
	@GetMapping(value = "/benchEmployeeDetails")
	@ResponseBody
	public List<BenchEmployee> getDetails()
	{
		return service.getBenchEmployee();       
	}
	
	
	//this handler method is used to fullfill the demand manager request
	//by providing managerid to benchemployee
	@PostMapping(path="/deployEmployee" ,produces = "application/json" , consumes = "application/json")
	public void deployEmployees(@RequestBody List<String> employees) throws ProgramException
	{
		
		service.deployService(employees);
	}
	
	
	

	
	
	
	
	
	
	
	
	//when super admin log in and click button
	//this controller return all resource manager details which get displayed in dashboard
//	@GetMapping
	
	
	

}
