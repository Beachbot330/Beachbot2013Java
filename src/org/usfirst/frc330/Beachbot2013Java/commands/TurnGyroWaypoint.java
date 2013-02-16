/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc330.Beachbot2013Java.commands;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.AutoSpreadsheetCommand;
import org.usfirst.frc330.Beachbot2013Java.Robot;

/**
 *
 * @author joe
 */
public class TurnGyroWaypoint extends TurnGyroAbs {
    double x, y;
    public TurnGyroWaypoint()
    {
        super(0,0,0,true);
    }

    protected void initialize() {
        calcAngle(x, y);
        super.initialize();
    }

    public AutoSpreadsheetCommand copy() {
        return new TurnGyroWaypoint();
    }
    
     /**
     * The first parameter in the AutoSpreadsheet
     * @param distance The distance to drive
     */
    public void setParam1(double x) {
        this.x = x;
    }
    /**
     * The second parameter in the AutoSpreadsheet
     * @param angle The angle to maintain while driving
     */
    public void setParam2(double y) {
        this.y = y;
    }
    
    public void setParam3(double tolerance)
    {
        super.setParam2(tolerance);
    }
    
    
    private void calcAngle(double x, double y) {
        double curX, curY, deltaX, deltaY, calcAngle;
        
        curX = Robot.chassis.getX();
        curY = Robot.chassis.getY();
        
        deltaX = x - curX;
        deltaY = y - curY;
        
        calcAngle = Math.toDegrees(MathUtils.atan2(deltaX, deltaY));
        
        if (Math.abs(Robot.chassis.getAngle()-calcAngle)<180)
        {
            calcAngle=calcAngle;
        }
        else if (Robot.chassis.getAngle() > calcAngle)
        {
            calcAngle += 360;
        }
        else
        {
            calcAngle -= 360;
        }
        System.out.println("angle: " + calcAngle);
        
        super.setParam1(calcAngle);
    }
}