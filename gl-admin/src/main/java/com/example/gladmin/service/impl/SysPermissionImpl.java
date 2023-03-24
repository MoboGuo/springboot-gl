package com.example.gladmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gladmin.domain.SysMenu;
import com.example.gladmin.domain.SysPermission;
import com.example.gladmin.mapper.SysPermissionMapper;
import com.example.gladmin.service.SysPermissionService;
import com.example.gladmin.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mobo
 */
@Service
public class SysPermissionImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Override
    public List<SysMenu> getSysMenus(String userid) {
        List<SysPermission> menuList =  this.list();
        return getSysMenus(menuList,"0");
    }

    /**
     * 递归查询权限
     */
    private List<SysMenu> getSysMenus(List<SysPermission> treeList, String parentId) {
        List<SysMenu> menuList = new ArrayList<SysMenu>();
        if (StringUtils.isNotNull(parentId) && treeList != null && treeList.size() > 0) {
            List<SysMenu> childList = null;
            for (SysPermission sysPermission : treeList) {
                if (sysPermission.getPid().equals(parentId)) {
                    if (sysPermission.getChildCount() != null && sysPermission.getChildCount() > 0) {
                        childList = getSysMenus(treeList, sysPermission.getId());
                    }
                    SysMenu sysMenu = new SysMenu(sysPermission.getId(), sysPermission.getPid(), sysPermission.getName(),
                            sysPermission.getType(), sysPermission.getIsBlank(), sysPermission.getIcon(), sysPermission.getUrl(), childList);
                    menuList.add(sysMenu);
                    childList = null;
                }
            }
        }
        return menuList;
    }
}
