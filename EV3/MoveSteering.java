package EV3;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;
@SuppressWarnings("deprecation")
public abstract class MoveSteering { // Needs check...

	static DifferentialPilot dp;
	
	public static void setPilot(double wheelDiameter, double trackWidth, 
			NXTRegulatedMotor leftMotor, NXTRegulatedMotor rightMotor) {
		dp = new DifferentialPilot(wheelDiameter, trackWidth, leftMotor, rightMotor);
	}
	
	public static void onForRotation(int steering, int speed, int rotations, boolean brakeAtEnd) {
		dp.setLinearSpeed(speed);
		dp.steer(100, steering, true);
		Delay.msDelay(((rotations*360)/speed)*1000);
		if(brakeAtEnd) {
			dp.stop();
		}
	}

	public static void onForDegrees(int steering, int speed, int degrees, boolean brakeAtEnd) {
		dp.setLinearSpeed(speed);
		dp.steer(steering);
		Delay.msDelay((degrees/speed)*1000);
		if(brakeAtEnd) {
			dp.stop();
		}
	}

	public static void onForSeconds(int steering, int speed, int seconds, boolean brakeAtEnd) {
		dp.setLinearSpeed(speed);
		dp.steer(steering);
		Delay.msDelay(seconds*1000);
		if(brakeAtEnd) {
			dp.stop();
		}
	}

	public static void on(int steering, int speed) {
		dp.setLinearSpeed(speed);
		dp.steer(steering);
	}

	public static void off() {
		dp.stop();
	}
}
