package FLL;
import EV3.*;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
public class test {

	public static void main(String[] args) {
		
		BrickButtons.waitForAnyPress();
		//Controller.setRobotDetails(8, 10, Ports.A, Ports.D);
		MoveSteering2.setPilot(new EV3LargeRegulatedMotor(Ports.A), new EV3LargeRegulatedMotor(Ports.D), 8, 10);
		MoveSteering2.onForDegrees(7, -10, 50, true);
			
	}
	
}
