package app.lottery.bet;

import java.util.List;

import org.springframework.stereotype.Service;

import app.lottery.user.User;
import app.lottery.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BetServiceImpl implements BetService {

    private final BetTicketRepository betTicketRepository;

    @Override
    public BetTicket verifyTicket(BetTicketDTO betTicketDTO) {
        //Verifica se o usuário existe.        
        User user = UserRepository.findByMail(betTicketDTO.getUserMail());
                
        //Contrutor do objeto
        BetTicket checkedTicket = new BetTicket(null, user, betTicketDTO.getBets());

        //Armazena a aposta
        BetTicket storedTicket = betTicketRepository.save(checkedTicket);
        
        return storedTicket;
    }

    @Override
    public List<BetTicket> getStatsForUser(final String userMail) {
        return betTicketRepository.findTop10ByUserMailOrderByIdDesc(userMail);
    }

}