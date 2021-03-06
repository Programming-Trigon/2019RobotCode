package frc.robot.HatchHolderCommands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetHatchLock extends Command {
  Value value;
  public SetHatchLock(Value value) {
    requires(Robot.hatchHolder);
    this.value = value;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.hatchHolder.setLock(this.value);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
