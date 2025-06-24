package com.example.EmployeeMGMT.Controller;


import com.example.EmployeeMGMT.DTO.EmployeesDTO;
import com.example.EmployeeMGMT.Entity.Employees;
import com.example.EmployeeMGMT.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
 // add employee in DB
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody Employees emp){
        employeeService.add(emp);
        return ResponseEntity.status(200).body(emp);
    }

    //get all employee
    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployee(){
        List<Employees> ans=employeeService.getall();
        if(ans==null){
            return ResponseEntity.status(404).body("No content found");
        }
        return ResponseEntity.status(200).body(ans);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        Employees emp=employeeService.getempbyid(id);
        if(emp==null){
            ResponseEntity.status(404).body("No Employee with id "+id+" found.");
        }
        return ResponseEntity.status(200).body(emp);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int id){
        employeeService.deleteempbyid(id);
        return ResponseEntity.status(200).body("Employee deleted");
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateemployeebyid(@PathVariable int id,@RequestBody EmployeesDTO emp){
        employeeService.updateemployee(id,emp);
        return ResponseEntity.status(200).body("employee details updated");
    }
}
