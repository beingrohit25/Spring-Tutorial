package com.validations.validations.Implementation;

import com.validations.validations.Entity.User;
import com.validations.validations.Exceptions.ApiException;
import com.validations.validations.Exceptions.detailsNotFoundException;
import com.validations.validations.Payload.userClone;
import com.validations.validations.Repository.userRepository;
import com.validations.validations.Service.userService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        User user = cloneToEntity(userClone);
        user.setDateCreated(LocalDate.now());
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User getById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException("User not found with UserID " + userId, false, HttpStatus.BAD_REQUEST));
        return user;
    }

    @Override
    public userClone updateUser(userClone userClone) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new detailsNotFoundException("User", "userId", userId));
        userRepository.delete(user);
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