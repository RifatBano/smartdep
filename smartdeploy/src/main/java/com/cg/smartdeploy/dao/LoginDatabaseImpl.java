package com.cg.smartdeploy.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.smartdeploy.entity.BenchEmployee;
import com.cg.smartdeploy.entity.DemandTable;
import com.cg.smartdeploy.entity.ManagerMaster;
import com.cg.smartdeploy.exception.ErrorMessages;
import com.cg.smartdeploy.exception.ProgramException;

@Repository
@Transactional
public class LoginDatabaseImpl implements LoginDatabase{

	@PersistenceContext
	private EntityManager entityManager;
	
	static String currentManager="";
	
	public ManagerMaster loginDb(ManagerMaster employees) throws ProgramException {
		System.out.println(employees.getManagerId());
		System.out.println(employees.getManagerPassword());
		
		ManagerMaster newMaster=entityManager.find(ManagerMaster.class, employees.getManagerId());
		if(newMaster==null)
			throw new ProgramException(ErrorMessages.MESSAGE17);
		System.out.println(newMaster.getManagerPassword());
		if(newMaster.getManagerPassword().equals(employees.getManagerPassword()))
			{
			currentManager=employees.getManagerId();
			System.out.println(currentManager);
			return newMaster;
			}
		else
			throw new ProgramException(ErrorMessages.MESSAGE17);
		
		
		
	}

	public List<Integer> demandReportingDbDao(LocalDate startDate, LocalDate endDate) throws ProgramException {
	
		System.out.println(startDate);
		int totalRaised=0;
		int totalFullfill=0;
		TypedQuery<DemandTable> query1=entityManager.createQuery("SELECT demandTable  FROM DemandTable demandTable WHERE managerId=:mid AND demandTable.requestDate>=:startd AND demandTable.requestDate<=:endd",DemandTable.class);
		query1.setParameter("mid",currentManager);
		query1.setParameter("startd",startDate);
		query1.setParameter("endd",endDate);
		System.out.println("hjgh");
		List<DemandTable> temp=query1.getResultList();
		
		for(int i=0;i<temp.size();i++)
		{
			
			totalRaised=totalRaised+temp.get(i).getRequestRaised();
			totalFullfill=totalFullfill+temp.get(i).getRequestFullfill();
		}
		System.out.println("Total request raised by "+currentManager);
		System.out.println(totalRaised+" "+totalFullfill);


		List<Integer> total=new ArrayList<Integer>();
		total.add(totalRaised);
		total.add(totalFullfill);
	      System.out.println(total);

	      return total;
	}

	@Override
	public List<BenchEmployee> getBenchEmployeeDetails() {
		
		Query query=entityManager.createQuery("select benchEmployee from BenchEmployee benchEmployee where managerId IS NULL");
		List<BenchEmployee> temp=query.getResultList();
		return temp;
	}

	@Override
	public void deployServiceDao(List<String> list) throws ProgramException  {
		
		for(int i=0;i<list.size();i++)
		{
			BenchEmployee benchEmployee=entityManager.find(BenchEmployee.class,list.get(i));
			if(benchEmployee==null)
				throw new ProgramException(ErrorMessages.MESSAGE17);
			benchEmployee.setManagerId(currentManager);
			
		}
		
	}

}
