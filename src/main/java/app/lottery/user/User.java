package app.lottery.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Armazena as informações do usuário.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id 
    @GeneratedValue
    private Long id;
    
    @Email
    @NotBlank
    @NotNull
    private String userMail;

    public User(final String userMail) {
        this(null, userMail);
    }
}