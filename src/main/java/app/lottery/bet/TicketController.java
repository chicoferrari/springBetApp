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
 * Classe que fornece uma API Rest para receber os email dos usuários.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("")
class TicketController {

    private final TicketGeneratorService ticketGeneratorService;

    @PostMapping("/aposta")
    ResponseEntity<Ticket> postTicket(
        @RequestBody @Valid TicketDTO ticketDTO) {
            log.info("Criando bilhete: {}", ticketDTO);
            return ResponseEntity.ok(ticketGeneratorService.verifiedTicket(ticketDTO));
        }
    
    @GetMapping("/historico")
    ResponseEntity<List<Ticket>> historicoApostas(@RequestParam("userMail") String userMail) {
        return ResponseEntity.ok(
            ticketGeneratorService.getStatsForUser(userMail)
        );
    }
}