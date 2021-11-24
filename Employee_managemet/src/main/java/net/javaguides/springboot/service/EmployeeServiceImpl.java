package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		
	}


	@Override
	public void saveEmployee(Employee employee) {
		 this.employeeRepository.save(employee);
		
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> Optional= employeeRepository.findById(id);
		Employee employee = null;
		if(Optional.isPresent()) {
			employee = Optional.get();
			
		}else {
			throw new RuntimeException("Employee Not Found for id ::"+id);
		}
		return employee;
		
	}


	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}

}
