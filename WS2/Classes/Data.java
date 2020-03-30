package Classes;

public class Data {
	private double dataValue;
	
	protected Data(double value){
		dataValue = value;
	}

	protected double getValue() {
		return dataValue;
	}
	
	protected void setValue(double newValue) {
		this.dataValue = newValue;
	}
}
