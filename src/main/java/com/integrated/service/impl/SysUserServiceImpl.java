package com.integrated.service.impl;

import com.integrated.dao.SysUserDao;
import com.integrated.model.SysUser;
import com.integrated.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Author Meliodas
 * @Date 2019/1/13 9:30
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser findSysUserByAccount(String account) {
        return sysUserDao.findAllByAccount(account);
    }
}
