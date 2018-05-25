package robert.trening.functional_programming_exercises.imp;

import org.junit.jupiter.api.Test;
import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static robert.trening.functional_programming_exercises.imp.K34TeamResultsFunctionsImpl.function;

class K34TeamResultsLambdaTest {
    private int duration1 = 3 * 60 * 60 + 44 * 60 + 8;
    private int duration2 = 1 * 60 * 60 + 37 * 60 + 17;
    private int duration3 = 11 * 60 * 60 + 7 * 60 + 27;
    private int duration4 = 3 * 60 * 60 + 58 * 60 + 38;
    private int duration5 = 11 * 60 * 60 + 51 * 60 + 21;
    private int duration6 = 3 * 60 * 60 + 59 * 60 + 57;

    private int marathon_dist = 42195;
    private int BUGT_distanc = 70000;
    private int BRzeznikaU_di = 108000;
    private int half_marathon = 21095;

    private K34TeamScore k34TeamScore1 = new K34TeamScore("Robert", marathon_dist, duration1, "Berlin");
    private K34TeamScore k34TeamScore2 = new K34TeamScore("Robert", half_marathon, duration2, "Wrocław");
    private K34TeamScore k34TeamScore3 = new K34TeamScore("Piotrek", BUGT_distanc, duration3, "Zakopane");
    private K34TeamScore k34TeamScore4 = new K34TeamScore("Daniel", marathon_dist, duration4, "Kraków");
    private K34TeamScore k34TeamScore5 = new K34TeamScore("Daniel", BRzeznikaU_di, duration5, "Cisna");
    private K34TeamScore k34TeamScore6 = new K34TeamScore("Robert", marathon_dist, duration6, "NY");

    private K34TeamScore[] k34TeamScores1 = {k34TeamScore1, k34TeamScore2, k34TeamScore3, k34TeamScore4, k34TeamScore5, k34TeamScore6};
    private K34TeamScore[] k34TeamScores2 = {k34TeamScore4, k34TeamScore6, k34TeamScore2, k34TeamScore3, k34TeamScore5, k34TeamScore1};

    @Test
    void runnersWhoRanTheDistanceTest() {
        // Given
        // * k34TeamScores1
        // * k34TeamScores2
        // * fnByMethod

        // When
        var marathon_distance = 42195;
        var BUGT_distance = 70000;
        var K10_distance = 10000;
        var duration = 3 * 60 * 60 + 44 * 60 + 8;

        // Then
// #1 How many competitors have completed the marathon?
        assertEquals(2, function(Optional.ofNullable(k34TeamScores1), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);
// #2 How many competitors have completed the marathon? - input data in a different order
        assertEquals(2, function(Optional.ofNullable(k34TeamScores2), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);

// #3 How many competitors have completed the 10K?
        assertEquals(0, function(Optional.ofNullable(k34TeamScores1), K10_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);

// #4 How many competitors have completed the BUGT competition?
        assertEquals(1, function(Optional.ofNullable(k34TeamScores1), BUGT_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);


// #5 Is the result sorted by player's name?
        assertTrue("Daniel".equals(function(Optional.ofNullable(k34TeamScores1), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[0]
                .getName()));

// #6 Is the result sorted by player's name? - input data in a different order
        assertTrue("Daniel".equals(function(Optional.ofNullable(k34TeamScores2), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[0]
                .getName()));

// #7 Was the best result chosen if the competitor repeatedly finished the marathon?
        assertEquals(duration, function(Optional.ofNullable(k34TeamScores1), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[1]
                .getDuration());

// #8 Was the best result chosen if the competitor repeatedly finished the marathon?
//     - input data in a different order
        assertEquals(duration, function(Optional.ofNullable(k34TeamScores2), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})[1]
                .getDuration());
    }

    @Test
    void runnersWhoRanTheDistanceTest_NullInput() {
        // Given

        // When
        var marathon_distance = 42195;

        // Then
        assertEquals(0, function(Optional.ofNullable(null), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);
    }

    @Test
    void runnersWhoRanTheDistanceTest_EmptyInputData() {
        // Given
        K34TeamScore[] k34 = {new K34TeamScore(null, 0, 0, null)};

        // When
        var marathon_distance = 42195;

        // Then
        assertEquals(0, function(Optional.ofNullable(k34), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);
    }

    @Test
    void runnersWhoRanTheDistanceTest_NameEqNull() {
        // Given
        K34TeamScore[] k34 = {new K34TeamScore(null, marathon_dist, 100, "NYC"),
                new K34TeamScore(null, marathon_dist, 1000, "Wroclaw")
        };
        K34TeamResultsFunctionsImpl fClass = new K34TeamResultsFunctionsImpl();

        // When
        var marathon_distance = 42195;

        // Then
        assertEquals(1, fClass.function_(Optional.ofNullable(k34), marathon_distance)
                .orElseGet(() -> new K34TeamScore[]{})
                .length);
    }
}