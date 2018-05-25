package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.api.K34TeamResultsFunction;
import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class K34TeamResultsFunctionsImpl implements K34TeamResultsFunction {

    public K34TeamResultsFunctionsImpl() {
    }

    public static Optional<K34TeamScore[]> function(Optional<K34TeamScore[]> k34, int distance) {
        K34TeamScore[] k34TeamScores = k34.orElse(new K34TeamScore[]{});
        var marathoners = new HashSet<String>();

        var resultList =
                Stream.of(k34TeamScores)
                        .filter(k34t -> k34t.getDistance() == distance)
                        .sorted((k34t, o) -> (k34t.equals(o) ? 0 : Integer.compare(k34t.getDuration(), o.getDuration())))
                        .filter(k34t -> marathoners.add(k34t.getName()))
                        .sorted((k34t, o) -> (k34t.getName().compareTo(o.getName())))
                        .collect(Collectors.toList());

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