package robert.trening.functionalfrogrammingfxercises.imp;

import robert.trening.functionalfrogrammingfxercises.model.K34TeamScore;

import java.util.Arrays;

public class StreamsExample {
    K34TeamScore[] k34TeamScores;

    public StreamsExample() {
    }

    public StreamsExample(K34TeamScore[] k34TeamScores) {
        this.k34TeamScores = k34TeamScores;
    }

    public long numberOfMarathoners() {
        return Arrays.stream(k34TeamScores)
                .filter(k34TeamScore -> k34TeamScore.getDistance() == 42195)
                .count();
    }

//    public long numberOfMarathoners_() {
//        return Arrays.stream(k34TeamScores).reduce((k34TeamScore, k34TeamScore2) ->)
//                .filter(k34TeamScore -> k34TeamScore.getDistance() == 42195)
//                .count();
//    }
}
