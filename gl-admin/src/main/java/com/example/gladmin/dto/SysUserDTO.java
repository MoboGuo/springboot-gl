package com.example.gladmin.dto;

import lombok.Data;

@Data
public class SysUserDTO {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;
}
