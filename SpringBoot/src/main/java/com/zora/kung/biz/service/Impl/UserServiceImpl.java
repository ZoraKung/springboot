package com.zora.kung.biz.service.Impl;

import com.zora.kung.biz.mapper.UserMapper;
import com.zora.kung.biz.service.UserService;
import com.zora.kung.biz.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Created by Zora on 2017/1/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public UserVo findUserVoById(String id) {
        UserVo vo = userMapper.findUserVoById(id);
        if (vo == null) {
            vo = new UserVo();
        }
        return vo;
    }

}
