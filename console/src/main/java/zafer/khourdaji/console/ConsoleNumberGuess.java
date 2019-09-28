package zafer.khourdaji.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import zafer.khourdaji.Game;
import zafer.khourdaji.MessageGenerator;
import zafer.khourdaji.NumberGenerator;
import zafer.khourdaji.NumberGeneratorImpl;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    /**
     * The context refereshed event gets called when the context is initialized
     * and when the context is refreshed.
    */
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("Container is ready for use.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");
                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
