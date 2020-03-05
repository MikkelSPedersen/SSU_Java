import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 

public class input {

    private String file;

    public input(String path){
        file = path;
    }

    public int[] readIntFile(){
        int[] returnNum = new int[0];

        BufferedReader reader;
		try {
		    reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

			while (line != null) {
                returnNum = add(returnNum, Integer.parseInt(line));
                // read next line
                line = reader.readLine();
            }
            
            reader.close();
        }
        catch (IOException e) {
			e.printStackTrace();
        }
        
        return returnNum;
    }

    private int[] add(int[] arr, int elements){
        int[] tempArr = new int[arr.length+1];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        
        tempArr[arr.length] = elements;
  
        return tempArr;
        
    }
}