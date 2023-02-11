package com.example.springboot_3_1_2.repository;


import com.example.springboot_3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("update User u set u.name = ?1, u.lastName = ?2, u.age = ?3 where u.id = ?4")
    public void update(String firstname, String lastname, Long age, Long id);
}
