package org.usfirst.frc706ystems;




import org.usfirst.frc706..Components;

import org.usfirst.frc706..IO;


import org.usfirst.frc706..commands.Drive;
import org.usfirst.frc706..config.Config;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Chassis extends Subsystem {


	public static boolean piInControl = false;

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
		
	}

	int valuesAdded = 0;
	double gyroTotal = 0;
	int totalValues = 10;
	
	public double extendOffset = 0;
    public double rotationOffset = 0;

	public void periodic() {
	

		if(valuesAdded < totalValues){
			gyroTotal += (double) Components.ahrs.getYaw();
			valuesAdded++;
		}else{
			valuesAdded = 0;
			Config.gyroAngle.value = gyroTotal/ ((double) totalValues);
			gyroTotal = 0;
		}

		if(IO.xboxDrive.getAButtonPressed())Components.ahrs.calibrate();//calibrate when needed
		if(IO.xboxDrive.getYButtonPressed())Components.ahrs.zeroYaw();


		//DRIVE CODE!!
		double xboxRightJoyX = (IO.xboxDrive.getRightX() - 0.5)*2;
		double xboxRightJoyY = (IO.xboxDrive.getRightY() - 0.5)*2;
		double xboxLeftJoyX = IO.xboxDrive.getLeftX() - 0.5;
		
		double driveAngle = 0;
		double power = Math.sqrt(Math.pow(xboxRightJoyX, 2) + Math.pow(xboxRightJoyY, 2))/1;
		
		if(xboxRightJoyX != 0 && xboxRightJoyY != 0){
			driveAngle = Math.tan(xboxRightJoyY/xboxRightJoyX)+(Math.PI/2);
		}
		
		if(driveAngle > Math.PI){
			driveAngle = driveAngle%(Math.PI);
		} else if ( driveAngle < 0){
			driveAngle = driveAngle%(Math.PI) + (Math.PI);
		}

		Components.sparkWheelTurnFR.setPos(driveAngle/(2*Math.PI));
		Components.sparkWheelTurnFL.setPos(driveAngle/(2*Math.PI));
		Components.sparkWheelTurnBR.setPos(driveAngle/(2*Math.PI));
		Components.sparkWheelTurnBL.setPos(driveAngle/(2*Math.PI));

		Components.sparkWheelFR.setVel(power);
		Components.sparkWheelFL.setVel(power);
		Components.sparkWheelBR.setVel(power);
		Components.sparkWheelBL.setVel(power);

		SmartDashboard.putNumber("Potentiometer Value", driveAngle);

		


		
	}
 
	public double previousAngle = 0;

	public void zeroAllMotors() {

	}
	public void Drive(double leftSpeed, double rightSpeed) {
		
	}

	public void ShootyShoot(double leftSpeed, double rightSpeed){

	}
}
