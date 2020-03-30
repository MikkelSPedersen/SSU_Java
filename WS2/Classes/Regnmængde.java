package Classes;

public class Regnmængde extends Data {

	public Regnmængde(){
		super(0);
	}
	
	public Regnmængde(double data){
		super(data);
	}

	public double GetValue(){
		return super.getValue();
	}

	public void SetValue(double value){
		super.setValue(value);
	}
}
