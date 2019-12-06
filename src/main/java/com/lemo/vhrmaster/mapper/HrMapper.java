package com.lemo.vhrmaster.mapper;

import com.lemo.vhrmaster.bean.Hr;

public interface HrMapper {

    Hr loadUserByUsername(String username);

    String getPasswordByUserName(String username);
}
