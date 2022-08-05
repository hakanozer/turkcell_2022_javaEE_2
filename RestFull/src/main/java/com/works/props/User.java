package com.works.props;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.*;

@Data
public class User {

    @NotNull(message = "name NotNull")
    @NotEmpty(message = "name NotEmpty")
    @Length(min = 2, max = 40, message = "name min = 1, max = 40")
    private String name;

    @NotNull(message = "surname NotNull")
    @NotEmpty(message = "surname NotEmpty")
    @Length(min = 2, max = 40, message = "surname min = 1, max = 40")
    private String surname;

    @Min(value = 18, message = "age min 18")
    @Max(value = 70, message = "age max 70")
    private int age;

    @NotNull(message = "email NotNull")
    @NotEmpty(message = "email NotEmpty")
    @Length(min = 2, max = 40, message = "email min = 5, max = 100")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "E-Mail format fail")
    private String email;

}
