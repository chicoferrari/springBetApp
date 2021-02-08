package app.lottery.bet;

import app.lottery.user.*;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Classe que implementa a API REST que recebe (GET) o email do usuário.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bets")
class BetTicketController {

    private final BetService betService;
        
    @PostMapping
    ResponseEntity<BetTicket> postResult(
            @RequestBody @Valid BetTicketDTO betTicketDTO) {
        return ResponseEntity.ok(betService.verifyTicket(betTicketDTO));
    }

    @GetMapping
    ResponseEntity<List<BetTicket>> getStatistics(@RequestParam("userMail") String userMail) {
        return ResponseEntity.ok(
            betService.getStatsForUser(userMail)
        );    
    }
 
}