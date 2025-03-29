package com.vechicle.breakdown.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechicle.breakdown.exception.UserNotFoundException;
import com.vechicle.breakdown.model.Users;
import com.vechicle.breakdown.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
    private UserRepository userRepository;

    public Users registerUser(Users user) {
        return userRepository.save(user);
    }

    public Users loginUser(String email, String password) {
        Users user = userRepository.findByEmail(email);
        if (user == null) throw new UserNotFoundException("User not found");
        return user.getPassword().equals(password) ? user : null;
    }

}
