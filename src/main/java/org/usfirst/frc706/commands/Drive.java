package org.usfirst.frc706.commands;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.usfirst.frc706.Components;
import org.usfirst.frc706.IO;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	
	
	int stepsToTake;

	double XboxX; 
	double XboxY; 
	double XboxT; 

	public Drive() {
		requires(Components.chassis);
	}

	public double zero(double Xboxvalue, double DeadZone){
		xboxValue = XboxValue;
		if(Math.abs(xboxValue)<DeadZone){
				xboxValue = 0;
			}

		return xboxValue;
	}

	public void execute(){
			 //DRIVE CODE!!
			
			//Adding DeadZone
			xboxX = this.zero(IO.xboxDrive.getLeftY(), Components.IO.xboxDeadband);
			xboxY = this.zero(IO.xboxDrive.getLeftX(), Components.IO.xboxDeadband);
			xboxT = this.zero(IO.xboxDrive.getRightX(), Components.IO.xboxDeadband);

			//Drive 

	}

	protected void initialize() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
