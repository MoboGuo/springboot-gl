package com.example.gladmin.dto;

import com.example.gladmin.domain.TSysUser;
import lombok.Data;

@Data
public class TSysUserDTO {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;
}
