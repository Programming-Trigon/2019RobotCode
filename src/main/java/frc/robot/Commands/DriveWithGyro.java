/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotComponents;
import frc.robot.RobotConstants;

/*
This command uses the DriveArcadeWithPID to control the robot's distance based on the encoders as well as another PIDController to control the robot's heading
*/

public class DriveWithGyro extends Command {
  private double movementPidOutput, distance, lastTimeNotOnTarget;
  private Supplier<Double> movementSupplier = () -> movementPidOutput; 
  private PIDController movementPidController;
  private Command DriveCommand;
  public DriveWithGyro(double distance) {
    this.distance=distance;
  }

  @Override
  protected void initialize() {
    RobotComponents.DriveTrain.RIGHT_ENCODER.reset();
    RobotComponents.DriveTrain.LEFT_ENCODER.reset();
    
    this.movementPidController = new PIDController(RobotConstants.RobotPIDSettings.DRIVE_SETTINGS.getKP(),
    RobotConstants.RobotPIDSettings.DRIVE_SETTINGS.getKI(), 
    RobotConstants.RobotPIDSettings.DRIVE_SETTINGS.getKD(), 
    new EncoderPIDSource(), (output) -> movementPidOutput = output);
    
    movementPidController.setAbsoluteTolerance(5);
    movementPidController.setOutputRange(-1, 1);
    movementPidController.setSetpoint(this.distance);
    movementPidController.enable();

    DriveCommand = new DriveArcadeWithPID(Robot.driveTrain, RobotComponents.DriveTrain.GYRO, 
    () -> RobotComponents.DriveTrain.GYRO.getAngle(), 
    this.movementSupplier, RobotConstants.RobotPIDSettings.GYRO_DRIVE_SETTINGS, 360, true);
    DriveCommand.start();
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    if (this.movementPidController.onTarget())
      lastTimeNotOnTarget = Timer.getFPGATimestamp();
    return Timer.getFPGATimestamp() - lastTimeNotOnTarget >= RobotConstants.RobotPIDSettings.DRIVE_SETTINGS.getWaitTime();
  }

  @Override
  protected void end() {
    this.movementPidController.disable();
    this.movementPidController.close();
    DriveCommand.close();
  }

  @Override
  protected void interrupted() {
    end();
  }
}