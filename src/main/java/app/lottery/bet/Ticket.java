package app.lottery.bet;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import app.lottery.user.User;
import app.lottery.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Identifica o usuário {@link UserDTO} e recebe os números da aposta.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id 
    @GeneratedValue    
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
      
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> Bet;
}