package com.example.springboot_3_1_2.service;

import com.example.springboot_3_1_2.model.User;
import com.example.springboot_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    public List<User> showAll();
    public void create(User user);
    public User show(Integer id);
    public void delete(Integer id);
    public void update(User user);
}
