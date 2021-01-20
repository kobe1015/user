package com.toris.user.model.entity.repository;

import com.toris.user.model.entity.kobe.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
