package com.lemo.vhrmaster.service;

import com.lemo.vhrmaster.bean.Employee;
import com.lemo.vhrmaster.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalaryService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Map<String,Object>> queryemployeeSalary(Integer page,Integer pagesize,String name,String departmentname){
        Integer start =(page-1)* pagesize;
        return employeeMapper.
                querySalaryAll(start,pagesize,name,departmentname);
    }

    public Long getcountEmployee(String name,String departmentname){
        return employeeMapper.getcountEmployee(name,departmentname);
    }
}
