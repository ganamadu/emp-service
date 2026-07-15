package com.emp.service;

import com.emp.controller.EmpController;
import com.emp.core.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
public class EmpService {
    private static final Logger log =
            LoggerFactory.getLogger(EmpController.class);



    public Emp getEmpById(Integer id) {
        return empList()
                .get(0);
    }


    public Emp getEmpByFilter(String filterName, String filterValue) {
        log.info("Received request filter={} value={}", filterName, filterValue);
        Map<String, Predicate<Emp>> filters = Map.of(
                "empno", e -> e.empno() == Integer.parseInt(filterValue),
                "ename", e -> e.ename().equalsIgnoreCase(filterValue),
                "dept", e -> e.deptNo() == Integer.parseInt(filterValue),
                "salary", e -> e.sal() == Double.parseDouble(filterValue)
        );
        Predicate<Emp> predicate = filters.get(filterName.toLowerCase());
        if (predicate == null) {
            throw new IllegalArgumentException("Invalid filter: " + filterName);
        }

        Emp emp = empList().stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);

        if (emp == null) {
            log.warn("Employee not found");
        } else {
            log.info("Employee found {}", emp);
        }

        return emp;
    }





    public List<Emp> empList() {

        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(1001, "Ganapathi", 90000, 10));
        empList.add(new Emp(1002, "Srilatha", 80000, 20));
        empList.add(new Emp(1003, "Thaneesh", 70000, 30));
        empList.add(new Emp(1004, "Rishith", 60000, 40));

        return empList;

    }

}
