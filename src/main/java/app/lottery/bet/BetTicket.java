package app.lottery.bet;

import lombok.*;
import app.lottery.user.*;

import java.util.List;
import javax.persistence.*;

/**
 * Vincula a aposta ao usuário {@link Mail}.
 */
@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class BetTicket {
    @Id 
    @GeneratedValue    
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userMail;
      
    @ElementCollection
    /*@CollectionTable(name="TicketNumbers", joinColumns=@JoinColumn(name="USER_ID"))
    @Column(name="BETS")*/
    private List<Integer> TicketNumbers;    
}