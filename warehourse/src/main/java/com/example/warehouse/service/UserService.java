package com.example.warehouse.service;

import com.example.warehouse.entity.User;

import java.util.HashMap;
import java.util.List;


public interface UserService {

    User getByName(String username);

    List<User> getUserList(HashMap<String, Object> map);

    Boolean updateUser(User user);

    Boolean addUser(User user);

    Boolean deleteUser(int id);

    int getNum(String username);
}
