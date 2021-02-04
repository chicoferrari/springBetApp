package app.lottery.user;

import lombok.*;

/**
 * RASCUNHO Armazena a identificação do usuário
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Mail {

    private Long id;
    private String alias;
}