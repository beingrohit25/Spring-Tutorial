package com.validations.validations.Repository;

import com.validations.validations.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {
}
