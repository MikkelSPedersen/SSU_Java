import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*; 

public class stats {
    private int[] numbers;
    
    public stats(int[] num){
        numbers = num;
    }
 
    public void counter(){
       try {
          FileWriter myWriter = new FileWriter("output.txt");
          
          for(int i =0; i <= 20; i++){
             myWriter.write(i + ":" + numCount(i) + "\n");
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
 }