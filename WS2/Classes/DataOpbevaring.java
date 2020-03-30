package Classes;

import java.util.*;

import GUI.GUI;

public class DataOpbevaring {
    private List<DataSet> dataList = new ArrayList<DataSet>();
    private GUI _GUI;

    synchronized public void AddData(DataSet data) {
        dataList.add(data);
        System.out.println("New Data Added");
        _GUI.AddData(data);
        notifyAll();
    }

    public List<DataSet> GetData() {
        return dataList;
    }

    public void DeleteAll() {
        dataList.clear();
    }

    synchronized public DataSet ListenForData() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dataList.get(dataList.size() -1);
    }

    public void SetGUI(GUI gui){
        _GUI = gui;
    }
}