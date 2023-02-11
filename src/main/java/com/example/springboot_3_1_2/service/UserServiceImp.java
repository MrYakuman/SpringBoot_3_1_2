package com.example.springboot_3_1_2.service;

import com.example.springboot_3_1_2.model.User;
import com.example.springboot_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

    public User show(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


    @Transactional
    public void update(User user) {
        userRepository.update(user.getName(), user.getLastName(), user.getAge(), user.getId());
    }
}
