package com.zbz.boot.format.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbz.boot.format.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User getUser(Integer id);
    User  getByUserName(String name);
}
