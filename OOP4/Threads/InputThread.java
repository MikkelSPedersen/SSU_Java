package OOP4.Threads;

import java.util.Scanner;

public class InputThread extends Thread{

    // Private globale objekter som bruges i tråden
    private FilterThread _TargetThread;
    private Scanner _Keyboard;
    private String _FilteredString;
    private boolean _NewData;

    // Constructen for tråden, som instansiere scanner objektet til at registrere input fra tastaturet
    public InputThread(){
        _Keyboard = new Scanner(System.in);
    }

    // Set method til at finde filter tråden
    public void setTargetThread(FilterThread targetThread){
        _TargetThread = targetThread;
    }

    synchronized public void run(){
        System.out.println("InoutThread Started");
        // Kører funktionen i et konstant loop
        while(true){
            // Håndtere input og vidergivning af data til filtertråden
            System.out.println("Write a String");
            String inputString = _Keyboard.nextLine();
            _TargetThread.SetStringToFilter(inputString);
            
            //Venter til filtertråden har filtreret strengen, altså indtil notify bliver kaldt
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Printer den filtrerede streng
            if(_NewData){
                System.out.println("Filterede input is: ");
                System.out.println(_FilteredString);
                System.out.println("");System.out.println("");
                _NewData = false;
            }
        }
        
    }

    // Funktionen til at modtage den filtreret streng, som også kalder notify
    synchronized public void SetFilteredString(String string){
        _FilteredString = string;
        _NewData = true;
        notifyAll();
    }
}