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

    public static Predicate<K34TeamScore> runUltraMarathon = (k34TeamScore) -> {
        return k34TeamScore.getDistance() > 42195;
    };

    public static Predicate<K34TeamScore> runMarathon = (k34TeamScore) -> {
        return k34TeamScore.getDistance() == 42195;
    };

    public static Predicate<K34TeamScore> runHalfMarathon = (k34TeamScore) -> {
        return k34TeamScore.getDistance() == 21095;
    };

    public static Predicate<K34TeamScore> run10Km = (k34TeamScore) -> {
        return k34TeamScore.getDistance() == 10000;
    };


    public long numberOfMarathoners() {
        return Arrays.stream(k34TeamScores)
                .filter(k34TeamScore -> k34TeamScore.getDistance() == 42195)
                .map(k34TeamScore -> k34TeamScore.getName())
                .distinct()
                .count();
    }

    public K34TeamScore[] arrayOfMarathons() {
        List<K34TeamScore> k34TeamScoresMarathonsList = Arrays.stream(k34TeamScores)
                .filter(k34TeamScore -> k34TeamScore.getDistance() == 42195)
                .collect(Collectors.<K34TeamScore>toList());
        K34TeamScore[] k34TeamScoresMarathons = k34TeamScoresMarathonsList.toArray(new K34TeamScore[0]);
        return k34TeamScoresMarathons;
    }

    public K34TeamScore[] arrayOfSetDistanceRuns(Predicate<K34TeamScore> condition) {
        List<K34TeamScore> k34TeamScoresRunsList = Arrays.stream(k34TeamScores)
                .filter(condition)
                .collect(Collectors.toList());
        K34TeamScore[] k34TeamScoresRuns = k34TeamScoresRunsList.toArray(new K34TeamScore[0]);
        return k34TeamScoresRuns;
    }

    public int K34TeamTotalDistance() {
        return Arrays.stream(k34TeamScores)
                .map(k34TeamScore -> k34TeamScore.getDistance())
                .reduce(0, (x, y) -> x + y);
    }
}
