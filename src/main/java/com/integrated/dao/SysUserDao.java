package com.integrated.dao;

import com.integrated.model.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName SysUserDao
 * @Description TODO
 * @Author Meliodas
 * @Date 2019/1/13 9:22
 * @Version 1.0
 */
public interface SysUserDao extends CrudRepository<SysUser, Long> {

    /**
     * 通过用户账号查询用户
     * @param account
     * @return
     */
    SysUser findAllByAccount(String account);
}
