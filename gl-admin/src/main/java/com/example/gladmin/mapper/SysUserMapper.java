package com.example.gladmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gladmin.domain.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author 10782
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * Description: 根据用户名获取用户信息
     * date: 2023/3/24 11:38
     * @param userName
     * @return com.example.gladmin.domain.SysUser
     */
    @Select("select * from sys_user where username = #{userName}")
    SysUser getUserByName(String userName);
}
