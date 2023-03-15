package com.example.gladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.gladmin.dao.MpTestDao;
import com.example.gladmin.domain.TSysUser;
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

    public List<TSysUser> getUserList() {
        return mpTestDao.selectList(null);
    }

    public TSysUser getUserByName(String userName) {
        LambdaQueryWrapper<TSysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TSysUser::getUsername, userName);
        return mpTestDao.selectOne(lambdaQueryWrapper);
    }

}
