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

//    @BeforeAll
//    void pripareData(){
//        if (K34TeamScores == null){
//
//        }
//    }

//    @BeforeEach
//    void pripareData(){
//        if (K34TeamScores == null)
//    }

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
    void didHeInsertFunctionMarathon() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(teamMembersResults.DidHeInsertFunction("Robert", teamMembersResults.runMarathon));
        assertTrue(!teamMembersResults.DidHeInsertFunction("Piotrek", teamMembersResults.runMarathon));
        assertTrue(!teamMembersResults.DidHeInsertFunction("Marek", teamMembersResults.runMarathon));
    }

    @Test
    void didHeInsertFunctionHalfMarathon() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(teamMembersResults.DidHeInsertFunction("Robert", teamMembersResults.runHalfMarathon));
        assertTrue(!teamMembersResults.DidHeInsertFunction("Piotrek", teamMembersResults.runHalfMarathon));
        assertTrue(!teamMembersResults.DidHeInsertFunction("Marek", teamMembersResults.runHalfMarathon));

    }

    @Test
    void didHeInsertFunctionUltraMarathon() {
        TeamMembersResults teamMembersResults = new TeamMembersResults(k34TeamScores);
        assertTrue(!teamMembersResults.DidHeInsertFunction("Robert", teamMembersResults.runUltraMarathon));
        assertTrue(teamMembersResults.DidHeInsertFunction("Piotrek", teamMembersResults.runUltraMarathon));
        assertTrue(!teamMembersResults.DidHeInsertFunction("Marek", teamMembersResults.runUltraMarathon));
    }
}