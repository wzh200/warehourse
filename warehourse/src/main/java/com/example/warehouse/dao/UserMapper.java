package com.example.warehouse.dao;

import com.example.warehouse.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User getByName(String username);

    List<User> getUserList(HashMap<String, Object> map);

    int updateUser(User user);

    int addUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);

    int getNum(String username);
}
