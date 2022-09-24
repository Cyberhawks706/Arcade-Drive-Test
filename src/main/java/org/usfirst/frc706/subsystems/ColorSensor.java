package org.usfirst.frc706..subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


public final class ColorSensor extends Subsystem {

	/**
	 * Finds the strongest color in an RGB array.
	 * @param colors An array containing an R, G, and B value.
	 * @return The index of the strongest color.
	 */
    private int findStrongestColor(double[] colors) {
        int greatestIndex = 0;
        for (int i = 0; i < colors.length; ++i) {
            if (i==0)
                continue;
            else if (Math.max(colors[i], colors[greatestIndex]) == colors[i])
                greatestIndex = i;
        }
        return greatestIndex;
    }

	public void initDefaultCommand() {
        //No default command
	}

	public void periodic() {
	}

}