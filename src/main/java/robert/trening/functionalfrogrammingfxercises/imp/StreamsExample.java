package robert.trening.functionalfrogrammingfxercises.imp;

import robert.trening.functionalfrogrammingfxercises.model.K34TeamScore;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
    K34TeamScore[] k34TeamScores;

    public StreamsExample() {
    }

    public StreamsExample(K34TeamScore[] k34TeamScores) {
        this.k34TeamScores = k34TeamScores;
    }

    Predicate<K34TeamScore> runUltraMarathon = (k34TeamScore) -> {
        return k34TeamScore.getDistance() > 42195;
    };

    public Predicate<K34TeamScore> runMarathon = (k34TeamScore) -> {
        return k34TeamScore.getDistance() == 42195;
    };

    Predicate<K34TeamScore> runHalfMarathon = (k34TeamScore) -> {
        return k34TeamScore.getDistance() == 21095;
    };

    Predicate<K34TeamScore> run10Km = (k34TeamScore) -> {
        return k34TeamScore.getDistance() == 10000;
    };


    public long numberOfMarathoners() {
        return Arrays.stream(k34TeamScores)
                .filter(k34TeamScore -> k34TeamScore.getDistance() == 42195)
                .count();
    }

    public K34TeamScore[] arrayOfMarathoners() {
        List<K34TeamScore> k34TeamScoresMarathonersList = Arrays.stream(k34TeamScores)
                .filter(k34TeamScore -> k34TeamScore.getDistance() == 42195)
                .collect(Collectors.<K34TeamScore>toList());
        K34TeamScore[] k34TeamScoresMarathoners = k34TeamScoresMarathonersList.toArray(new K34TeamScore[0]);
        return k34TeamScoresMarathoners;
    }

    public K34TeamScore[] arrayOfSetDistanceRunners(Predicate<K34TeamScore> condition) {
        List<K34TeamScore> k34TeamScoresMarathonersList = Arrays.stream(k34TeamScores)
                .filter(condition)
                .collect(Collectors.toList());
        K34TeamScore[] k34TeamScoresMarathoners = k34TeamScoresMarathonersList.toArray(new K34TeamScore[0]);
        return k34TeamScoresMarathoners;
    }


}
