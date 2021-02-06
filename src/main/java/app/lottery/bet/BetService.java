package app.lottery.bet;

public interface BetService {

    /**
     * Verifica se a aposta gerada na camada de apresentação está correta.
     *  
     * Retorna (@return) o resultado do BetTicket.
     */
    BetTicket verifyTicket(BetTicketDTO ticketDTO);

}