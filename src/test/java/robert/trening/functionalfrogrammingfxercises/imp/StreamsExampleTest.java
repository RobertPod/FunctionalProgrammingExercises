package robert.trening.functionalfrogrammingfxercises.imp;

import org.junit.jupiter.api.Test;
import robert.trening.functionalfrogrammingfxercises.model.K34TeamScore;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StreamsExampleTest {
    private Duration duration1 = Duration.ofSeconds(3 * 60 * 60 + 44 * 60 + 8);
    private Duration duration2 = Duration.ofSeconds(1 * 60 * 60 + 37 * 60 + 17);
    private Duration duration3 = Duration.ofSeconds(11 * 60 * 60 + 7 * 60 + 27);
    private Duration duration4 = Duration.ofSeconds(3 * 60 * 60 + 58 * 60 + 38);
    private Duration duration5 = Duration.ofSeconds(11 * 60 * 60 + 51 * 60 + 21);
    private Duration duration6 = Duration.ofSeconds(3 * 60 * 60 + 59 * 60 + 57);
    private K34TeamScore k34TeamScore1 = new K34TeamScore("Robert", 42195, duration1, "Berlin");
    private K34TeamScore k34TeamScore2 = new K34TeamScore("Robert", 21095, duration2, "Wrocław");
    private K34TeamScore k34TeamScore3 = new K34TeamScore("Piotrek", 70000, duration3, "Zakopane");
    private K34TeamScore k34TeamScore4 = new K34TeamScore("Daniel", 42195, duration4, "Kraków");
    private K34TeamScore k34TeamScore5 = new K34TeamScore("Daniel", 108000, duration5, "Cisna");
    private K34TeamScore k34TeamScore6 = new K34TeamScore("Robert", 42195, duration6, "NY");
    private K34TeamScore[] k34TeamScores = {k34TeamScore1, k34TeamScore2, k34TeamScore3, k34TeamScore4, k34TeamScore5, k34TeamScore6};

    @Test
    void numberOfMarathoners() {
        StreamsExample streamsExample = new StreamsExample(k34TeamScores);
        assertEquals(2, streamsExample.numberOfMarathoners());
    }

    @Test
    void arrayOfMarathons() {
        StreamsExample streamsExample = new StreamsExample(k34TeamScores);
        assertEquals(3, streamsExample.arrayOfMarathons().length);
    }

    @Test
    void arrayOfSetDistanceRuns() {
        StreamsExample streamsExample = new StreamsExample(k34TeamScores);
        assertEquals(1, streamsExample.arrayOfSetDistanceRuns(StreamsExample.runHalfMarathon).length);
        assertEquals(2, streamsExample.arrayOfSetDistanceRuns(StreamsExample.runUltraMarathon).length);
        assertEquals(3, streamsExample.arrayOfSetDistanceRuns(StreamsExample.runMarathon).length);
        assertEquals(0, streamsExample.arrayOfSetDistanceRuns(StreamsExample.run10Km).length);
    }

    @Test
    void k34TeamTotalDistance() {
        StreamsExample streamsExample = new StreamsExample(k34TeamScores);
        assertEquals(325680, streamsExample.K34TeamTotalDistance());
    }

}