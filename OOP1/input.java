import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 

public class input {

    private String _file;

    public input(String path){
        _file = path;
    }

    public double[] readFile(){
        double[] returnNum = new double[0];

        BufferedReader reader;
		try {
		    reader = new BufferedReader(new FileReader(_file));
            String line = reader.readLine();

			while (line != null) {
                
                returnNum = addDoubleArray(returnNum, doubleInString(line, ","));
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


    private double[] doubleInString(String line, String splitChar){
        String[] stringSplit = line.split(splitChar);
        double[] returnNums = new double[0];

        for(int i =0; i < stringSplit.length; i++){
            returnNums = addDouble(returnNums, Double.parseDouble(stringSplit[i]));
        }

        return returnNums;
    }

    private double[] addDouble(double[] arr, double element){
        double[] tempArr = new double[arr.length+1];

        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        tempArr[arr.length] = element;

        return tempArr;
    }

    private double[] addDoubleArray(double[] arr1, double[] arr2){
        double[] tempArr = new double[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, tempArr, 0, arr1.length);
        System.arraycopy(arr2, 0, tempArr, arr1.length, arr2.length);
  
        return tempArr;
    }
}