package com.example.EmployeeMGMT.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class EmployeesDTO {

    private String name;
    private String email;
    private  String designation;
}
