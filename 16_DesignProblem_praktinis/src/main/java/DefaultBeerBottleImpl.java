import itadesign.beerdrinker.BeerBottle;

public class DefaultBeerBottleImpl implements BeerBottle {
    private double volumeInLiters;
    private double alcoholContentInPercent;

    public DefaultBeerBottleImpl(double volumeInLiters, double alcoholContentInPercent) {
        this.volumeInLiters = volumeInLiters;
        this.alcoholContentInPercent = alcoholContentInPercent;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return alcoholContentInPercent;
    }

    @Override
    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    @Override
    public void takeASip(double v) {
        this.volumeInLiters = volumeInLiters - v;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
