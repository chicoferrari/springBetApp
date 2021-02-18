package app.lottery.bet;

import java.util.List;

public interface TicketGeneratorService {

    /**      
    * Retorna {@return} uma sequência de números aleatórios e vincula ao apostador.
    */
    Ticket verifiedTicket(TicketDTO ticketDTO);

    /**
     * Retorna as informações das apostas por usuário.
     * 
     * @param userMail
     * @return uma lista com todas as apostas do usuário {@link Ticket}
     */
    List<Ticket> getStatsForUser(String userMail);

}