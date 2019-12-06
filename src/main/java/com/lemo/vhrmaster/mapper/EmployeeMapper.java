package com.lemo.vhrmaster.mapper;

import com.lemo.vhrmaster.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

     List<Map<String,Object>> querySalaryAll(Integer start, Integer pagesize,String name,String departmentname);

     Long getcountEmployee(String name,String departmentname);
}
