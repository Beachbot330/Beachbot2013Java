// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc330.Beachbot2013Java.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2013Java.RobotMap;
import org.usfirst.frc330.Beachbot2013Java.commands.*;
import org.usfirst.frc330.wpilibj.BeachbotPrefSendablePIDController;
import org.usfirst.frc330.wpilibj.DummyPIDOutput;
/**
 *
 */
public class Chassis extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftDriveJaguar1 = RobotMap.chassisLeftDriveJaguar1;
    SpeedController leftDriveJaguar2 = RobotMap.chassisLeftDriveJaguar2;
    SpeedController rightDriveJaguar1 = RobotMap.chassisRightDriveJaguar1;
    SpeedController rightDriveJaguar2 = RobotMap.chassisRightDriveJaguar2;
    RobotDrive robotDrive = RobotMap.chassisRobotDrive;
    Gyro gyro = RobotMap.chassisGyro;
    Encoder leftDriveEncoder = RobotMap.chassisLeftDriveEncoder;
    Encoder rightDriveEncoder = RobotMap.chassisRightDriveEncoder;
    Compressor compressor = RobotMap.chassisCompressor;
    DoubleSolenoid shiftSolenoid = RobotMap.chassisShiftSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public BeachbotPrefSendablePIDController gyroPIDLow, gyroPIDHigh,
                        leftDrivePIDLow, rightDrivePIDLow, leftDrivePIDHigh, rightDrivePIDHigh;
    private DummyPIDOutput gyroOutputLow, gyroOutputHigh, 
                        leftDriveOutputLow, rightDriveOutputLow, leftDriveOutputHigh, rightDriveOutputHigh;
    
    double leftManual = 0;
    double rightManual = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new TankDrive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Chassis (){
        compressor.start();
        
        robotDrive.setSafetyEnabled(false);
        
        gyroOutputLow = new DummyPIDOutput();
        gyroOutputHigh = new DummyPIDOutput();
        leftDriveOutputLow = new DummyPIDOutput();
        rightDriveOutputLow = new DummyPIDOutput();
        leftDriveOutputHigh = new DummyPIDOutput();
        rightDriveOutputHigh = new DummyPIDOutput();
        
        gyroPIDLow = new BeachbotPrefSendablePIDController(0.11,0,0,gyro,gyroOutputLow,"gyroLow");
        gyroPIDHigh = new BeachbotPrefSendablePIDController(0.05,0,0,gyro,gyroOutputLow,"gyroHigh");
        leftDrivePIDLow = new BeachbotPrefSendablePIDController(0.2,0,0,leftDriveEncoder,leftDriveOutputLow,"leftDriveLow");
        rightDrivePIDLow = new BeachbotPrefSendablePIDController(0.2,0,0,rightDriveEncoder,rightDriveOutputLow,"rightDriveLow");
        leftDrivePIDHigh = new BeachbotPrefSendablePIDController(0.013,0,0,leftDriveEncoder,leftDriveOutputHigh,"leftDriveHigh");
        rightDrivePIDHigh = new BeachbotPrefSendablePIDController(0.013,0,0,rightDriveEncoder,rightDriveOutputHigh,"rightDriveHigh");
        
        leftDrivePIDLow.setOutputRange(-0.8, 0.8);
        rightDrivePIDLow.setOutputRange(-0.8, 0.8);
        leftDrivePIDHigh.setOutputRange(-0.8, 0.8);
        rightDrivePIDHigh.setOutputRange(-0.8, 0.8);
        
        SmartDashboard.putData("gyroPIDLow", gyroPIDLow);
        SmartDashboard.putData("gyroPIDHigh", gyroPIDHigh);
        SmartDashboard.putData("leftDrivePIDLow", leftDrivePIDLow);
        SmartDashboard.putData("rightDrivePIDLow", rightDrivePIDLow);
        SmartDashboard.putData("leftDrivePIDHigh", leftDrivePIDHigh);
        SmartDashboard.putData("rightDrivePIDHigh", rightDrivePIDHigh);
        final double diameter = 6;
        final double PulseperRevolution = 250;
        final double encoderGearRatio = 3;
        final double gearRatio = 64/20;
        final double Fudgefactor = 0.94;
        final double distanceperpulse = Math.PI*diameter/PulseperRevolution/encoderGearRatio/gearRatio * Fudgefactor;
        leftDriveEncoder.setDistancePerPulse(distanceperpulse);
        rightDriveEncoder.setDistancePerPulse(distanceperpulse);
    }
    
    public double getDriveRampStepHigh() {
        if (!Preferences.getInstance().containsKey("DriveRampMaxOutpuStepHigh"))
        {
            Preferences.getInstance().putDouble("DriveRampMaxOutpuStepHigh", 
                                                0.02);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("DriveRampMaxOutpuStepHigh",
                                                   0.02);
    }
    public double getDriveRampStepLow() {
        if (!Preferences.getInstance().containsKey("DriveRampMaxOutpuStepLow"))
        {
            Preferences.getInstance().putDouble("DriveRampMaxOutpuStepLow", 
                                                0.02);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("DriveRampMaxOutpuStepLow", 
                                                   0.02);
    }
    
    public void tankDrive(Joystick leftJoystick, Joystick rightJoystick)
    {
        leftManual = leftJoystick.getY();
        rightManual = rightJoystick.getY();
//        robotDrive.tankDrive(leftJoystick, rightJoystick, false);
    }
    
    public void tankDrive(double left, double right)
    {
        leftManual = left;
        rightManual = right;
//        robotDrive.tankDrive(left, right, false);
    }
    
    public void shiftHigh()
    {
        shiftSolenoid.set(DoubleSolenoid.Value.kForward);
//        System.out.println("Shifting into High");
    }
    
    public void shiftLow()
    {
        shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
//        System.out.println("Shifting into Low");
    }
    public boolean getShiftState()
    {
//        System.out.println("Shift State: " + shiftSolenoid.get());
        if(shiftSolenoid.get() == Value.kForward) 
            return true;
        else
            return false;
    }
    
    double maxGyroRate = 0;
    
    public void pidDrive()
    {
        double left, right;
        double gyroRate;
        gyroRate = Math.abs(AnalogModule.getInstance(1).getVoltage(1)/0.007); //TODO need to subtract gyro calibrated value
        if (gyroRate > maxGyroRate)
            maxGyroRate = gyroRate;
        if (DriverStation.getInstance().isDisabled())
        {
            stopDrive();
        }
        else
        {
            SmartDashboard.putNumber("leftEncoder", getLeftDistance());
            SmartDashboard.putNumber("rightEncoder", getRightDistance());
            SmartDashboard.putNumber("Gyro", getAngle());
            SmartDashboard.putNumber("GyroRate", gyroRate);
            SmartDashboard.putNumber("MaxGyroRate", maxGyroRate);
            left = leftManual-leftDriveOutputLow.getOutput() - leftDriveOutputHigh.getOutput() - gyroOutputLow.getOutput();
            right = rightManual-rightDriveOutputLow.getOutput() - rightDriveOutputHigh.getOutput() + gyroOutputLow.getOutput();
            robotDrive.tankDrive(left, right,false);
        }
    
    }
    
    
    public double getAngle() {
        return gyro.getAngle();
    }
    
    private double x=0, y=0;
    private double prevLeftEncoderDistance=0, prevRightEncoderDistance=0;
    
    public void setXY(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void calcXY()
    {
        double distance, leftEncoderDistance, rightEncoderDistance, gyroAngle;
        
        leftEncoderDistance = leftDriveEncoder.getDistance();
        rightEncoderDistance = rightDriveEncoder.getDistance();
        gyroAngle = gyro.getAngle();
        distance =  ((leftEncoderDistance - prevLeftEncoderDistance) + (rightEncoderDistance - prevRightEncoderDistance))/2;
        x = x + distance * Math.sin(Math.toRadians(gyroAngle));
        y = y + distance * Math.cos(Math.toRadians(gyroAngle));
        SmartDashboard.putNumber("chassisX", x);
        SmartDashboard.putNumber("chassisY", y);
        prevLeftEncoderDistance = leftEncoderDistance;
        prevRightEncoderDistance = rightEncoderDistance;
    }
    
    public void calcPeriodic()
    {
        calcXY();
        pidDrive();
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    
    public void resetPosition()
    {
        leftDriveEncoder.reset();
        rightDriveEncoder.reset();
        gyro.reset();
        setXY(0,0);
        this.prevLeftEncoderDistance = 0;
        this.prevRightEncoderDistance = 0;
    }
    public double getRightDistance() {
        return rightDriveEncoder.getDistance();
    }
    
    public double getLeftDistance() {
        return leftDriveEncoder.getDistance();
    }
    
    public void stopDrive()
    {
        gyroPIDLow.disable();
        gyroPIDHigh.disable();
        leftDrivePIDLow.disable();
        rightDrivePIDLow.disable();
        leftDrivePIDHigh.disable();
        rightDrivePIDHigh.disable();            
        tankDrive(0, 0);  
    }
}
