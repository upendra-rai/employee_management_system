package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String ViewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind form data
		Employee employee =  new Employee();
		model.addAttribute("employee", employee);
		return "new_employee"; 
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id")long id, Model model) {
		// Get The Employee From Service 
		Employee  employee = employeeService.getEmployeeById(id);
		
		// set employee as model Attribute  to pre ppulated the Form 
		model.addAttribute("employee",employee);
		return "update";
		  
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id")long id ) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
}
