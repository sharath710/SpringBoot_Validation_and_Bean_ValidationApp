package com.app.validationexception.handing.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class UserRequest {

    @NotNull(message = "username should not be empty")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$",message="invalid mobile number entered")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
