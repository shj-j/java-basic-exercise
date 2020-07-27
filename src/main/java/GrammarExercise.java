import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //
        Scanner input = new Scanner( System.in );
        String firstWordList = input.next();
        String secondWordList = input.next();
        input.close();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //
        System.out.println(result);


    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //
        List<String> fistList = Arrays.asList(firstWordList.toUpperCase().split(","));
        List<String> secondList = Arrays.asList(secondWordList.toUpperCase().split(","));

        //check if input valid, invalid:throw error
        if ( fistList.stream().filter(s-> ! s.matches("[a-zA-Z]+")).count() > 0 
            || secondList.stream().filter(s-> ! s.matches("[a-zA-Z]+")).count() > 0 )
            throw new RuntimeException("input not valid");
        // change list to stream and remove the same words, 
        // filter using to pick the words that contain in both list. 
        // add the space between characters by using collector to change stream to string and replace "" to " "
        String resString = fistList.stream().distinct().filter(s->secondList.contains(s))
        .collect(Collectors.joining(",")).replace("", " ").replace(" , ", ",").trim();
        // change string back to list and return result
        List<String> resultList = Arrays.asList(resString.split(","));
        return resultList;
    }
}
