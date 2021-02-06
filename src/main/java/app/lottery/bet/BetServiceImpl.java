package app.lottery.bet;

import app.lottery.user.Mail;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService {
    
    @Override
    public BetTicket verifyTicket(BetTicketDTO ticketDTO) {
        List<Integer> isCorrect = ticketDTO.getBets();


        BetTicket checkedTicket = new BetTicket(null, null, null, isCorrect);

        return checkedTicket;
    }
    
}