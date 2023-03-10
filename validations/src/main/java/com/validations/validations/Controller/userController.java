package com.validations.validations.Controller;

import com.validations.validations.Entity.User;
import com.validations.validations.Payload.userClone;
import com.validations.validations.Service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {

    @Autowired
    private userService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody userClone userClone){
        log.info("Entering controller layer for createUser");
        User user = userService.createUser(userClone);
        log.info("Return from controller layer");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
