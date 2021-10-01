package com.nibblebytes.postgresql.repository;

import com.nibblebytes.postgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {

}
