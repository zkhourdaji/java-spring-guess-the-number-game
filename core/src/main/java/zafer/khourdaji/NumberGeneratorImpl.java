package zafer.khourdaji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

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

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }

    @Override
    public int getMinNumber() {
        return this.minNumber;
    }
}
