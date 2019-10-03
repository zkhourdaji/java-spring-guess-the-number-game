package zafer.khourdaji;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    @Autowired
    NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    @Override
    public int next() {
        return this.random.nextInt(this.maxNumber - this.minNumber) + this.minNumber;
    }
}
