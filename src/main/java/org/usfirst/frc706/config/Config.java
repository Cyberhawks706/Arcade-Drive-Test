package org.usfirst.frc706

import org.usfirst.frc706

import edu.wpi.first.wpilibj.DriverStation;

public final class Config {

   public static ConfigurableBool testBool = new ConfigurableBool("TESTBOOL", true);
   public static ConfigurableNumber testNumber = new ConfigurableNumber("TESTNUMBER", 0);
   public static ConfigurableString testString = new ConfigurableNumber("TESTSTRING", "TRUE");

   }