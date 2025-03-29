package com.vechicle.breakdown.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vechicle.breakdown.model.Breakdown;

public interface BreakdownRepository extends JpaRepository<Breakdown, Long> {
	List<Breakdown> findByUserId(Long userId);
}
