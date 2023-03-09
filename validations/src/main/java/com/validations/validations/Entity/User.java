package com.validations.validations.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String mobile;
    private String city;
    private Integer age;
    private LocalDate dateCreated;
    private Date dateUpdated;
}
