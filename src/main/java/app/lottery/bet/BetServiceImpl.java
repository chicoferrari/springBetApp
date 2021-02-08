package app.lottery.bet;

import app.lottery.user.User;
import app.lottery.user.UserRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BetServiceImpl implements BetService {

    private final UserRepository userRepository;
    private final BetTicketRepository betTicketRepository;

    @Override
    public BetTicket verifyTicket(BetTicketDTO betTicketDTO) {
        //Verifica se o usuário existe.        
        User user = userRepository.findByUserMail(betTicketDTO.getUserMail());
                
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