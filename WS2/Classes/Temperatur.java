package Classes;

public class Temperatur extends Data{
	
	public Temperatur(){
		super(0);
	}
	
	public Temperatur(double data){
		super(data);
	}

	public double GetValue(){
		return super.getValue();
	}

	public void SetValue(double value){
		super.setValue(value);
	}
}
