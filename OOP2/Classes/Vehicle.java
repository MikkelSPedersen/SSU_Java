package OOP2.Classes;

/**
 * Vehicle
 */
public class Vehicle implements RailVehicle{
    private String _type;
    private int _number = 0;
    private String _cargo;
    private float _speed = 0;

    public Vehicle(String type, int number, String cargo){
        _type = type;
        _number = number;
        _cargo = cargo;
    }

    public void print() {
        System.out.println(_type + ":" + _number + ":" + _cargo);
    }

    public void setCargo(String load) {
        _cargo = load;
    }
    /* Ikke relevant for opgaven, men nice to have */
    public String getType(){
        return _type;
    }
    public float getSpeed(){
        return _speed;
    }
    public int getNumber(){
        return _number;
    }
    public String getCargo(){
        return _cargo;
    }
}