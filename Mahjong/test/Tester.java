import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tester {

    @Test
    public void winningHandEvaluateHand() {

        Assertions.assertTrue(HandUtils.evaluateHand(new WinningHand().getHand()));

    }

    @Test
    public void notAWinningHandEvaluateHand() {

        Assertions.assertFalse(HandUtils.evaluateHand(new NotAWinningHand().getHand()));

    }
}
