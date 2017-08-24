package com.springmvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.DepartmentDao;
import com.springmvc.dao.EmployeeDao;
import com.springmvc.entity.Employee;
@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeDao employeedao;
	@Autowired
	private DepartmentDao departmentDao;
	@RequestMapping("/emps")
	public String list(Map<String,Object> map)
	{
		map.put("employees", employeedao.getAll());
		return "empslist";
	}
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String,Object> map)
	{
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String,Object> map)
	{
		map.put("employee", employeedao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	@RequestMapping(value="/emp",method=RequestMethod.POST) 
	public String save(Employee employee)
	{
		employeedao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.POST)
	public String delete(@PathVariable("id")int id)
	{
		employeedao.delete(id);
		return "redirect:/emps";
	}
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
	        Map<String, Object> map){
	        if(id != null){
	            map.put("employee", employeedao.get(id));
	        }
	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
	public String update(Employee employee)
	{
		employeedao.save(employee);
		return "redirect:/emps";
	}
}
