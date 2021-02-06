package app.lottery.bet;

import app.lottery.user.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Classe que implementa a API REST que recebe (GET) as apostas geradas.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bets")
public class BetTicketController {

    private final BetGeneratorService betGeneratorService;
    
    @PostMapping("/random") 
    ResponseEntity<Mail> userMail(
            @RequestBody @Valid MailDTO mailDTO) {
                log.info("Dado recebido: {}", mailDTO.getEmailAddress());
                return ResponseEntity.ok(new Mail(mailDTO.getEmailAddress()));
            }    

    @GetMapping("/random")
    Bet getRandomBet(String email) {
        Bet bet = betGeneratorService.randomBet();
        log.info("Gerando uma nova aposta: {}", bet);
        log.info("Dado recebido: {}", email);
        return bet;
    }
}