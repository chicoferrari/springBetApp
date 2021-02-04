package app.lottery.bet;

import lombok.*;
import app.lottery.user.Mail;

/**
 * RASCUNHO - Identifica as apostas do {@link Mail}.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BetTicket {
    private Long id;
    private Long userId;
    private int factorA;
    private int factorB;
    private int factorC;
    private int factorD;
    private int factorE;
    private int factorF;
    
    private int betSort;
    
}