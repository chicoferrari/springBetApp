package app.lottery.bet;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;

@Service
public class BetGeneratorServiceImpl implements BetGeneratorService {

    private final static int MIN = 1;
    private final static int MAX = 60;

    private final Random random;

    BetGeneratorServiceImpl() {
        this.random = new Random();        
    }

    protected BetGeneratorServiceImpl(final Random random) {
        this.random = random;        
    }

    private int next() {
        return random.nextInt(MAX - MIN) + MIN;
    }

    private List<Integer>nextBet() {
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 6) {
            set.add(next());            
        }
        List<Integer> convertedList = new ArrayList<>(set);

        return convertedList;
    }

    @Override
    public Bet randomBet() {
        return new Bet(nextBet());
    }   
    
}