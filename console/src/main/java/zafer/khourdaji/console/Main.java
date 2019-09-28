package zafer.khourdaji.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zafer.khourdaji.config.AppConfig;
import zafer.khourdaji.Game;
import zafer.khourdaji.MessageGenerator;
import zafer.khourdaji.NumberGenerator;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // IoC container
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        log.info("number = {}", numberGenerator.next());

        Game game = context.getBean(Game.class);
        game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.debug(messageGenerator.getMainMessage());
        log.debug(messageGenerator.getResultMessage());

        context.close();
    }
}
