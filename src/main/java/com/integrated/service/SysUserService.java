package com.integrated.service;

import com.integrated.model.SysUser;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author Meliodas
 * @Date 2019/1/13 9:26
 * @Version 1.0
 */
public interface SysUserService {
    /**
     * 通过用户查找信息
     * @param account
     * @return
     */
    SysUser findSysUserByAccount(String account);
}
