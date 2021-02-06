package app.lottery.bet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Classe que implementa a API REST.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/Bets")
public class BetTicketController {

    private final BetGeneratorService betGeneratorService;

    @GetMapping("/random")
    Bet getRandomBet(String email) {
        Bet bet = betGeneratorService.randomBet();
        log.info("Gerando uma nova aposta: {}", bet);
        log.info("Dado recebido: {}", email);
        return bet;
    }
}