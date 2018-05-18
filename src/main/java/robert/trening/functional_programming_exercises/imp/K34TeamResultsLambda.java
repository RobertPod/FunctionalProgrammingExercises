package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.*;
import java.util.function.BiPredicate;

public class K34TeamResultsLambda {
    K34TeamScore[] k34TeamScores;

    public K34TeamResultsLambda(Optional<K34TeamScore[]> k34TeamScores) {

        this.k34TeamScores = k34TeamScores.orElseGet(() -> new K34TeamScore[]{});
    }

    private K34TeamResultsLambda() {

    }

    public Optional<K34TeamScore[]> runnersWhoRanTheDistanceAndBestScore(int distance) {
        return K34TeamResultsFunctions.runnersWhoRanTheDistanceAndBestScore(k34TeamScores, distance);
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
