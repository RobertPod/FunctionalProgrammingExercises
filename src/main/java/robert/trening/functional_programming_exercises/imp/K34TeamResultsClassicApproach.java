package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.CompareTeamMemberName;
import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class K34TeamResultsClassicApproach {
    K34TeamScore[] k34TeamScores;

    public K34TeamResultsClassicApproach(Optional<K34TeamScore[]> k34TeamScores) {

        this.k34TeamScores = k34TeamScores.orElseGet(() -> new K34TeamScore[]{});
    }

    private K34TeamResultsClassicApproach() {

    }

    public Optional<K34TeamScore[]> runnersWhoRanTheDistanceAndBestScore(int distance) {
        List<K34TeamScore> resultList = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();

        for (var k34TeamScore : k34TeamScores) {
            if (k34TeamScore.getDistance() == distance) {
                if (resultSet.add(k34TeamScore.getName())) {
                    resultList.add(k34TeamScore);
                } else {
                    for (var k34TeamScoreElem : resultList) {
                        if (k34TeamScoreElem.getName().equals(k34TeamScore.getName())
                                && k34TeamScoreElem.getDuration() > k34TeamScore.getDuration()) {
                            resultList.remove(k34TeamScoreElem);
                            resultList.add(k34TeamScore);
                            break;
                        }
                    }
                }
            }
        }

        var returnTable = new K34TeamScore[resultList.size()];
        returnTable = resultList.toArray(returnTable);

        Arrays.sort(returnTable, new CompareTeamMemberName());
        return Optional.ofNullable(returnTable);
    }
}
