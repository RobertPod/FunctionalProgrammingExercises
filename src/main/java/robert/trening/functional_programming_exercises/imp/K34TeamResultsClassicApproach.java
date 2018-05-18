package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.*;
import java.util.function.BiPredicate;

public class K34TeamResultsClassicApproach {
    K34TeamScore[] k34TeamScores;

    public K34TeamResultsClassicApproach(Optional<K34TeamScore[]> k34TeamScores) {

        this.k34TeamScores = k34TeamScores.orElseGet(() -> new K34TeamScore[]{});
    }

    private K34TeamResultsClassicApproach() {

    }

    public Optional<K34TeamScore[]> runnersWhoRanTheDistanceAndBestScore(int distance) {
        List<K34TeamScore> resultList = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();
        for (var k34TeamScore : k34TeamScores) {
            if (k34TeamScore.getDistance() == distance) {
                if (resultSet.add(k34TeamScore.getName())) {
                    resultList.add(k34TeamScore);
                } else {
                    for (var k34TeamScoreElem : resultList) {
                        if (k34TeamScoreElem.getName().equals(k34TeamScore.getName())
                                && k34TeamScoreElem.getDuration() > k34TeamScore.getDuration()) {
                            resultList.remove(k34TeamScoreElem);
                            resultList.add(k34TeamScore);
                            break;
                        }
                    }
                }
            }
        }
        var returnTable = new K34TeamScore[resultList.size()];
        return Optional.ofNullable(resultList.toArray(returnTable));
    }

    public boolean DidHeMarathonNonFuncjonal(String name) {
        for (K34TeamScore k34TeamScore : k34TeamScores) {
            if (k34TeamScore.getDistance() == 42195
                    && name.equals(k34TeamScore.getName())) {
                return true;
            }
        }
        return false;
    }

    public static BiPredicate<String, K34TeamScore> runMarathon = (name, k34TeamScore) -> {
        return k34TeamScore.getDistance() == 42195
                && name.equals(k34TeamScore.getName());
    };

    public static BiPredicate<String, K34TeamScore> runHalfMarathon = (name, k34TeamScore) -> {
        return k34TeamScore.getDistance() == 21095
                && name.equals(k34TeamScore.getName());
    };

    public static BiPredicate<String, K34TeamScore> runUltraMarathon = (name, k34TeamScore) -> {
        return k34TeamScore.getDistance() > 42195
                && name.equals(k34TeamScore.getName());
    };

    public boolean DidHeMarathonFuncjonal(String name) {
        for (K34TeamScore k34TeamScore : k34TeamScores) {
            if (runMarathon.test(name, k34TeamScore)) {
                return true;
            }
        }
        return false;
    }

    public boolean DidHeInsertDistanceFunction(String name, BiPredicate condition) {
        for (K34TeamScore k34TeamScore : k34TeamScores) {
            if (condition.test(name, k34TeamScore)) {
                return true;
            }
        }
        return false;
    }
}
