package com.vechicle.breakdown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vechicle.breakdown.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	 Users findByEmail(String email);
}
