package com.example.springboot_3_1_2.service;

import com.example.springboot_3_1_2.model.User;
import com.example.springboot_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User show(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }
}
