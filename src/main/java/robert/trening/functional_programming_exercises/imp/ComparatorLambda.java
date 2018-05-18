package robert.trening.functional_programming_exercises.imp;

import java.util.*;

public class ComparatorLambda {
    public static void main(String[] args) throws InterruptedException {
//        Comparator<String> comp = new Comparator<String>() {
//
//            @Override
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        };

        Comparator<String> compLambda = (String s1, String s2) ->
                Integer.compare(s1.length(), s2.length());


        List<String> list = Arrays.asList("aaa", "a", "aaaa", "aa");
        Collections.sort(list, compLambda);

        for (String s : list) {
            System.out.println(s);
        }

    }

}
