package com.example.gladmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gladmin.domain.SysUser;

/**
 * @author Mobo
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * Description: 根据用户名获取用户service
     * date: 2023/3/24 11:39
     * @param userName
     * @return com.example.gladmin.domain.SysUser
     */
    SysUser getUserByName(String userName);
}
