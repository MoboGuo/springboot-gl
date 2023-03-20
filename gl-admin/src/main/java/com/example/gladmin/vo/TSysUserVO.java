package com.example.gladmin.vo;

import com.example.gladmin.domain.TSysUser;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author mobo
 */
@Data
public class TSysUserVO {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;
    public TSysUserVO(TSysUser tSysUser) {
        BeanUtils.copyProperties(tSysUser,this);
    }
}
