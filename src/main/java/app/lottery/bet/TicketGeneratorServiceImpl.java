package app.lottery.bet;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.lottery.user.UserRepository;
import app.lottery.user.User;
import app.lottery.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketGeneratorServiceImpl implements TicketGeneratorService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Override
    public Ticket verifiedTicket(TicketDTO ticketDTO) {
                
        UserDTO userDTO = ticketDTO.getUserMail();
        
        // Verifica se o usuário existe na base de dados, se não existir, criar.
        User user = userRepository.findByUserMail(userDTO.getUserMail())
            .orElseGet(() -> {
                log.info("Criando novo usuário {}",
                    ticketDTO.getUserMail());
                    User newUser = new User(userDTO.getUserMail());
                return userRepository.save(newUser);
            });   
                   
        // Verifica se o bilhete (usuário + aposta) está correto.
        Ticket verifiedTicket = new Ticket(
            null, 
            user, 
            ticketDTO.getBet()
        );

        // Armazena o bilhete.
        Ticket storedTicket = ticketRepository.save(verifiedTicket);
        return storedTicket;
        
    }

    @Override
    public List<Ticket> getStatsForUser(final String userMail) {        
        Optional<User> user = userRepository.findByUserMail(userMail);
        if (user.isPresent()){
            log.info("Usuario encontrado");
            return ticketRepository.findByUser(user.get());
        }
        return null;
    }

}