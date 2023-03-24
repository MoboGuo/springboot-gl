package com.example.gladmin.vo;

import com.example.gladmin.domain.SysUser;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author mobo
 */
@Data
public class SysUserVO {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;
    public SysUserVO(SysUser sysUser) {
        BeanUtils.copyProperties(sysUser,this);
    }
}
