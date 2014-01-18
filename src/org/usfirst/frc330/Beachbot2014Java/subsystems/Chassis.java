// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc330.Beachbot2014Java.subsystems;
import org.usfirst.frc330.Beachbot2014Java.RobotMap;
import org.usfirst.frc330.Beachbot2014Java.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.wpilibj.BeachbotMultiPrefSendablePIDController;
import org.usfirst.frc330.wpilibj.DummyPIDOutput;
/**
 *
 */
public class Chassis extends Subsystem implements PIDSource {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftDrive1 = RobotMap.chassisLeftDrive1;
    SpeedController leftDrive2 = RobotMap.chassisLeftDrive2;
    SpeedController leftDrive3 = RobotMap.chassisLeftDrive3;
    SpeedController rightDrive1 = RobotMap.chassisRightDrive1;
    SpeedController rightDrive2 = RobotMap.chassisRightDrive2;
    SpeedController rightDrive3 = RobotMap.chassisRightDrive3;
    Compressor compressor = RobotMap.chassisCompressor;
    DoubleSolenoid shiftSolenoid = RobotMap.chassisShiftSolenoid;
    Encoder leftDriveEncoder = RobotMap.chassisLeftDriveEncoder;
    Encoder rightDriveEncoder = RobotMap.chassisRightDriveEncoder;
    Gyro gyro = RobotMap.chassisGyro;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public BeachbotMultiPrefSendablePIDController gyroPID, leftDrivePID, rightDrivePID;
    private DummyPIDOutput gyroOutput, leftDriveOutput, rightDriveOutput;
    
    double leftManual = 0;
    double rightManual = 0;
    
    public static final String DRIVELOW = "DriveLow";
    public final static String DRIVEHIGH = "DriveHigh";
    public final static String TURNLOW = "TurnLow";
    public final static String TURNHIGH = "TurnHigh";
    
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
        
        gyroOutput = new DummyPIDOutput();
//        gyroOutputHigh = new DummyPIDOutput();
        leftDriveOutput = new DummyPIDOutput();
        rightDriveOutput = new DummyPIDOutput();
//        leftDriveOutputHigh = new DummyPIDOutput();
//        rightDriveOutputHigh = new DummyPIDOutput();
        
        gyroPID = new BeachbotMultiPrefSendablePIDController(0.11,0,0,this,gyroOutput,"gyro");
//      gyroPIDHigh = new MultiPrefSendablePIDController(0.05,0,0,gyro,gyroOutputHigh,"gyroHigh");
        leftDrivePID = new BeachbotMultiPrefSendablePIDController(0.2,0,0,leftDriveEncoder,leftDriveOutput,"leftDrive");
        rightDrivePID = new BeachbotMultiPrefSendablePIDController(0.2,0,0,rightDriveEncoder,rightDriveOutput,"rightDrive");
//        leftDrivePIDHigh = new BeachbotPrefSendablePIDController(0.013,0,0,leftDriveEncoder,leftDriveOutputHigh,"leftDriveHigh");
//        rightDrivePIDHigh = new BeachbotPrefSendablePIDController(0.013,0,0,rightDriveEncoder,rightDriveOutputHigh,"rightDriveHigh");
        
        leftDrivePID.setOutputRange(-0.8, 0.8);
        rightDrivePID.setOutputRange(-0.8, 0.8);
//        leftDrivePIDHigh.setOutputRange(-0.8, 0.8);
//        rightDrivePIDHigh.setOutputRange(-0.8, 0.8);
        
        SmartDashboard.putData("gyroPID", gyroPID);
//        SmartDashboard.putData("gyroPIDHigh", gyroPIDHigh);
        SmartDashboard.putData("leftDrivePID", leftDrivePID);
        SmartDashboard.putData("rightDrivePID", rightDrivePID);
//        SmartDashboard.putData("leftDrivePIDHigh", leftDrivePIDHigh);
//        SmartDashboard.putData("rightDrivePIDHigh", rightDrivePIDHigh);
        final double diameter = 6;
        final double PulseperRevolution = 250;
        final double leftPracticePulsePerRevolution = 360;
        final double encoderGearRatio = 3;
        final double gearRatio = 64/20;
        final double Fudgefactor = 0.94;
        final double distanceperpulse = Math.PI*diameter/PulseperRevolution/encoderGearRatio/gearRatio * Fudgefactor;
        final double leftPracticedistanceperpulse = Math.PI*diameter/leftPracticePulsePerRevolution/encoderGearRatio/gearRatio * Fudgefactor;
//        if (Robot.isPracticerobot())
//            leftDriveEncoder.setDistancePerPulse(leftPracticedistanceperpulse);
//        else
            leftDriveEncoder.setDistancePerPulse(distanceperpulse);
        rightDriveEncoder.setDistancePerPulse(distanceperpulse);
        
        setGyroOffset(0);
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
        
        leftDrive1.set(leftManual);
        leftDrive2.set(leftManual);
        leftDrive3.set(leftManual);
        
        rightManual = rightJoystick.getY();
        
        rightDrive1.set(rightManual);
        rightDrive2.set(rightManual);
        rightDrive3.set(rightManual);
    }
    
    public void tankDrive(double left, double right)
    {
        leftManual = left;
        rightManual = right;
    }
    
    public void shiftHigh()
    {
        shiftSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftLow()
    {
        shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean getShiftState()
    {
//        System.out.println("Shift State: " + shiftSolenoid.get());
        if(shiftSolenoid.get() == DoubleSolenoid.Value.kForward) 
            return true;
        else
            return false;
    }
    
    public double getRightDistance() {
        return rightDriveEncoder.getDistance();
    }
    
    public double getLeftDistance() {
        return leftDriveEncoder.getDistance();
    }
    
    public double getAngle() {
        return gyro.getAngle() + gyroComp;
    }
    
    double maxGyroRate = 0;
    
    public void pidDrive()
    {
        double left, right;
        double gyroRate;
        gyroRate = Math.abs(AnalogModule.getInstance(1).getVoltage(1)/0.007); //TODO need to subtract gyro calibrated value
        if (gyroRate > maxGyroRate)
            maxGyroRate = gyroRate;
        if (counter % 10 == 0)
        {
            SmartDashboard.putNumber("leftEncoder", getLeftDistance());
            SmartDashboard.putNumber("rightEncoder", getRightDistance());
//            SmartDashboard.putNumber("Gyro", getAngle());
//            SmartDashboard.putNumber("GyroRate", gyroRate);
//            SmartDashboard.putNumber("MaxGyroRate", maxGyroRate);
        }
        if (DriverStation.getInstance().isDisabled())
        {
            stopDrive();
        }
        else
        {
            left = leftManual-leftDriveOutput.getOutput() - gyroOutput.getOutput();
            right = rightManual-rightDriveOutput.getOutput() + gyroOutput.getOutput();
            tankDrive(left, right);
        }
    
    }
    
    private double gyroComp = 0;
    public void setGyroOffset(double gyroComp) {
        this.gyroComp = gyroComp;
        SmartDashboard.putNumber("gyroComp", gyroComp);
    }
    
    private double x=0, y=0;
    private double prevLeftEncoderDistance=0, prevRightEncoderDistance=0;
    
    public void setXY(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    int counter = 0;
    public void calcXY()
    {
        double distance, leftEncoderDistance, rightEncoderDistance, gyroAngle;
        
        leftEncoderDistance = leftDriveEncoder.getDistance();
        rightEncoderDistance = rightDriveEncoder.getDistance();
        gyroAngle = getAngle();
        distance =  ((leftEncoderDistance - prevLeftEncoderDistance) + (rightEncoderDistance - prevRightEncoderDistance))/2;
        x = x + distance * Math.sin(Math.toRadians(gyroAngle));
        y = y + distance * Math.cos(Math.toRadians(gyroAngle));
        if (counter % 10 == 0)
        {
            SmartDashboard.putNumber("chassisX", x);
            SmartDashboard.putNumber("chassisY", y);
        }
        prevLeftEncoderDistance = leftEncoderDistance;
        prevRightEncoderDistance = rightEncoderDistance;
    }
    
    public void calcPeriodic()
    {
        calcXY();
        pidDrive();
        counter++;
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
    
    public void stopDrive()
    {
        if (gyroPID.isEnable())
            gyroPID.disable();
//        gyroPIDHigh.disable();
        if (leftDrivePID.isEnable())
            leftDrivePID.disable();
        if (rightDrivePID.isEnable())
            rightDrivePID.disable();
//        leftDrivePIDHigh.disable();
//        rightDrivePIDHigh.disable();            
        tankDrive(0, 0);  
    }
    public double pidGet() {
        return getAngle();
    }
}
