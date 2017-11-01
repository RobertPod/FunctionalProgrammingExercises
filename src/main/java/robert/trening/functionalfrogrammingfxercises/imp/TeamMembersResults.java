package robert.trening.functionalfrogrammingfxercises.imp;

import robert.trening.functionalfrogrammingfxercises.model.K34TeamScore;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

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

    BiPredicate<String, K34TeamScore> runMarathon = (name, k34TeamScore) -> {
        return k34TeamScore.getDistance() == 42195
                && name.equals(k34TeamScore.getName());
    };

    BiPredicate<String, K34TeamScore> runHalfMarathon = (name, k34TeamScore) -> {
        return k34TeamScore.getDistance() == 21095
                && name.equals(k34TeamScore.getName());
    };

    BiPredicate<String, K34TeamScore> runUltraMarathon = (name, k34TeamScore) -> {
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

    public boolean DidHeInsertFunction(String name, BiPredicate condition) {
        for (K34TeamScore k34TeamScore : k34TeamScores) {
            if (condition.test(name, k34TeamScore)) {
                return true;
            }
        }
        return false;
    }

//    public boolean DidHeMarathonBetterFuncjonal(String name) {
//        return this.DidHeInsertFunction(name, runMarathon);
//    }
//
//    public boolean DidHeHalfMarathonBetterFuncjonal(String name) {
//        return this.DidHeInsertFunction(name, runHalfMarathon);
//    }
//
//    public boolean DidHeUltraMarathonBetterFuncjonal(String name) {
//        return this.DidHeInsertFunction(name, runUltraMarathon);
//    }
}
