package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.Optional;

public class K34TeamResultsLambdaByClass {
    K34TeamScore[] k34TeamScores;

    public K34TeamResultsLambdaByClass(Optional<K34TeamScore[]> k34TeamScores) {

        this.k34TeamScores = k34TeamScores.orElseGet(() -> new K34TeamScore[]{});
    }

    private K34TeamResultsLambdaByClass() {

    }

    public Optional<K34TeamScore[]> runnersWhoRanTheDistanceAndBestScore(int distance) {
        return K34TeamResultsFunctions.runnersWhoRanTheDistanceAndBestScore(k34TeamScores, distance);
    }
}
