import itadesign.beerdrinker.BeerBottle;

public class DisguisedBeerBottle implements BeerBottle {
    private final BeerBottle realBottle; // the real one

    public DisguisedBeerBottle(BeerBottle realBottle) {
        this.realBottle = realBottle;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return 0.0; // lie to the policeman
    }

    @Override
    public double getVolumeInLiters() {
        return realBottle.getVolumeInLiters(); // real volume
    }

    @Override
    public void takeASip(double volumeInLiters) {
        realBottle.takeASip(volumeInLiters); // sip affects the real bottle!
    }
}