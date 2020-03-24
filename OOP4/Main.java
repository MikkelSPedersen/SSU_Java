package OOP4;

import OOP4.Threads.*;

public class Main{
    public static void main(String[] args) {
        // Opgave 1
        // Udkommentere understående for dette
        //new Hello5Thread(0).start();

        // Opgave 2
        // Udkommentere understående for dette
        /*
        for(int i = 0; i < 5; i++){
            new Hello5Thread(i).start();
        }
        */
        // Outputtet kommer i forskellig rækkefølge, dog kan det forkomme det vil være samme.
        // Dette er forventet da trådene kører "på samme tid" næsten, altså vil det være
        // forskelligt hvornår en trådene kører deres del

        // Opgave 3
        String[] filterWords = {"fuck", "dick"}; // Filter ord i all lowercase
        // Generere begge tråde, hvorefter kendskabet mellem dem etableres
        InputThread inputThread = new InputThread();
        FilterThread filterThread = new FilterThread(filterWords, inputThread);
        inputThread.setTargetThread(filterThread);
        //Trådene startes
        inputThread.start();
        filterThread.start();
        // Note: Programmet kører i et loop
    }
}