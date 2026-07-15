package com.emp.controller;

import com.emp.core.Emp;
import com.emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    private static final Logger log =
            LoggerFactory.getLogger(EmpController.class);

    private EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping
    public List<Emp> empList(){
        log.info("Fetching all employees");
        return empService.empList();
    }

    @GetMapping("/{id}")
    public Emp getEmpById(@PathVariable Integer id) {
        log.info("Fetching employee with id={}", id);
        return empService.getEmpById(id);
    }

    @GetMapping("/{filterName}/{filterValue}")
    public Emp getEmp(@PathVariable String filterName,
                      @PathVariable String filterValue) {

        log.info("Received request filter={} value={}", filterName, filterValue);

        return empService.getEmpByFilter(filterName, filterValue);
    }


}
