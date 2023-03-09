package com.validations.validations.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class userClone {

    @Size(min = 2, max = 20, message = "Please Enter correct name")
    private String name;

    @Email(message = "Enter correct email")
    private String mobile;

    @Size(min = 2, max = 20, message = "Please Enter correct name")
    private String city;

    @Min(2)
    @Max(20)
    private Integer age;

    private LocalDate dateCreated;
    private Date dateUpdated;
}
