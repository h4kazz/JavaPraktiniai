import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;
import itadesign.beerdrinker.DefaultBeerBottle;

public class BeerConsumerImpl extends BeerConsumer {
    BeerBottle beerBottle;

    public BeerConsumerImpl() {}

    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {
        return beerBottle.getVolumeInLiters() <= 0.5 && beerBottle.getAlcoholContentInPercent() <= 6 && getBloodAlcoholContentInLiters() <= 0.12;
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean mightBeAPoliceMan) {
        if (mightBeAPoliceMan) {
            return new DisguisedBeerBottle(beerBottle);
        }
        return beerBottle;
    }
}
