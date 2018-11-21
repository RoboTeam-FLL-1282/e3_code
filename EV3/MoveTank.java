package EV3;
import lejos.utility.Delay;
public abstract class MoveTank { // Done!

	public static void onForRotations(int leftSpeed, int rightSpeed, int rotations, boolean brakeAtEnd) {
		Controller.getLeftWheel().setSpeed(leftSpeed);
		Controller.getRightWheel().setSpeed(rightSpeed);
		Controller.getLeftWheel().forward();
		Controller.getRightWheel().forward();
		Delay.msDelay(((rotations*360)/leftSpeed)*1000);
		if(brakeAtEnd) {
			Controller.getLeftWheel().stop(true);
			Controller.getRightWheel().stop(true);
		}
	}

	public static void onForDegrees(int leftSpeed, int rightSpeed, int degrees, boolean brakeAtEnd) {
		Controller.getLeftWheel().setSpeed(leftSpeed);
		Controller.getRightWheel().setSpeed(rightSpeed);
		Controller.getLeftWheel().forward();
		Controller.getRightWheel().forward();
		Delay.msDelay((degrees/leftSpeed)*1000);
		if(brakeAtEnd) {
			Controller.getLeftWheel().stop(true);
			Controller.getRightWheel().stop(true);
		}
	}

	public static void onForSeconds(int leftSpeed, int rightSpeed, int seconds, boolean brakeAtEnd) {
		Controller.getLeftWheel().setSpeed(leftSpeed);
		Controller.getRightWheel().setSpeed(rightSpeed);
		Controller.getLeftWheel().forward();
		Controller.getRightWheel().forward();
		Delay.msDelay(seconds*1000);
		if(brakeAtEnd) {
			Controller.getLeftWheel().stop(true);
			Controller.getRightWheel().stop(true);
		}
	}

	public static void on(int leftSpeed, int rightSpeed) {
		Controller.getLeftWheel().setSpeed(leftSpeed);
		Controller.getRightWheel().setSpeed(rightSpeed);
		Controller.getLeftWheel().forward();
		Controller.getRightWheel().forward();
	}

	public static void off() {
		Controller.getLeftWheel().stop(true);
		Controller.getRightWheel().stop(true);
	}
	
	// Use when the motor is no longer needed.
	public static void close() {
		Controller.getLeftWheel().close();
		Controller.getRightWheel().close();
	}
	
}
