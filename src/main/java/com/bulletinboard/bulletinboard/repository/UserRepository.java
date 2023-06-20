package com.bulletinboard.bulletinboard.repository;

import com.bulletinboard.bulletinboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
