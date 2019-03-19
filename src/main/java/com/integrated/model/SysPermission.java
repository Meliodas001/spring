package com.integrated.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SysPermission
 * @Description TODO
 * @Author Meliodas
 * @Date 2019/1/13 8:49
 * @Version 1.0
 */
@Entity
public class SysPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Integer id;//主键.
    @Setter @Getter
    private String name;//名称.
    @Setter @Getter
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]
    @Setter @Getter
    private String url;//资源路径.
    @Setter @Getter
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    @Setter @Getter
    private Long parentId; //父编号
    @Setter @Getter
    private String parentIds; //父编号列表
    @Setter @Getter
    private Boolean available = Boolean.FALSE;

    @Setter @Getter
    @ManyToMany
    @JoinTable(name="SysRolePerm",joinColumns={@JoinColumn(name="permId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles = new ArrayList<>();
}
