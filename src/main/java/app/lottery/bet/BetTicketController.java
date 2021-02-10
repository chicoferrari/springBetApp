package app.lottery.bet;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe que implementa a API REST que recebe (GET) o email do usuário.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bets")
class BetTicketController {

    private final BetService betService;
        
    @PostMapping("/bet")
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