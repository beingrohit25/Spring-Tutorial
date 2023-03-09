package com.validations.validations.Implementation;

import com.validations.validations.Entity.User;
import com.validations.validations.Payload.userClone;
import com.validations.validations.Repository.userRepository;
import com.validations.validations.Service.userService;
import org.springframework.stereotype.Service;

@Service
public class userImplementation implements userService {

//    @Autowired
//    private userRepository userRepository;

    private final userRepository userRepository;

    //Constructor Injection
    public userImplementation(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(userClone userClone) {
        return null;
    }

    @Override
    public User getById(Long userId) {
        return null;
    }
}