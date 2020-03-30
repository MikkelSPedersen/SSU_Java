import Classes.*;
import Threads.*;
import GUI.*;

public class Main {
    private static DataOpbevaring _DataOp;
    private static DataGenerator _dataGenerator;
    private static DataBehandler _dataBehandler;
    private static GUI Screen;
    public static void main(String[] args) {
        _DataOp = new DataOpbevaring();
        
        _dataGenerator = new DataGenerator(_DataOp, 10000);
        _dataBehandler = new DataBehandler(_DataOp, "Output.txt");
        Screen = new GUI("Screen", _dataGenerator, _dataBehandler);
        _DataOp.SetGUI(Screen);
        _dataGenerator.start();
        _dataBehandler.start();
    }

}