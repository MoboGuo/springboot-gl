package com.example.gladmin.domain;

import com.example.gladmin.dto.TSysUserDTO;
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
public class TSysUser implements Serializable {

    private String id;

    @ApiModelProperty(value = "姓名")
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;

    public TSysUser(TSysUserDTO tSysUserDTO) {
        BeanUtils.copyProperties(tSysUserDTO, this);
    }
}
