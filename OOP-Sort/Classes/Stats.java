package Classes;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private double[] doubleNum;

    public Stats(double[] num) {
        doubleNum = num;
    }

    public void counter() {
        ArrayList<Double> min = new ArrayList<>();
        ArrayList<Double> max = new ArrayList<>();
        int minNum = 0;
        int maxNum = 0;
        for (double i = -50; i <= 50.1; i += .1) {
            int num = numDoubleCount(i);
            if (num > 0) {
                if(minNum == 0){//kommer kun herind første gang der kommer et tal
                    minNum = num;
                }
                if(num <= minNum){
                    if(num == minNum){
                        min.add(Math.round(i * 10.0) / 10.0);
                    }else{
                        min.clear();
                        min.add(Math.round(i * 10.0) / 10.0);
                        minNum = num;
                    }
                }
                if(num >= maxNum){
                    if(num == maxNum){
                        max.add(Math.round(i * 10.0) / 10.0);
                    }else{
                        max.clear();
                        max.add(Math.round(i * 10.0) / 10.0);
                        maxNum = num;
                    }
                }
                System.out.println(Math.round(i * 10.0) / 10.0 + ":" + num);
            }
        }

        System.out.print("Most common temperature appeared " + maxNum + " time(s), Numbers are: ");
        for (Double double1 : max) {
            System.out.print(double1 + " : ");
        }
        System.out.println("");
        System.out.print("Least common temperature appeared " + minNum + " time(s), Numbers are: ");
        for (Double double1 : min) {
            System.out.print(double1 + " : ");
        }
        System.out.println("");

    }

    private int numDoubleCount(double numToCheck) {
        int numCount = 0;

        for (int j = 0; j < doubleNum.length; j++) {
            if (doubleNum[j] <= numToCheck && doubleNum[j] > (numToCheck - .1)) {
                numCount++;
            }
        }

        return numCount;
    }

}