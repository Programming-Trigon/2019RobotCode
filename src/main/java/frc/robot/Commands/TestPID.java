package frc.robot.Commands;

import java.util.function.Supplier;
import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.utils.PIDSettings;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Vision.DriveArcadeWithVision;
import frc.robot.Vision.VisionPIDSource.VisionTarget;

import frc.robot.RobotConstants.OneEightyAngle;
import frc.robot.OneEightyCommands.StabilizeOneEightyAngle;

public class TestPID extends Command {
  Supplier<Double> KP = ConstantHandler.addConstantDouble("KP", 0.01);
  Supplier<Double> KI = ConstantHandler.addConstantDouble("KI", 0);
  Supplier<Double> KD = ConstantHandler.addConstantDouble("KD", 0.00);
  Supplier<Double> tolerance = ConstantHandler.addConstantDouble("tolerance", 0.1);
  Supplier<Double> WAIT_TIME = ConstantHandler.addConstantDouble("WAIT_TIME", 1);
  Supplier<Double> Setpoint = ConstantHandler.addConstantDouble("Setpoint", 0);

  PIDSettings pidSettings;
  Command testCommand;

  public TestPID() {
  }

  @Override
  protected void initialize() {
    updatePID();
    testCommand = new DriveArcadeWithVision(VisionTarget.kReflectorForward, this.pidSettings);
    testCommand.start();
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return testCommand.isCompleted();
  }

  @Override
  protected void end() {
    //Robot.lift.setMotorSpeed(0);
  }

  public void updatePID(){
    this.pidSettings = new PIDSettings(KP.get(), KI.get(), KD.get(), tolerance.get(), WAIT_TIME.get());
    SmartDashboard.putString("PID setting", "" + KP.get() + KI.get() + KD.get() + tolerance.get() + WAIT_TIME.get());
  }

  @Override
  protected void interrupted() {
    end();
  }
}

