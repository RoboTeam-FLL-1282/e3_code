package EV3;

import EV3Library.Touch;

public class TouchSensor { // Done!
	
	Touch ts;
	
	public TouchSensor(int port) {
		ts = new Touch(Controller.intToPort(port));
	}
	
	public boolean isTouched() {
		return ts.isTouched();
	}
	
	public void close() {
		ts.close();
	}
	
}
