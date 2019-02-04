package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Folds and unfolds the cargo collector roller */
public class CargoFolder extends Subsystem {
  // solenoid that extents and retracts the cargo intake
  private DoubleSolenoid intakeFolder;

  public CargoFolder(DoubleSolenoid solenoid) {
    this.intakeFolder = solenoid;
  }

  /** folds/unfolds the SS */
  public void setFold(DoubleSolenoid.Value value) {
    this.intakeFolder.set(value);
    this.intakeFolder.set(Value.kOff);
  }

  @Override
  public void initDefaultCommand() {

  }
}
