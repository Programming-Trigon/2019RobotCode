package frc.robot.Autonomous.FirstHatch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.RobotComponents;
import frc.robot.DrivingCommands.DriveWithGyro;
import frc.robot.DrivingCommands.Turn;
import frc.robot.HatchHolderCommands.EjectHatch;
import frc.robot.LiftCommands.LiftDefaultCommand;
import frc.robot.OICommands.CollectHatchFromFeeder;
import frc.robot.RobotConstants.LiftHeight;
import frc.robot.RobotConstants.RobotDimensions;
import frc.robot.RobotConstants.RobotPIDSettings;

/**
 * scores the first hatch in the autonomous in the side of one of the three
 * rockets then goes to the feeder.
 */

public class ScoreHatchSide extends CommandGroup {
  final double TURN_TO_TARGET = 90;
  final double TARGET_TRACK_TIME = 5;
  final double REVERSE_DIST = 0.5;
  final double START_FEEDER_DISTANCE = 2.32;

  enum CargoShipHatch {
    kFirstHatch(6.9 - RobotDimensions.ROBOT_LENGTH), kSecondHatch(7.45 - RobotDimensions.ROBOT_LENGTH),
    kThirdHatch(8 - RobotDimensions.ROBOT_LENGTH);

    public double key;

    CargoShipHatch(double distance) {
      this.key = distance;
    }
  }

  public ScoreHatchSide(CargoShipHatch driveDistance, boolean isLeft) {
    // Drive towards the Cargo Ship
    addSequential(new DriveWithGyro(driveDistance.key));

    // Turn towards the cargo ship
    addSequential(new Turn( TURN_TO_TARGET * (isLeft ? 1 : -1)));

    // Prepare Robot to deliver hatch:
    addSequential(new LiftDefaultCommand(LiftHeight.kLiftBottomHatch));

    // Use vision to deliver the hatch
    /*addSequential(
        new DriveArcadeWithVision(Robot.driveTrain, VisionPIDSource.VisionTarget.kReflector, () -> 0.0,

            Robot.oi::getYLeft, RobotConstants.RobotPIDSettings.VISION_TURN_SETTINGS),
        TARGET_TRACK_TIME);
    */
    addSequential(new EjectHatch());

    // Orient towards hatch feeder and go there for second hatch:
    // Reverse out of the cargo ship
    addSequential(new DriveWithGyro(REVERSE_DIST));

    // turn to face the feeder
    // angle to turn home depends on how far we drove, so
    // tan(angle to turn) = distance between starting point and feeder / distance
    // driven

    final double TURN_TO_FEEDER = Math.atan(START_FEEDER_DISTANCE / driveDistance.key);

    addSequential(new Turn((TURN_TO_FEEDER + 90) * (isLeft ? 1 : -1)));

    final double distanceToFeeder = Math.sqrt(Math.pow(START_FEEDER_DISTANCE, 2) + Math.pow(driveDistance.key, 2));


    addSequential(new DriveWithGyro(distanceToFeeder));

    // face feeder
    addSequential(new Turn( -TURN_TO_FEEDER * (isLeft ? 1 : -1)));

    addSequential(new CollectHatchFromFeeder());
  }

}
