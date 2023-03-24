package com.example.gladmin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * 返回给前端的数据实体
 * @author mobo
 */
@Data
@AllArgsConstructor
public class SysMenu {
    /**
     * 菜单编号
     * */
    private String id;

    /**
     * 父节点
     * */
    private String parentId;

    /**
     * 标题
     * */
    private String title;

    /**
     * 菜单类型 类型   0：目录   1：菜单   2：按钮
     * */
    private Integer type;

    /**
     * 打 开 类 型 _iframe 0 _blank 1
     * */
    private Integer openType;

    /**
     * 图标
     * */
    private String icon;

    /**
     * 跳转路径
     * */
    private String href;

    /**
     * 子菜单
     * */
    private List<SysMenu> children = new ArrayList<>();


    /**
     * 计算列 提供给前端组件
     * */
    private static String checkArr = "0";
}