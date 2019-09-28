package zafer.khourdaji.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import zafer.khourdaji.GuessCount;
import zafer.khourdaji.MaxNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // 20 is default value
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return this.maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return this.guessCount;
    }
}
