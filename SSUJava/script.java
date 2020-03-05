import java.util.*; 
import stats.java;
import stats.input;

public class script {
   public static void main(String args[]) {

      System.out.println("Copying files");

      input newInput = new input("input.txt");
      
      stats stat = new stats(newInput.readIntFile());
      stat.counter();
      
   }
}