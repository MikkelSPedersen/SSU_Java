package Threads;

import java.util.Random;

import Classes.DataOpbevaring;
import Classes.DataSet;

public class DataGenerator extends Thread {

    private final int _RefreshTimer;
    private final DataOpbevaring _DataOp;
    private boolean _Paused = true;

    public DataGenerator(final DataOpbevaring dataOp, final int refreshTimer) {
        _RefreshTimer = refreshTimer;
        _DataOp = dataOp;
    }

    synchronized public void run() {
        while (true) {
            if (!_Paused) {
                final DataSet tempSet = new DataSet();

                tempSet.Temp.SetValue(doubleInRange(-50, 50));
                tempSet.Hum.SetValue(doubleInRange(0, 100));
                tempSet.Regn.SetValue(doubleInRange(0, 20));

                _DataOp.AddData(tempSet);

                try {
                    wait(_RefreshTimer);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private double doubleInRange(final double min, final double max) {
        final Random r = new Random();
        double randomNum = min + (max - (min)) * r.nextDouble();
        return Math.round(randomNum * 100.0) / 100.0;
    }

    synchronized public void StartGenerator() {
        if(_Paused){
            _Paused = false;
            notifyAll();
        }
    }
    public void StopGenerator() {
        _Paused = true;
    }
}