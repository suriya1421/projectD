package com.chainsys.application.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org. springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeService
{
	//@RequestMapping(value="/getEmployee",method=RequestMethod.POST)
  @RequestMapping("/employee")
  public String getEmployeeData(@RequestParam(name = "id") String id) {
	  int empId = Integer.parseInt(id);
		Employee emp = EmployeeDao.getEmployeeById(empId);
			return   emp.getFirst_name()+", " + emp.getLast_name()+", " + emp.getJob_id()+", " + emp.getSALARY()+", "
					+ emp.getHire_date()+", " + emp.getEmail() ;
  }
  //@RequestMapping(value="/getAll",method=RequestMethod.POST)

  @RequestMapping("/allemployee")
  public String  getAllEmployee() {
        String out = "";
		List<Employee> emplist =EmployeeDao.getAllEmployees();
		Iterator<Employee> empItr=emplist.iterator();
		while(empItr.hasNext()) {
			Employee emp=empItr.next();
			
			 out+=  emp.getFirst_name()+", " + emp.getLast_name()+", " + emp.getJob_id()+", " + emp.getSALARY()+", "
						+ emp.getHire_date()+", " + emp.getEmail() ;
			}
		return out;
		
  }
  @RequestMapping(value="/newemployee",method=RequestMethod.POST)
  public int addNewEmployee() {
	return 0;
	  
  }
  @RequestMapping(value="/updateemployee",method=RequestMethod.PUT)
  public int modifyEmployee() {
	return 1;
	  
  }
  @RequestMapping(value="/removeemployee",method=RequestMethod.DELETE)
  public int deleteEmployee() {
	return 2;
	  
  }
}