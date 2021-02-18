package app.lottery.bet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.lottery.user.User;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    /**
    * @return as apostas realizadas pelo usuário.
    */
    List<Ticket> findByUser(User userMail);
    
}