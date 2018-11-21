package EV3;

import EV3Library.UltraSonic;

public class UltraSonicSensor { // Done!

	UltraSonic uss;
	
	public UltraSonicSensor(int port) {
		uss = new UltraSonic(Controller.intToPort(port));
	}
	
	public double distance() {
		return uss.getRange();
	}
	
	public void close() {
		uss.close();
	}

}
