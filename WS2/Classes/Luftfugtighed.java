package Classes;

public class Luftfugtighed extends Data {

	public Luftfugtighed(){
		super(0);
	}
	
	public Luftfugtighed(double data){
		super(data);
	}

	public double GetValue(){
		return super.getValue();
	}

	public void SetValue(double value){
		super.setValue(value);
	}
}
