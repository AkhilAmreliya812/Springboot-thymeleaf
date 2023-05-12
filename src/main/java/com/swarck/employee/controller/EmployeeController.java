package com.swarck.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swarck.employee.model.Employee;
import com.swarck.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("listEmployee", employeeService.getEmployees());

		
		//List<> roles = (List<Role>) roleRepository.findAll();
		//mav.addObject("allRoles", roles);
		
		return "index";
	}
	
	@GetMapping("/addNewEmployee")
	public ModelAndView addEmployee() {
		Employee employee = new Employee();
		ModelAndView mav = new ModelAndView("new_Employee");
		mav.addObject("employee", employee);
		
		//model.addAttribute("employee", employee);
		return mav;
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/home";
	}
	
	@GetMapping("/update_employee/{id}") 
	public ModelAndView editStudent(@PathVariable(value = "id") long id) {
		Employee employee = employeeService.getEmpEmployeeById(id);
		//Employee employee = new Employee();
		ModelAndView mav = new ModelAndView("update_employee");
		mav.addObject("employee", employee);
		
		//model.addAttribute("employee", employee);
		return mav;
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/home";
	}
}
