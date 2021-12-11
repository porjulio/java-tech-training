package com.gbs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gbs.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String>{
}
