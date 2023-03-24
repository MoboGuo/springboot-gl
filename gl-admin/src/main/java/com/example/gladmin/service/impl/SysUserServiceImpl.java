package com.example.gladmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gladmin.domain.SysUser;
import com.example.gladmin.mapper.SysUserMapper;
import com.example.gladmin.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mobo
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Override
    public SysUser getUserByName(String userName) {
        return baseMapper.getUserByName(userName);
    }
}
