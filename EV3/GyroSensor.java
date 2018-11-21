package EV3;

import EV3Library.Gyro;

public class GyroSensor { // Done!

	Gyro gs;
	
	public GyroSensor(int port) {
		gs = new Gyro(Controller.intToPort(port));
	}
	
	public double angle() {
		return gs.getAngle();
	}
	
	public double rate() {
		return gs.getAngularVelocity();
	}
	
	public void reset() {
		gs.reset();
	}
	
	public void recalibrate() {
		gs.resetGyro();
	}
	
	public void close() {
		gs.close();
	}
}
