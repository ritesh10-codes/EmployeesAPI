package com.example.EmployeeMGMT.Service;

import com.example.EmployeeMGMT.DTO.EmployeesDTO;
import com.example.EmployeeMGMT.Entity.Employees;

import com.example.EmployeeMGMT.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    public void add(Employees emp) {
       employeeRepository.save(emp);
    }

    public List<Employees> getall() {
        return employeeRepository.findAll();
    }

    public Employees getempbyid(int id) {
        return employeeRepository.getById(id);
    }

    public void deleteempbyid(int id) {
        employeeRepository.deleteById(id);
    }

    public void updateemployee(int id, EmployeesDTO dto) {

        //exception mandatory
        Employees emp = employeeRepository.findById(id).orElseThrow();

        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setDesignation(dto.getDesignation());

        employeeRepository.save(emp);


    }
}
