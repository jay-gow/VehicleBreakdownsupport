package com.vechicle.breakdown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechicle.breakdown.model.Breakdown;
import com.vechicle.breakdown.repository.BreakdownRepository;


@Service
public class BreakdownService {

	
	 @Autowired
	    private BreakdownRepository breakdownRepository;

	    public Breakdown addBreakdown(Breakdown breakdown) {
	        return breakdownRepository.save(breakdown);
	    }

	    public List<Breakdown> getUserBreakdowns(Long userId) {
	        return breakdownRepository.findByUserId(userId);
	    }
}
