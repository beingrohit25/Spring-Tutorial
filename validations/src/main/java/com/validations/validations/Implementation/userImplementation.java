package com.validations.validations.Implementation;

import com.validations.validations.Entity.User;
import com.validations.validations.Payload.userClone;
import com.validations.validations.Repository.userRepository;
import com.validations.validations.Service.userService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class userImplementation implements userService {

//    @Autowired
//    private userRepository userRepository;

    private final userRepository userRepository;

    @Override
    public User createUser(userClone userClone) {

        log.info("Entering in Service layer for createUser");
        log.warn("Converting clone to Entity");

        User user = cloneToEntity(userClone);
        user.setDateCreated(LocalDate.now());

        log.warn("Sending data to Repository");

        User savedUser = userRepository.save(user);

        log.warn("Return createUser from service layer");

        return savedUser;
    }

    @Override
    public User getById(Long userId) {
        return null;
    }

    /**
     * Method 1
     * @param userClone
     * @return
     */
    public User cloneToEntity(userClone userClone){
        User user = new User();
        user.setName(userClone.getName());
        user.setCity(userClone.getCity());
        user.setEmail(userClone.getEmail());
        user.setAge(userClone.getAge());
        return user;
    }

    public userClone entityToCLone(User user){
        userClone userClone = new userClone();
        return userClone;
    }
}