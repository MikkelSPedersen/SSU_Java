package Threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Classes.*;

public class DataBehandler extends Thread {

    private DataOpbevaring _DataOp;
    private FileWriter _FileWriter;
    private BufferedWriter _BuffWriter;
    private PrintWriter _PrintWriter;

    public DataBehandler(DataOpbevaring dataOp, String path) {
        _DataOp = dataOp;
        try {
            _FileWriter = new FileWriter(path, true);
            _BuffWriter = new BufferedWriter(_FileWriter);
            _PrintWriter = new PrintWriter(_BuffWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            WriteData(_DataOp.ListenForData());
        }
    }

    private void WriteData(DataSet data){
        _PrintWriter.println("|" +
                                "Temp: " + data.Temp.GetValue() + 
                                "°C, Luft: " + data.Hum.GetValue() + 
                                "%, Regn: " + data.Regn.GetValue() + 
                            " mm/hr|");

        _PrintWriter.flush();
        System.out.println("New Data Written");
    }

    public void closeFileWriter(){
        try {
            _PrintWriter.close();
            _BuffWriter.close();
            _FileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}