import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

// Notes: this gets a runtime error. 
// Toy case 1: World Water
// the first if statement will not be true, the second if statement should be true and return "YES"
// attached screenshot of it passing this test case
// Toy case 2: Earth Water
// should recursively call Earth 0 Water 1,
// then Earth 0 Water 2,
// then Earth 0 Water 3,
// then it should return "YES" as E and E are equal
// but runtime error occurs



    public static String twoStrings(String s1, int i1, String s2, int i2) {
    // Write your code here
        //base case one, if the index for s1 has reached out of bounds, they must not have a substring in common
        if (i1 == s1.length()) {
            return "NO";
        }
        //base case two, if two characters are the same they must have a substring in common
        else if (s1.charAt(i1) == s2.charAt(i2)) {
            return "YES";
        }
        //recursively call two strings increasing the second index by one
        else if (i2 < s2.length() - 1) {
            return twoStrings(s1, i1, s2, i2++);
        }
        // recursively call two strings increasing the first index by one and resetting the second index
        else {
            return twoStrings(s1, i1++, s2, 0);
        }
    }
    


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, 0, s2, 0);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
