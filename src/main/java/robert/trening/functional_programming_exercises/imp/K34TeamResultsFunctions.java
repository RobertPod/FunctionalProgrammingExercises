package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class K34TeamResultsFunctions {

    public K34TeamResultsFunctions() {
    }

    public static Optional<K34TeamScore[]> runnersWhoRanTheDistanceAndBestScore(K34TeamScore[] k34TeamScores,
                                                                                int distance) {
        var marathoners = new HashSet<String>();

        var resultList =
                Stream.of(k34TeamScores)
                        .filter(k34 -> k34.getDistance() == distance)
                        .sorted((k34, o) ->
                                (k34.equals(o) ? 0 : k34.getDuration() > o.getDuration() ? 1 : -1))
                        .filter(k34 -> marathoners.add(k34.getName()))
                        .sorted((k34, o) ->
                                (k34.getName().compareTo(o.getName())))
                        .collect(Collectors.toList());

        var returnTable = new K34TeamScore[resultList.size()];
        return Optional.ofNullable(resultList.toArray(returnTable));
    }
}
