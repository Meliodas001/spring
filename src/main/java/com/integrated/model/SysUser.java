package com.integrated.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author Meliodas
 * @Date 2019/1/13 8:32
 * @Version 1.0
 */
@Entity
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Integer id;
    @Setter @Getter
    @Column(unique =true)
    private String account;//帐号
    @Setter @Getter
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    @Setter @Getter
    private String password; //密码;
    @Setter @Getter
    private String salt;//加密密码的盐
    @Setter @Getter
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    @Setter @Getter
    private Date createTime; //创建时间

    @Setter @Getter
    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList = new ArrayList<>();// 一个用户具有多个角色

    public String getCredentialsSalt() {
        return this.account + this.salt;
    }
}
