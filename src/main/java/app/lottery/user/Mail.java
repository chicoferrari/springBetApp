package app.lottery.user;

import lombok.*;

/**
 * Identifica o usuário.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Mail {

    private Long id;
    private String alias;
    private String email;

    public Mail(final String email) {
        this(null, null, email);
    }
}