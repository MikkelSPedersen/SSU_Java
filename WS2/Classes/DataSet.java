package Classes;

public class DataSet {

    public Temperatur Temp;
    public Luftfugtighed Hum;
    public Regnmængde Regn;

    public DataSet(){
        Temp = new Temperatur();
        Hum = new Luftfugtighed();
        Regn = new Regnmængde();
    }

    public void printData(){
        System.out.print("Temp: ");System.out.println(Temp.getValue());
        System.out.print("Humi: ");System.out.println(Hum.getValue());
        System.out.print("Regn: ");System.out.println(Regn.getValue());
    }
    
}