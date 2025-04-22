package com.garby.dashboard.repositories;

import com.garby.dashboard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}