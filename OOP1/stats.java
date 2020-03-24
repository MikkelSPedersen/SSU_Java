import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*; 

public class stats {
    private int[] numbers;
    private double[] doubleNum;
    private boolean isDouble = false;
    
    public stats(int[] num){
        numbers = num;
    }
 
    public stats(double[] num){
        doubleNum = num;
        isDouble = true;
    }

    public void counter(){
       try {
            FileWriter myWriter = new FileWriter("output.txt");
          
            if(isDouble){
                int[] params = getParam();

                for(int i = params[0]; i <= params[1]; i++){
                    myWriter.write(i + ":" + numDoubleCount(i) + "\n");
                }
            }
            else{
                for(int i =0; i <= 20; i++){
                    myWriter.write(i + ":" + numCount(i) + "\n");
                 }
            }
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
       } 
       catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
 
    }
 
    private int numCount(int numToCheck){
       int numCount = 0;
 
       for(int j = 0; j < numbers.length; j++){
          if(numbers[j] == numToCheck){
             numCount ++;
          }
       }
 
       return numCount;
    }

    private int numDoubleCount(int numToCheck){
        int numCount = 0;
  
        for(int j = 0; j < doubleNum.length; j++){
           if(doubleNum[j] <= numToCheck && doubleNum[j] > (numToCheck - 1)){
              numCount ++;
           }
        }
  
        return numCount;
     }

     private int[] getParam(){
         int tempMin = 0;
         int tempMax = 0;
        for(int i = 0; i <= doubleNum.length - 1; i++){
            if(tempMin >= doubleNum[i]){
                tempMin = (int)doubleNum[i];
            }
            if(tempMax <= doubleNum[i]){
                tempMax = (int)doubleNum[i];
            }
         }

        int[] returnVal = {tempMin, tempMax};

        return returnVal;
     }

 }