package com.MVCForm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


            // validation
 //   @NotNull ---> field should not be null
 //  @NotBlank ---> field should not be blank
 //   @NotEmpty ---> field should not be empty

//    @NotNull -> @NotNull
//    @NotEmpty -> @NotNull + @NotEmpty
//    @NotBlank -> @NotNull + @NotEmpty + @NotBlank

    @NotBlank
    @Size(max = 12, min = 2)
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;


}
