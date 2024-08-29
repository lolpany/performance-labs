import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class task2 {

    public static void main(String[] args) throws IOException {
        String circleFile = args[0];
        String pointsFile = args[1];
        String circleFileContents = FileUtils.readFileToString(new File(circleFile), StandardCharsets.UTF_8);
        String[] circleParts = circleFileContents.split("\\s+");
        double circleX = Double.parseDouble(circleParts[0]);
        double circleY = Double.parseDouble(circleParts[1]);
        double circleRadius = Double.parseDouble(circleParts[2]);
        String pointsFileContents = FileUtils.readFileToString(new File(pointsFile), StandardCharsets.UTF_8);
        String[] pointsParts = pointsFileContents.split("\\s+");
        for (int i = 0; i < pointsParts.length; i = i + 2) {
            double pointX = Double.parseDouble(pointsParts[i]);
            double pointY = Double.parseDouble(pointsParts[i + 1]);
            double distance = Math.sqrt(Math.pow(Math.abs(pointX - circleX), 2) + Math.pow(Math.abs(pointY - circleY), 2));
            int result;
            if (distance == circleRadius) {
                result = 0;
            } else if (distance < circleRadius) {
                result = 1;
            } else {
                result = 2;
            }
            System.out.println(result);
        }
    }

}