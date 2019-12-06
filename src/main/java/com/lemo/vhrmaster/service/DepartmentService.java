package com.lemo.vhrmaster.service;

import com.lemo.vhrmaster.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Map<String,Object>> getAlldepartment(){
        return departmentMapper.getAlldepartment();
    }
}
