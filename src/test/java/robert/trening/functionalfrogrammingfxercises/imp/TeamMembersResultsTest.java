package robert.trening.functionalfrogrammingfxercises.imp;

import org.junit.jupiter.api.Test;
import robert.trening.functionalfrogrammingfxercises.model.K34TeamScore;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamMembersResultsTest {
    private Duration duration1 = Duration.ofSeconds(3 * 60 * 60 + 44 * 60 + 8);
    private Duration duration2 = Duration.ofSeconds(1 * 60 * 60 + 37 * 60 + 17);
    private Duration duration3 = Duration.ofSeconds(11 * 60 * 60 + 7 * 60 + 27);
    private K34TeamScore k34TeamScore1 = new K34TeamScore("Robert", 42195, duration1, "Berlin");
    private K34TeamScore k34TeamScore2 = new K34TeamScore("Robert", 21095, duration2, "Wrocław");
    private K34TeamScore k34TeamScore3 = new K34TeamScore("Piotrek", 70000, duration3, "Zakopane");
    private K34TeamScore[] k34TeamScores = {k34TeamScore1, k34TeamScore2, k34TeamScore3};

    @Test
    void didHeMarathonNonFuncjonal() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(teamMembersResults.DidHeMarathonNonFuncjonal("Robert"));
        assertTrue(!teamMembersResults.DidHeMarathonNonFuncjonal("Piotrek"));
        assertTrue(!teamMembersResults.DidHeMarathonNonFuncjonal("Marek"));
    }

    @Test
    void didHeMarathonFuncjonal() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(teamMembersResults.DidHeMarathonFuncjonal("Robert"));
        assertTrue(!teamMembersResults.DidHeMarathonFuncjonal("Piotrek"));
        assertTrue(!teamMembersResults.DidHeMarathonFuncjonal("Marek"));
    }

    @Test
    void DidHeInsertDistanceFunctionMarathon() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(teamMembersResults.DidHeInsertDistanceFunction("Robert", TeamMembersResults.runMarathon));
        assertTrue(!teamMembersResults.DidHeInsertDistanceFunction("Piotrek", TeamMembersResults.runMarathon));
        assertTrue(!teamMembersResults.DidHeInsertDistanceFunction("Marek", TeamMembersResults.runMarathon));
    }

    @Test
    void DidHeInsertDistanceFunctionHalfMarathon() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(teamMembersResults.DidHeInsertDistanceFunction("Robert", TeamMembersResults.runHalfMarathon));
        assertTrue(!teamMembersResults.DidHeInsertDistanceFunction("Piotrek", TeamMembersResults.runHalfMarathon));
        assertTrue(!teamMembersResults.DidHeInsertDistanceFunction("Marek", TeamMembersResults.runHalfMarathon));

    }

    @Test
    void DidHeInsertDistanceFunctionUltraMarathon() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(!teamMembersResults.DidHeInsertDistanceFunction("Robert", TeamMembersResults.runUltraMarathon));
        assertTrue(teamMembersResults.DidHeInsertDistanceFunction("Piotrek", TeamMembersResults.runUltraMarathon));
        assertTrue(!teamMembersResults.DidHeInsertDistanceFunction("Marek", TeamMembersResults.runUltraMarathon));
    }
}