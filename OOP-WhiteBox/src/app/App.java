package app;

public class App {

    enum DangerLevel {
        none, 
        moderate, 
        high, 
        veryhigh
    };

    static int maxTemp = 99;

    public static void main(String[] args) {

        DangerLevel danger = checkTemperature( new int[]{10, 90, 10} );
        
        System.out.println("Danger level is: " + danger);
    }

    private static DangerLevel checkTemperature(int[] temps){
        int highcount = 0;
        DangerLevel danger = DangerLevel.none;
        if (temps[0] > maxTemp)
            highcount = 1;
        if (temps[1] > maxTemp)
            highcount = highcount + 1;
        if (temps[2] > maxTemp)
            highcount = highcount + 1;

        if (highcount == 1)
            danger = DangerLevel.moderate;
        if (highcount == 2)
            danger = DangerLevel.high;
        if (highcount == 3)
            danger = DangerLevel.veryhigh;
            
        return danger;
    }
    
}