package com.example.warehouse.service.impl;
import com.example.warehouse.dao.UserMapper;
import com.example.warehouse.entity.User;
import com.example.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
    UserMapper userMapper;
    @Override
    public User getByName(String username) {
        return userMapper.getByName(username);
    }

    @Override
    public List<User> getUserList(HashMap<String, Object> map) {
       return userMapper.getUserList(map);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.addUser(user) > 0;
    }

    @Override
    public Boolean deleteUser(int id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public int getNum(String username) {
        return userMapper.getNum(username);
    }

}
