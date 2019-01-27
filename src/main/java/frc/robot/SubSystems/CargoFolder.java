package frc.robot.SubSystems;

import com.sun.jdi.Value;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Folds the whole SS of the cargo collector */
public class CargoFolder extends Subsystem {
  /** This motor group connects the two motors that bring the SS up and down */
  private DoubleSolenoid solenoid;
  /** these switches ensure that the cargo folder has reached its destination */
  private DigitalInput bottomSwitch, topSwitch;

  public CargoFolder(DoubleSolenoid solenoid, DigitalInput bottomSwitch, DigitalInput topSwitch) {
    this.solenoid = solenoid;
    this.bottomSwitch = bottomSwitch;
    this.topSwitch = topSwitch;
  }

  /** folds/unfolds the SS */
  public void setFold(DoubleSolenoid.Value value) {
    this.solenoid.set(value);
  }

  public boolean bottomSwitchIsClicked() {
    return bottomSwitch.get();
  }

  public boolean topSwitchIsClicked() {
    return topSwitch.get();
  }

  @Override
  public void initDefaultCommand() {

  }
}
