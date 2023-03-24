package com.example.gladmin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.gladmin.mapper.MpTestDao;
import com.example.gladmin.domain.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lkle
 */
@Service
public class MpTestService {

    @Resource
    private MpTestDao mpTestDao;

    public List<SysUser> getUserList() {
        return mpTestDao.selectList(null);
    }

    public SysUser getUserByName(String userName) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, userName);
        return mpTestDao.selectOne(lambdaQueryWrapper);
    }

}
