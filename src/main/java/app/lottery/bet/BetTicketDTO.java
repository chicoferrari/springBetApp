package app.lottery.bet;

import lombok.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Filtragem da aposta.
 */
@Value
public class BetTicketDTO {

    @NotBlank
    String userMail;

    @Size(min = 6, max = 6)
    List<@Min(1) @Max(60) Integer> bets;  

}