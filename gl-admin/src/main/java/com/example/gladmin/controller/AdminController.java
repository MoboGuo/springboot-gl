package com.example.gladmin.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.example.common.RespResult;
import com.example.gladmin.domain.SysMenu;
import com.example.gladmin.domain.SysUser;
import com.example.gladmin.service.SysPermissionService;
import com.example.gladmin.service.SysUserService;
import com.example.gladmin.utils.SaTokenUtil;
import com.example.gladmin.utils.ServletUtils;
import com.example.gladmin.utils.StringUtils;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysPermissionService sysPermissionService;



    private final String PREFIX = "admin";


    @ApiOperation(value = "请求到登陆界面", notes = "请求到登陆界面")
    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        return "login";
    }


    @ResponseBody
    @PostMapping("/login")
    public RespResult login(SysUser user, String captcha, RedirectAttributes attributes, boolean rememberMe,
                            HttpServletRequest request) {
        Boolean check = false;
        // 获取session中的验证码
        String verCode = (String) request.getSession().getAttribute("captcha");
        //校验验证码
        if (captcha != null && captcha.toLowerCase().equals(verCode.trim().toLowerCase())) {
            //清除验证码
            CaptchaUtil.clear(request);
            check = true;
        }
        if (check) {
            String userName = user.getUsername();
            if (!StpUtil.isLogin()) {
                SysUser findUser = sysUserService.getUserByName(userName);
                if (findUser == null) {
                    log.error("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
                    return RespResult.ERROR(500, "未知账户");
                }
                if (!SaSecureUtil.md5(user.getPassword()).equals(findUser.getPassword())) {
                    log.error("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
                    return RespResult.ERROR(500, "用户名或密码不正确");
                }
                // 校验通过，开始登录
                StpUtil.login(findUser.getId(), rememberMe);
                SaTokenUtil.setUser(findUser);
                StpUtil.getTokenSession().set("ip", ServletUtils.getIP(request));
                return RespResult.SUCC();
            } else {
                if (StringUtils.isNotNull(SaTokenUtil.getUser())) {
                    // 跳转到 get请求的登陆方法
                    return RespResult.SUCC();
                } else {
                    return RespResult.ERROR(500, "未知账户");
                }
            }
        } else {
            return RespResult.ERROR(500, "验证码不正确");
        }
    }

    @ApiOperation(value = "首页", notes = "首页")
    @GetMapping({"/index"})
    public String index(HttpServletRequest request) {
        request.getSession().setAttribute("sessionUserName", SaTokenUtil.getUser().getNickname());
        // 获取公告信息
        // TODO: 2023/3/24 暂时用不到，后续写到这个地方再加
//        List<SysNotice> notices = sysNoticeService.getuserNoticeNotRead(SaTokenUtil.getUser(), 0);
        request.getSession().setAttribute("notices", null);
        return PREFIX + "/index";
    }


    @ApiOperation(value = "获取登录用户菜单栏", notes = "获取登录用户菜单栏")
    @GetMapping("/getUserMenu")
    @ResponseBody
    public List<SysMenu> getUserMenu() {
        List<SysMenu> sysMenus = sysPermissionService.getSysMenus(SaTokenUtil.getUserId());
        return sysMenus;
    }
}
