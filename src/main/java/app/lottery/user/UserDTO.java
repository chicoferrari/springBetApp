package app.lottery.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

/**
 * Filtragem do email.
 */
 @Value
public class UserDTO {

    @NotNull
    @NotBlank
    @Email 
    private String userMail;

}