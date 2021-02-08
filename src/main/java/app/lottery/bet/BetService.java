package app.lottery.bet;

import java.util.List;

public interface BetService {

    /**
     * Verifica se a aposta gerada na camada de apresentação está correta.
     *  
     * Retorna (@return) o resultado da aposta.
     */
    BetTicket verifyTicket(BetTicketDTO ticketDTO);

    /**
     * Recebe os bilhetes do usuário.
     * 
     * @param userEmail
     * @return uma lista com as apostas {@link BetTicket}
     */
    List<BetTicket> getStatsForUser(String userMail);

}