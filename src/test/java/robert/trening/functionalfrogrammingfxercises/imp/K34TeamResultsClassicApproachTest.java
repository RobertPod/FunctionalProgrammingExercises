package robert.trening.functionalfrogrammingfxercises.imp;

import org.junit.jupiter.api.Test;
import robert.trening.functionalfrogrammingfxercises.model.K34TeamScore;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class K34TeamResultsClassicApproachTest {
    private int duration1 = 3 * 60 * 60 + 44 * 60 + 8;
    private int duration2 = 1 * 60 * 60 + 37 * 60 + 17;
    private int duration3 = 11 * 60 * 60 + 7 * 60 + 27;
    private int duration4 = 3 * 60 * 60 + 58 * 60 + 38;
    private int duration5 = 11 * 60 * 60 + 51 * 60 + 21;
    private int duration6 = 3 * 60 * 60 + 59 * 60 + 57;

    private K34TeamScore k34TeamScore1 = new K34TeamScore("Robert", 42195, duration1, "Berlin");
    private K34TeamScore k34TeamScore2 = new K34TeamScore("Robert", 21095, duration2, "Wrocław");
    private K34TeamScore k34TeamScore3 = new K34TeamScore("Piotrek", 70000, duration3, "Zakopane");
    private K34TeamScore k34TeamScore4 = new K34TeamScore("Daniel", 42195, duration4, "Kraków");
    private K34TeamScore k34TeamScore5 = new K34TeamScore("Daniel", 108000, duration5, "Cisna");
    private K34TeamScore k34TeamScore6 = new K34TeamScore("Robert", 42195, duration6, "NY");

    private K34TeamScore[] k34TeamScores = {k34TeamScore1, k34TeamScore2, k34TeamScore3, k34TeamScore4, k34TeamScore5, k34TeamScore6};

    @Test
    void howManyMembersRunMarathonTest() {
        // Given
        var teamResultTable = k34TeamScores;
        var k34 = new K34TeamResultsClassicApproach(teamResultTable);
        // When
        var distance = 42195;
        //Then
        var teamResultTableActual = k34.howManyMembersRunDistance(distance).orElse(teamResultTable);
        assertEquals(2, teamResultTableActual.length);
    }

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