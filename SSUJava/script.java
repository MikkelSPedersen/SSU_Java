import java.util.*; 
import stats.java;
import stats.input;

public class script {
   public static void main(String args[]) {

      System.out.println("Copying files");

      input newInput = new input("doubleFile.csv");

      stats stat = new stats(newInput.readFile());
      stat.counter();
   }
}