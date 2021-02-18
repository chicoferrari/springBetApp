package app.lottery.bet;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import app.lottery.user.UserDTO;
import lombok.Value;

import java.util.List;

/**
 * Filtragem da aposta.
 */
@Value
public class TicketDTO {

    long id;

    @Valid
    @NotNull  
    UserDTO userMail;

    @Size(min = 6, max = 6)
    List<@Min(1) @Max(60) Integer> bet;  

}