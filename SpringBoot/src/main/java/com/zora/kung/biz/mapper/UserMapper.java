package com.zora.kung.biz.mapper;

import com.zora.kung.biz.vo.UserVo;
import com.zora.kung.config.MyBatisRepository;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Zora on 2017/1/5.
 */
@Repository("userMapper")
@MyBatisRepository
public interface UserMapper {

    @Select("select * from view_test_form where id = #{id}")
    UserVo findUserVoById(String id);

}
