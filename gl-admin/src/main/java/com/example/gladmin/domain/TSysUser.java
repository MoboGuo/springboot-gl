package com.example.gladmin.domain;

import lombok.Data;

/**
 * @author lkle
 */
@Data
public class TSysUser {

    private String id;
    private String username;
    private String password;
    private String nickname;
    private int depId;
    private String posId;

}
