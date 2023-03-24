package com.example.gladmin.domain;

import com.example.gladmin.dto.SysUserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author lkle
 */
@Data
@ApiModel(value="TSysUser对象", description="用户信息")
public class SysUser implements Serializable {

    private String id;

    @ApiModelProperty(value = "姓名")
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;

    public SysUser(){};

    public SysUser(SysUserDTO sysUserDTO) {
        BeanUtils.copyProperties(sysUserDTO, this);
    }
}
