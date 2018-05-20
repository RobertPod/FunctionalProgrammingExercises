package robert.trening.functional_programming_exercises.imp;

import org.junit.jupiter.api.Test;
import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.Optional;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class K34TeamResultsLambdaTest {
    private int duration1 = 3 * 60 * 60 + 44 * 60 + 8;
    private int duration2 = 1 * 60 * 60 + 37 * 60 + 17;
    private int duration3 = 11 * 60 * 60 + 7 * 60 + 27;
    private int duration4 = 3 * 60 * 60 + 58 * 60 + 38;
    private int duration5 = 11 * 60 * 60 + 51 * 60 + 21;
    private int duration6 = 3 * 60 * 60 + 59 * 60 + 57;

    private int marathon_distance = 42195;
    private int BUGT_distance = 70000;

    private K34TeamScore k34TeamScore1 = new K34TeamScore("Robert", marathon_distance, duration1, "Berlin");
    private K34TeamScore k34TeamScore2 = new K34TeamScore("Robert", 21095, duration2, "Wrocław");
    private K34TeamScore k34TeamScore3 = new K34TeamScore("Piotrek", BUGT_distance, duration3, "Zakopane");
    private K34TeamScore k34TeamScore4 = new K34TeamScore("Daniel", marathon_distance, duration4, "Kraków");
    private K34TeamScore k34TeamScore5 = new K34TeamScore("Daniel", 108000, duration5, "Cisna");
    private K34TeamScore k34TeamScore6 = new K34TeamScore("Robert", marathon_distance, duration6, "NY");

    private K34TeamScore[] k34TeamScores1 = {k34TeamScore1, k34TeamScore2, k34TeamScore3, k34TeamScore4, k34TeamScore5, k34TeamScore6};
    private K34TeamScore[] k34TeamScores2 = {k34TeamScore4, k34TeamScore6, k34TeamScore2, k34TeamScore3, k34TeamScore5, k34TeamScore1};

    @Test
    void runnersWhoRanTheDistanceTest() {
        // Given
        BiFunction<Optional<K34TeamScore[]>, Integer, Optional<K34TeamScore[]>> fn =
                (k34TeamScores, distance) ->
                        K34TeamResultsFunctions.runnersWhoRanTheDistanceAndBestScore
                                (k34TeamScores.orElseGet(() -> new K34TeamScore[]{}), distance);

        // When
        var marathon_distance = 42195;
        var BUGT_distance = 70000;
        var K10_distance = 10000;
        var duration = 3 * 60 * 60 + 44 * 60 + 8;

        // Then
        assertEquals(2, fn.apply(Optional.ofNullable(k34TeamScores1), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);
        assertEquals(2, fn.apply(Optional.ofNullable(k34TeamScores2), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);

        assertEquals(0, fn.apply(Optional.ofNullable(k34TeamScores1), K10_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);

        assertEquals(1, fn.apply(Optional.ofNullable(k34TeamScores1), BUGT_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);


        assertTrue("Daniel".equals(fn.apply(Optional.ofNullable(k34TeamScores1), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[0]
                .getName()));

        assertTrue("Daniel".equals(fn.apply(Optional.ofNullable(k34TeamScores2), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[0]
                .getName()));

        assertEquals(duration, fn.apply(Optional.ofNullable(k34TeamScores1), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[1]
                .getDuration());

        assertEquals(duration, fn.apply(Optional.ofNullable(k34TeamScores2), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[1]
                .getDuration());
    }

    @Test
    void runnersWhoRanTheDistanceTest_NullInput() {
        // Given
        BiFunction<Optional<K34TeamScore[]>, Integer, Optional<K34TeamScore[]>> fn =
                (k34TeamScores, distance) ->
                        K34TeamResultsFunctions.runnersWhoRanTheDistanceAndBestScore
                                (k34TeamScores.orElseGet(() -> new K34TeamScore[]{}), distance);

        // When
        var marathon_distance = 42195;

        // Then
        assertEquals(0, fn.apply(Optional.ofNullable(null), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);
    }
}