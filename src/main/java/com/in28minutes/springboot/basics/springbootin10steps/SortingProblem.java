import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ajay on 7/14/2018.
 */

public class SortingProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>();
        String inputString;
        do {
            inputString = bufferedReader.readLine();
            inputList.add(inputString);
        } while (!inputString.equals("0"));
        int numberOfNamesInTestCase = 0;
        int index = 0;
        while (index < inputList.size()) {
            String anInput = inputList.get(index);
            if (isNumeric(anInput)) {
                if (Integer.parseInt(anInput) == 0) {
                    System.exit(0);
                }
                numberOfNamesInTestCase = Integer.parseInt(anInput);
                index++;
            } else {
                extractListOfNames(numberOfNamesInTestCase, index, inputList);
                index = index + numberOfNamesInTestCase;
            }
        }
    }

    private static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    private static void extractListOfNames(int numberOfNamesInTestCase, int index, List<String> inputList) {
        List<String> names = new ArrayList<>();
        for (int i = index; i < numberOfNamesInTestCase + index; i++) {
            names.add(inputList.get(i));
        }
        final List<String> sortedList = sortNamesList(names);
        sortedList.forEach(System.out::println);
        System.out.println();
    }

    private static List<String> sortNamesList(List<String> names) {
        names.sort(new FirstTwoLetterComparator());
        return names;
    }

}

/*
* Custom Comparator
* */
class FirstTwoLetterComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() < 2 || s2.length() < 2) {
            System.out.println("Each name should have more than 2 letters.\nPlease check input.\nProgram exiting");
            System.exit(0);
        }
        return s1.substring(0, 2).compareTo(s2.substring(0, 2));
    }
}
