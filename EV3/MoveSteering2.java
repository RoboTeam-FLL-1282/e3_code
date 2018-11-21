package EV3;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class MoveSteering2 {

	static MovePilot pilot;
	
	public static void setPilot(EV3LargeRegulatedMotor leftMotor, EV3LargeRegulatedMotor rightMotor, double TrackWidth, double WheelDiameter) {
		Wheel leftWheel = WheeledChassis.modelWheel(leftMotor, WheelDiameter).offset((-1)*(TrackWidth/2));
		Wheel rightWheel = WheeledChassis.modelWheel(rightMotor, WheelDiameter).offset((TrackWidth/2));
		Chassis chassis = new WheeledChassis(new Wheel[] {leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		pilot = new MovePilot(chassis);
	}
	
	public static void onForRotation(int steering, int speed, int rotations, boolean brakeAtEnd) {
		pilot.setLinearSpeed(speed);
		if(speed >= 0)
			pilot.arcForward(steering);
		else
			pilot.arcBackward(steering);
		Delay.msDelay(((rotations*360)/speed)*1000);
		if(brakeAtEnd) {
			pilot.stop();
		}
	}
	
	public static void onForDegrees(int steering, int speed, int degrees, boolean brakeAtEnd) {
		pilot.setLinearSpeed(speed);
		if(speed >= 0)
			pilot.arcForward(steering);
		else
			pilot.arcBackward(steering);
		Delay.msDelay((degrees/speed)*1000);
		if(brakeAtEnd) {
			pilot.stop();
		}
	}
	
	public static void onForSeconds(int steering, int speed, int seconds, boolean brakeAtEnd) {
		pilot.setLinearSpeed(speed);
		if(speed >= 0)
			pilot.arcForward(steering);
		else
			pilot.arcBackward(steering);
		Delay.msDelay(seconds*1000);
		if(brakeAtEnd) {
			pilot.stop();
		}
	}
	
	public static void on(int steering, int speed) {
		pilot.setLinearSpeed(speed);
		if(speed >= 0)
			pilot.arcForward(steering);
		else
			pilot.arcBackward(steering);
	}
	
	public static void off() {
		pilot.stop();
	}
}
