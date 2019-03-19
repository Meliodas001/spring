package com.integrated.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author Meliodas
 * @Date 2019/1/13 8:46
 * @Version 1.0
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Integer id; // 编号
    @Setter @Getter
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    @Setter @Getter
    private String description; // 角色描述,UI界面显示使用
    @Setter @Getter
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
    @Setter @Getter
    private Date createTime; //创建时间

    //角色 -- 权限关系：多对多关系;
    @Setter @Getter
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions = new ArrayList<>();

    // 用户 - 角色关系定义;
    @Setter @Getter
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="id")})
    private List<SysUser> userInfos = new ArrayList<>();// 一个角色对应多个用户
}
