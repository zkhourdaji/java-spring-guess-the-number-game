package zafer.khourdaji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// this is not used. GameConfig is used in the main  method instead.
@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "zafer.khourdaji")
public class AppConfig {

}
