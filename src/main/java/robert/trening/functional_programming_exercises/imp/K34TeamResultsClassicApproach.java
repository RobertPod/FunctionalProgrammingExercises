package robert.trening.functional_programming_exercises.imp;

import robert.trening.functional_programming_exercises.model.CompareTeamMemberName;
import robert.trening.functional_programming_exercises.model.K34TeamScore;

import java.util.*;
import java.util.function.BiPredicate;

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
        CompareTeamMemberName comp = new CompareTeamMemberName();
        var resultArrays = resultList.toArray(returnTable);
        Arrays.sort(resultArrays, comp);
        return Optional.ofNullable(resultArrays);
    }
}
