package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.function.BiPredicate;

public class TeamMembersResults {
    K34TeamScore[] k34TeamScores;

    public TeamMembersResults() {
    }

    public TeamMembersResults(K34TeamScore[] k34TeamScores) {
        this.k34TeamScores = k34TeamScores;
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
