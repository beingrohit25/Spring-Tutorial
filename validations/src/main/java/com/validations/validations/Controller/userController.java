package com.validations.validations.Controller;

import com.validations.validations.Entity.User;
import com.validations.validations.Payload.ApiResponse;
import com.validations.validations.Payload.userClone;
import com.validations.validations.Service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {

    @Autowired
    private userService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody userClone userClone){
        User user = userService.createUser(userClone);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId){
        User user = userService.getById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ApiResponse deleteUser(@PathVariable("id") Long userId){
        this.userService.deleteUser(userId);
        return new ApiResponse("Deleted Successfully", true);
    }

}
