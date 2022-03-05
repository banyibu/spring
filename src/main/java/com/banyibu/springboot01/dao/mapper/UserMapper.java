package com.banyibu.springboot01.dao.mapper;

import com.banyibu.springboot01.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //注解表示是一个mybatis的mapper
public interface UserMapper {

    List<User> queryList();

    User queryById();

    int updateUser(User user);

    int deleteUser(int id);
}
