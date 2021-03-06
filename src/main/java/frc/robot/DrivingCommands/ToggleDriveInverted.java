package frc.robot.DrivingCommands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotStates;

/**
  * Toggle Inverted Drive 
  */
public class ToggleDriveInverted extends InstantCommand {
  
  public ToggleDriveInverted() {
    setRunWhenDisabled(true);
  }

  @Override
  protected void initialize() {
    RobotStates.toggleDriveInverted();
  }
}
