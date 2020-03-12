package OOP2;

import java.*;
import OOP2.Classes.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Creating train");
        RailVehicle[] Train_Passenger = createPassengerTrain();
        RailVehicle[] Train_Cargo = createCargoTrain();
        System.out.println("Train created: ");
        printTrainInfo(Train_Passenger);
        printTrainInfo(Train_Cargo);
    }

    private static RailVehicle[] createPassengerTrain(){
        RailVehicle[] temp = new RailVehicle[4];
        temp[0] = new Locomotive(1, "Lokofører");
        temp[1] = new PassengerCar(2, "22 Passagerer");
        temp[2] = new PassengerCar(3, "25 Passagerer");
        temp[3] = new PassengerCar(4, "30 Passagerer");
        return temp;
    }
    private static RailVehicle[] createCargoTrain(){
        RailVehicle[] temp = new RailVehicle[4];
        temp[0] = new Locomotive(1, "Lokofører");
        temp[1] = new BulkCar(2, "Mad");
        temp[2] = new BulkCar(3, "Corona(øl self)");
        temp[3] = new Tanker(4, "30L Oile");
        return temp;
    }

    private static void printTrainInfo(RailVehicle[] train){
        System.out.println("Nyt tog.");
        for(int i = 0; i < train.length; i++){
            train[i].print();
        }
    }
}