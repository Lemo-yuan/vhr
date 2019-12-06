package com.lemo.vhrmaster.service;

import com.lemo.vhrmaster.bean.Hr;
import com.lemo.vhrmaster.bean.Menu;

import com.lemo.vhrmaster.mapper.HrMapper;
import com.lemo.vhrmaster.mapper.MenuMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    HrMapper hrMapper;

//    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        //Subject currentUser = SecurityUtils.getSubject();
        //currentUser.getPrincipals();
        // Long currentUserId = Long.valueOf(hr.getId());
        String  username =(String)SecurityUtils.getSubject().getPrincipal();
        return menuMapper.getMenusByHrId(hrMapper.loadUserByUsername(username).getId());
        //return null;
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
