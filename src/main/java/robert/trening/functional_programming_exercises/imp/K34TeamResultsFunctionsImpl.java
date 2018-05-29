package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.api.K34TeamResultsFunction;
import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


public class K34TeamResultsFunctionsImpl implements K34TeamResultsFunction {

    public K34TeamResultsFunctionsImpl() {
    }

    public static Optional<K34TeamScore[]> function(Optional<K34TeamScore[]> k34, int distance) {
        K34TeamScore[] k34TeamScores = k34.orElse(new K34TeamScore[]{});
        var marathoners = new HashSet<String>();

        var resultList =
                Stream.of(k34TeamScores)
                        .filter(k34t -> k34t.getDistance() == distance)
                        .sorted(comparing(K34TeamScore::getDuration))
                        .filter(k34t -> marathoners.add(k34t.getName()))
                        .sorted(comparing(K34TeamScore::getName))
                        .collect(toList());

        var returnTable = new K34TeamScore[resultList.size()];
        return Optional.ofNullable(resultList.toArray(returnTable));
    }

    @Override
    public Optional<K34TeamScore[]> function_(Optional<K34TeamScore[]> k34TeamScores, int distance) {
        BiFunction<Optional<K34TeamScore[]>, Integer, Optional<K34TeamScore[]>> fn =
                (k34, competitionDistance) -> function(k34, competitionDistance);
        return fn.apply(k34TeamScores, distance);
    }
}
