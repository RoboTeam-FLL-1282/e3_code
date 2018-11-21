package EV3;

import lejos.hardware.motor.UnregulatedMotor;

public class MotorRotation {// Done!
	
	UnregulatedMotor motor;
	
	public MotorRotation(String port) {
		motor = new UnregulatedMotor(Controller.stringToPort(port));
	}
	
	public double degrees() {
		return motor.getTachoCount();
	}
	
	public double rotations() {
		return motor.getTachoCount()/360.0;
	}
	
	public void reset() {
		motor.resetTachoCount();
	}
	
	public void close() {
		motor.close();
	}
}
