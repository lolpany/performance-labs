import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.*;

class task4 {

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        String numsFile = inputScanner.nextLine();
        String[] numsParts = FileUtils.readFileToString(new File(numsFile), StandardCharsets.UTF_8).split("\\s+");
        SortedMap<Integer, Integer> numToCount = new TreeMap<>();
        for (String numPart: numsParts) {
            int num = Integer.parseInt(numPart);
            int count = 0;
            if (numToCount.get(num) != null) {
                count = numToCount.get(num);
            } else {
                count = 1;
            }
            numToCount.put(num, count);
        }
        int result = 0;
        while (numToCount.size() > 1) {
            int lowerCount = numToCount.get(numToCount.firstKey());
            int upperCount = numToCount.get(numToCount.lastKey());
            int movedNum;
            int movedCount;
            if (lowerCount > upperCount) {
                movedNum = numToCount.lastKey() - 1;
                movedCount = numToCount.remove(numToCount.lastKey());
            } else {
                movedNum = numToCount.firstKey() + 1;
                movedCount = numToCount.remove(numToCount.firstKey());
            }
            result += movedCount;
            if (numToCount.get(movedNum) != null) {
                numToCount.put(movedNum, numToCount.get(movedNum) + movedCount);
            } else {
                numToCount.put(movedNum, movedCount);
            }
        }
        System.out.println(result);
    }

}