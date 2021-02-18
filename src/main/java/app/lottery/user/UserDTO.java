package app.lottery.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

/**
 * Filtragem do email.
 */
@Value
@NotNull
public class UserDTO {
    @Email(message = "E-mail válido requerido.")
    @NotBlank(message = "Digite um e-mail.")
    private String userMail;
}