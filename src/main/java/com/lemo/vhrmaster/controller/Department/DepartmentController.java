package com.lemo.vhrmaster.controller.Department;

import com.lemo.vhrmaster.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/getAlldepartment")
    public List<Map<String,Object>> getAlldepartment(){
      return departmentService.getAlldepartment();
    }
}
