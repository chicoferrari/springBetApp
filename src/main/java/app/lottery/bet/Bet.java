package app.lottery.bet;

import lombok.*;
import java.util.List;

/**
 * Recebe os números para a aposta.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Bet {

    private List<Integer>TicketNumbers;
    
}
