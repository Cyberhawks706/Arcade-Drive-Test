package org.usfirst.frc706..subsystems;

import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Limelight extends Subsystem{

    private HttpCamera limelightFeed;

    public void robotInit(){
        limelightFeed = new HttpCamera("lightlight", "http://10.7.6.65:5800");
    }
    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }
    
}
