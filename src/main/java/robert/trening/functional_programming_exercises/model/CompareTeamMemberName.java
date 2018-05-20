package robert.trening.functional_programming_exercises.model;

import java.util.Comparator;

public class CompareTeamMemberName implements Comparator<K34TeamScore> {
    @Override
    public int compare(K34TeamScore o1, K34TeamScore o2) {
        if (o2 == null) return -1;
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
