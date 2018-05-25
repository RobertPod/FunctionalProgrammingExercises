package robert.trening.functional_programming_exercises.api;

import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.Optional;

@FunctionalInterface
public interface K34TeamResultsFunction {
    Optional<K34TeamScore[]> function_(Optional<K34TeamScore[]> k34TeamScores, int distance);
}

