package com.example.gladmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gladmin.domain.SysMenu;
import com.example.gladmin.domain.SysPermission;

import java.util.List;

public interface SysPermissionService extends IService<SysPermission> {


    /**
     * Description: 获取菜单list
     * date: 2023/3/24 16:32
     * @param userid
     * @return java.util.List<com.example.gladmin.domain.SysMenu>
     */
    List<SysMenu> getSysMenus(String userid);
}
