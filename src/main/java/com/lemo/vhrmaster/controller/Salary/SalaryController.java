package com.lemo.vhrmaster.controller.Salary;

import com.lemo.vhrmaster.bean.Employee;
import com.lemo.vhrmaster.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/queryemployeeSalary")
    public Map<String,Object> queryemployeeSalary(
            @RequestParam Integer page,
            @RequestParam Integer pagesize,@RequestParam String name,@RequestParam String departmentname){
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> list = salaryService.queryemployeeSalary(page,pagesize,name,departmentname);
        Long count = salaryService.getcountEmployee(name,departmentname);
        map.put("salary",list);
        map.put("sumtotal",count);
        return map;
    }

}
