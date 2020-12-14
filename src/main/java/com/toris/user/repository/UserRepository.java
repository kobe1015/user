package com.toris.user.repository;

import com.toris.user.model.entity.seulshine.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

}