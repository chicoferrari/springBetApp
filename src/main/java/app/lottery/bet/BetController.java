package app.lottery.bet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Classe que implementa a API para receber as apostas
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/apostas")
public class BetController {

    private final BetGeneratorService betGeneratorService;

    @GetMapping("")
    Bet getRandomBet() {
        Bet bet = betGeneratorService.randomBet();
        log.info("Gerando uma nova aposta: {}", bet);
        return bet;
    }
}