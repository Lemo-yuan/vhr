package com.lemo.vhrmaster.service;

import com.lemo.vhrmaster.bean.Hr;
import com.lemo.vhrmaster.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HrService {

    @Autowired
    private HrMapper hrMapper;

    public Hr loadUserByUsername(String username){
        return hrMapper.loadUserByUsername(username);
    }

    public String getPasswordByUserName(String username){
        return hrMapper.getPasswordByUserName(username);
    }
}
