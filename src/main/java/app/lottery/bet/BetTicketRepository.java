package app.lottery.bet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BetTicketRepository extends CrudRepository<BetTicket, Long> {
    /**
     * @return as apostas realizadas identificadas pelo email.
     */

     /**
    @Query("SELECT a FROM BetTicket a WHERE a.mail.email = ?1 ORDER BY a.id DESC")
    List<BetTicket> lastTickets(String userMail);
    */


    List<BetTicket> findTop10ByUserMailOrderByIdDesc(String userMail);
    
}