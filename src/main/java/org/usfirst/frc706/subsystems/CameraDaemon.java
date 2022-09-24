package org.usfirst.frc706stems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraDaemon extends Subsystem{

    UsbCamera cam1;
    UsbCamera cam2;

    VideoSink server;

    
    public void robotInit() {
        cam1 = CameraServer.startAutomaticCapture(0);
        cam2 = CameraServer.startAutomaticCapture(0);

        server = CameraServer.getServer();

        cam1.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
        cam2.setConnectionStrategy(ConnectionStrategy.kKeepOpen);

        
    }


    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }
}
