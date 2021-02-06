package app.lottery.bet;

import lombok.*;
import app.lottery.user.Mail;
import java.util.List;


/**
 * Identifica as apostas do {@link Mail}.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BetTicket {
    private Mail mail;

    private List<Integer>TicketNumbers;
    
}