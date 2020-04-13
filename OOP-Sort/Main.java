import java.util.*;

import Classes.Stats;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.nextLine();

        double[] numbers = splitString(input);
        
        //System.out.print(generateNum(-50, 50, Integer.parseInt(input)));

        System.out.println("Sorted numbers");
        for (double num : numbers) {
            System.out.print(num + ",");
        }

        System.out.println("");
        
        
        Stats stat = new Stats(numbers);
        stat.counter();

        
    }

    private static double[] splitString(String input) {
        String[] tempString = input.split(",");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < tempString.length; i++) {
            double val = Double.valueOf(tempString[i]);
            if(val >= -50 && val <=50){
                strings.add(tempString[i]);
            }
        }

        double[] temp = new double[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            temp[i] = Double.valueOf(strings.get(i));
        }
        bubbleSort(temp);
        return temp;
    }

    private static void bubbleSort(double[] input) {
        int n = input.length;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (input[j - 1] > input[j]) {
                    // swap elements
                    temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }
            }
        }
    }

    private static String generateNum(double min, double max, int numOfData) {
        String temp = "";
        final Random r = new Random();
        for (int i = 0; i < numOfData; i++) {
            double randomNum = min + (max - (min)) * r.nextDouble();
            temp += Math.round(randomNum * 10.0) / 10.0 + ",";
        }

        return temp;
    }
}