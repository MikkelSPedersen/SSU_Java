package OOP4.Threads;

import java.util.Arrays;
import java.util.List;

public class FilterThread extends Thread {

    // Private globale objekter som bruges i tråden
    private List<String> _FilterWords;
    private InputThread _TargetThread;
    private String _StringToFilter;
    private boolean _NewInput;

    // Constructer
    public FilterThread(String[] filterWords, InputThread targetThread) {
        _FilterWords = Arrays.asList(filterWords);
        _TargetThread = targetThread;
    }

    synchronized public void run() {
        System.out.println("FilterThread Started");
        // Kører funktionen i et konstant loop
        while (true) {
            // Venter til notify bliver kaldt
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // Hvis nyt input, filtrere dette
            if(_NewInput == true){
                filterString(_StringToFilter);
                _NewInput = false;
            }
        }
    }

    // Funktionen til at modtage strengen som skal filtreres, kalder notify
    synchronized public void SetStringToFilter(String string){
        _StringToFilter = string;
        _NewInput = true;
        notifyAll();
    }

    // Funktion til at filtrere strengen
    private void filterString(String stringTofilter){
        String filteredString = new String();

        System.out.print("Filtering Input...");

        // Splitter strengen op i individuelle ord
        String[] splitString = stringTofilter.split("\\s+");
        // Looper igennem alle ord
        for (String string : splitString) {
            // Hvis ordet er indenholdt i listen af filtreret ord, erstat med ***
            // Ellers skrives det originale ord
            if(_FilterWords.contains(string.toLowerCase())){
                filteredString += "*** ";
            }
            else{
                filteredString += string + " ";
            }
        }

        // Sender den filtrerede streng tilbage til input tråden
        _TargetThread.SetFilteredString(filteredString);
    }
}