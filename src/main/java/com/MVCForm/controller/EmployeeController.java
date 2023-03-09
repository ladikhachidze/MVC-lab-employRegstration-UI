package com.MVCForm.controller;


import com.MVCForm.bootstrap.DataGenerator;
import com.MVCForm.model.Employee;
import com.MVCForm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;  //dependency injection

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());
        return "employee/employee-create";
    }


    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "/employee/employee-create";
        }


        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";   // With redirect we are using endpoints
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "employee/employee-list";   // Without redirect we are using html file paths
    }

}
