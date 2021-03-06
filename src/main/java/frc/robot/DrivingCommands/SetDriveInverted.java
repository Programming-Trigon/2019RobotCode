package frc.robot.DrivingCommands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotStates;

/**
  * Sets the drive direction 
  */
public class SetDriveInverted extends InstantCommand {
  boolean state;

  public SetDriveInverted(boolean state) {
    this.state = state;
  }

  @Override
  protected void initialize() {
    RobotStates.setDriveInverted(state);
  }
}
