package com.example.gladmin.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.example.gladmin.domain.SysUser;
import org.springframework.beans.BeanUtils;

public class SaTokenUtil {
    /**
     * 获取登录用户model
     */
    public static SysUser getUser() {

        Object object = StpUtil.getSession().get("user");
        if (object != null) {
            SysUser SysUser = new SysUser();
            BeanUtils.copyProperties(SysUser, object);
            return SysUser;
        }
        return null;
    }

    /**
     * set用户
     */
    public static void setUser(SysUser user) {
        StpUtil.getSession().set("user", user);
    }

    /**
     * 获取登录用户id
     */
    public static String getUserId() {
        return StpUtil.getLoginIdAsString();
    }

    /**
     * 获取登录用户name
     */
    public static String getLoginName() {
        SysUser SysUser = getUser();
        if (SysUser == null) {
            throw new RuntimeException("用户不存在！");
        }
        return SysUser.getUsername();
    }

    /**
     * 获取登录用户ip
     */
    public static String getIp() {
        return StpUtil.getTokenSession().getString("login_ip");
    }

    /**
     * 判断是否登录
     */
    public static boolean isLogin() {
        return StpUtil.isLogin();
    }
}
