package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This subsystem contains: - The roller that collects the cargo from the top -
 * The wheels that hold the cargo in the 180 lift
 */
public class CargoCollector extends JoystickOverridableSubsystem {
  /** The motor that turns the wheel for bringing in the cargo. */
  private TalonSRX collectorMotor;

  /**
   * After collecting the cargo it goes into the holder. after lifted up these
   * motors shoote cargo out of them.
   */

  private BaseMotorController leftHolder, rightHolder;
  private DigitalInput microswitch;

  public CargoCollector(TalonSRX collectorMotor, BaseMotorController rightCargoHolder, BaseMotorController leftCargoHolder,
      DigitalInput cargoSwitch) {
    this.collectorMotor = collectorMotor;
    this.leftHolder = leftCargoHolder;
    this.rightHolder = rightCargoHolder;
    this.microswitch = cargoSwitch;

    collectorMotor.setInverted(true);
    this.rightHolder.setInverted(true);
    this.leftHolder.setInverted(false);
    this.leftHolder.set(ControlMode.Follower, this.rightHolder.getDeviceID());
    this.leftHolder.setNeutralMode(NeutralMode.Coast);
    this.rightHolder.setNeutralMode(NeutralMode.Coast);
  }

  /** sets motor power of the collector */
  public void setCollectorMotor(double power) {
    this.collectorMotor.set(ControlMode.PercentOutput, power);

  }

  /** sets motor power of the holder */
  public void setHolderMotors(double power) {
    this.rightHolder.set(ControlMode.PercentOutput, power);
  }

  /** This function returns true if the ball is being held */
  public boolean isHoldingBall() {
    return !this.microswitch.get();
  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void move(double power) {
    setCollectorMotor(power);
    setHolderMotors(power);
  }

  public void move(double power, boolean holder){
    if (holder)
      setHolderMotors(power);
    else
      setCollectorMotor(power);
  }

  @Override
  public void setSafeControl(boolean isSafe) {
    //should implement this eventually
  }
}