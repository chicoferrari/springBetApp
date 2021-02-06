package app.lottery.user;

import lombok.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Filtragem do email.
 */
@Value
public class MailDTO {

    @NotBlank
    @Email 
    String emailAddress;

}