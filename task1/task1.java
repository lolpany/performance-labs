import java.sql.SQLOutput;
import java.util.Scanner;

class task1 {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int size = inputScanner.nextInt();
        int interval = inputScanner.nextInt() - 1;
        String result = "";
        int position = 1;
        int addition = 0;
        do {
            result += position;
            position = (position + interval) % size;
            if (position == 0) {
                position = size;
            }
        } while (position != 1);
        System.out.println(result);
    }

}