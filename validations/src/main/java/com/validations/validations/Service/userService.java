package com.validations.validations.Service;

import com.validations.validations.Entity.User;
import com.validations.validations.Payload.userClone;

public interface userService {
    public User createUser(userClone userClone);
    User getById(Long userId);
}
