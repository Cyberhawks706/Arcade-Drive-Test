package org.usfirst.frc706;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.*;

//import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

//color stuff
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.util.Color;


public class Robot extends TimedRobot {

	public static boolean emergencyDisabled = false;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static IO oi;
	
	
	public static boolean auto;
	public static DriverStation driverStation;
	public static TalonSRX _talon;
	public static UsbCamera drivercam;
	public static UsbCamera drivercam2;
	public static UsbCamera visioncam;

	public Color detectColor;

	

	private final I2C.Port i2cport = I2C.Port.kOnboard;

	public ColorSensorV3 colorSensor = new ColorSensorV3(i2cport);

	public void robotInit() {
		System.out.println("Started");
		Components.init();
		oi = new IO();
		
		
		driverStation = DriverStation.getInstance();
		auto = driverStation.isAutonomous();
		Components.ahrs.calibrate();
		CameraServer.getInstance().startAutomaticCapture();

		

	}
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		Auton.run();
	}

	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();	
	}

}


