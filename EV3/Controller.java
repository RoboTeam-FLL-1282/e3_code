package EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

public abstract class Controller { // Fine...

	private static double wheelDiameter = 6.24;
	private static double trackWidth = 10;
	private static EV3LargeRegulatedMotor leftWheel = new EV3LargeRegulatedMotor(Ports.A);
	private static EV3LargeRegulatedMotor rightWheel = new EV3LargeRegulatedMotor(Ports.B);
	
	static Port stringToPort(String port) { 
		switch(port) {
		case "a":
			return MotorPort.A;
		case "b":
			return MotorPort.B;
		case "c":
			return MotorPort.C;
		case "d":
			return MotorPort.D;
		case "A":
			return MotorPort.A;
		case "B":
			return MotorPort.B;
		case "C":
			return MotorPort.C;
		case "D":
			return MotorPort.D;
		}
		return null;
	}

	static Port charToPort(char port) { 
		
		switch(port) {
		case 'a':
			return MotorPort.A;
		case 'b':
			return MotorPort.B;
		case 'c':
			return MotorPort.C;
		case 'd':
			return MotorPort.D;
		case 'A':
			return MotorPort.A;
		case 'B':
			return MotorPort.B;
		case 'C':
			return MotorPort.C;
		case 'D':
			return MotorPort.D;
		}
		
		return null;
	}
	
	static Port intToPort(int port) {
		
		switch(port) {
		case 1:
			return SensorPort.S1;
		case 2:
			return SensorPort.S2;
		case 3:
			return SensorPort.S3;
		case 4:
			return SensorPort.S4;
		}
		
		return null;

	}
	
	public static void setRobotDetails(double wheelDiameter, double trackWidth, Port leftWheelPort, Port rightWheelPort) {
		Controller.wheelDiameter = wheelDiameter;
		Controller.trackWidth = trackWidth;
		leftWheel = new EV3LargeRegulatedMotor(leftWheelPort);
		rightWheel = new EV3LargeRegulatedMotor(rightWheelPort);
		MoveSteering2.setPilot(new EV3LargeRegulatedMotor(leftWheelPort), new EV3LargeRegulatedMotor(rightWheelPort), trackWidth, wheelDiameter);
	}
	
	public static void setWheelDiameter(double wheelDiameter) {
		Controller.wheelDiameter = wheelDiameter;
	}
	
	public static void setTrackWidth(double trackWidth) {
		Controller.trackWidth = trackWidth;
	}
	
	public static void setMainMotors(String leftWheelPort, String rightWheelPort) {
		Controller.leftWheel = new EV3LargeRegulatedMotor(stringToPort(leftWheelPort));
		Controller.rightWheel = new EV3LargeRegulatedMotor(stringToPort(rightWheelPort));
	}
	
	public static double getWheelDiameter() {
		return wheelDiameter;
	}
	
	public static double getTrackWidth() {
		return trackWidth;
	}
	
	public static EV3LargeRegulatedMotor getLeftWheel() {
		return Controller.leftWheel;
	}
	
	public static EV3LargeRegulatedMotor getRightWheel() {
		return Controller.rightWheel;
	}

	public static void resetLeftWheelDegrees() {
		leftWheel.resetTachoCount();
	}
	
	public static void resetRightWheelDegrees() {
		rightWheel.resetTachoCount();
	}
	
	public static double getLeftWheelDegrees() {
		return leftWheel.getTachoCount();
	}
	
	public static double getRightWheelDegrees() {
		return rightWheel.getTachoCount();
	}
	
	public static void close() {
		leftWheel.close();
		rightWheel.close();
	}
}
