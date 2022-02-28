package shipping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public List<Transportable> getPackages() {
        return new ArrayList<>(packages);
    }

    void addPackage(Transportable packag) {
        packages.add(packag);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {

        return packages.stream().filter(a -> (a.isBreakable() == breakable && a.getWeight() >= weight)).toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();

        for (Transportable p : packages) {
            int count = 0;
            if (result.containsKey(p.getDestinationCountry()))
                count = result.get(p.getDestinationCountry());
            count++;
            result.put(p.getDestinationCountry(), count);
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream().filter(x -> x instanceof InternationalPackage).sorted((x, y) -> ((InternationalPackage) x).getDistance() - ((InternationalPackage) y).getDistance()).toList();
    }

}
