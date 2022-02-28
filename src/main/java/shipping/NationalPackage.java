package shipping;

public class NationalPackage implements Transportable {
    private int weight;
    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        if (breakable) return 2 * 1000;
        return 1000;
    }

    @Override
    public String getDestinationCountry() {
        return Transportable.super.getDestinationCountry();
    }
}
