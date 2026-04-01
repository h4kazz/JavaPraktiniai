import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

import java.util.concurrent.ThreadLocalRandom;

public class BeerFactoryImpl implements BeerFactory {
    private double maltInGrams = 1000;

    @Override
    public void receiveMaltShippment(double v) {
        maltInGrams += v * 1000;
    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {
        final double maltPerBottle = 25;

        if (maltInGrams < maltPerBottle) {
            throw new NoMoreMaltException("No more malt available");
        }

        maltInGrams -= maltPerBottle;

        double volume = (1.0 / 3.0) + (0.5 - 1.0 / 3.0) * Math.random();

        double alcohol = 4.5 + (5.7 - 4.5) * Math.random();

        return new DefaultBeerBottle(volume, alcohol);
    }
}