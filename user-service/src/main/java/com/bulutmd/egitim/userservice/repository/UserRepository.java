package com.bulutmd.egitim.userservice.repository;


import com.bulutmd.egitim.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
