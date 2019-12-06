package com.lemo.vhrmaster.controller;

import com.lemo.vhrmaster.bean.Menu;
import com.lemo.vhrmaster.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/Menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/loadmenu")
    public List<Menu> loadMenu(){
        List<Menu> list =menuService.getMenusByHrId();
        System.out.println("================"+list);
        return list;
    }
}
