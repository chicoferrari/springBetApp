package app.lottery.bet;

import app.lottery.user.Mail;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService {
    
    @Override
    public BetTicket verifyTicket(BetTicketDTO ticketDTO) {
        String userMail = ticketDTO.getUserMail();
        List<Integer> bets = ticketDTO.getBets();
        
        Mail email = new Mail(userMail);

        BetTicket checkedTicket = new BetTicket(email, bets);

        return checkedTicket;
    }
    
}