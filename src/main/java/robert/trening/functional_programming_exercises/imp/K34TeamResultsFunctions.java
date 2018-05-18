package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class K34TeamResultsFunctions {

    public K34TeamResultsFunctions() {
    }

    public static Optional<K34TeamScore[]> runnersWhoRanTheDistanceAndBestScore(K34TeamScore[] k34TeamScores,
                                                                                int distance) {

        Stream<K34TeamScore> stream = Stream.of(k34TeamScores);

        List<K34TeamScore> resultList = new ArrayList<>();

        stream
                .filter(k34 -> k34.getDistance() == distance)
                .forEach(resultList::add);

        var returnTable = new K34TeamScore[resultList.size()];
        return Optional.ofNullable(resultList.toArray(returnTable));
    }
}
