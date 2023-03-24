package com.example.gladmin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mobo
 */
@Data
@ApiModel(value="SysPermission对象", description="权限菜单信息")
public class SysPermission implements Serializable {
    private String id;

    private String name;

    private String descripion;

    private String url;

    private Integer isBlank;

    private String pid;

    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private Integer visible;

    @TableField(exist = false)
    private Integer childCount;
}
