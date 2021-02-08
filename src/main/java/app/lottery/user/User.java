package app.lottery.user;

import lombok.*;

import javax.persistence.*;

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
    private String userMail;

    public User(final String userMail) {
        this(null, userMail);
    }

}