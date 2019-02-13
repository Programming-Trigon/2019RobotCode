package frc.robot;

import java.util.function.Consumer;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.SPI.Port;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

/** this class sets what all of the robot components are */
public class RobotComponents {
    static class CargoCollector {
        public static final TalonSRX COLECTOR_MOTOR = new TalonSRX(RobotMap.CAN.CARGO_COLLECTOR_MOTOR);
        public static final TalonSRX RIGHT_HOLDER = new TalonSRX(RobotMap.CAN.CARGO_COLLECTOR_HOLDER_RIGHT_MOTOR);
        public static final TalonSRX LEFT_HOLDER = new TalonSRX(RobotMap.CAN.CARGO_COLLECTOR_HOLDER_LEFT_MOTOR);
        public static final DigitalInput SWITCH = new DigitalInput(RobotMap.DIO.CARGO_COLLECTOR_SWITCH);
    }

    static class CargoFolder {
        public static final DoubleSolenoid SOLENOID = new DoubleSolenoid(RobotMap.CAN.PCM,
                RobotMap.PCM0.CARGO_FOLDER_SOLENOID_FORWARD, RobotMap.PCM0.CARGO_FOLDER_SOLENOID_REVERSE);
        public static final DigitalInput TOP_SWITCH = new DigitalInput(RobotMap.DIO.CARGO_FOLDER_TOP_SWITCH);
        public static final DigitalInput BOTTOM_SWITCH = new DigitalInput(RobotMap.DIO.CARGO_FOLDER_BOTTOM_SWITCH);
    }

    static class OneEighty {
        public static final TalonSRX MOTOR = new TalonSRX(RobotMap.CAN.ONE_EIGHTY_MOTOR);
        public static final AnalogPotentiometer POT = new AnalogPotentiometer(
                RobotMap.ANALOG_INPUT.ONE_EIGHTY_POTENTIOMETER,
                RobotConstants.ONE_EIGHTY_POTENTIOMETER_ANGLE_MULTIPLIER,
                RobotConstants.ONE_EIGHTY_POTENTIOMETER_OFFSET);
        // public final static AnalogInput POT = new AnalogInput(1);
    }

    static class HatchHolder {
        public static final DoubleSolenoid PVC = new DoubleSolenoid(RobotMap.CAN.PCM,
                RobotMap.PCM0.HATCH_HOLDER_PVC_SOLENOID_FORWARD, RobotMap.PCM0.HATCH_HOLDER_PVC_SOLENOID_REVERSE);
        public static final DoubleSolenoid PUSH_SOLENOID = new DoubleSolenoid(RobotMap.CAN.PCM,
                RobotMap.PCM0.HATCH_HOLDER_PUSH_SOLENOID_FORWARD, RobotMap.PCM0.HATCH_HOLDER_PUSH_SOLENOID_REVERSE);
    }

    static class HatchCollector {
        public static final DoubleSolenoid SOLENOID = new DoubleSolenoid(RobotMap.CAN.PCM,
                RobotMap.PCM0.HATCH_COLLECTOR_SOLENOID_FORWARD, RobotMap.PCM0.HATCH_COLLECTOR_SOLENOID_REVERSE);
    }

    static class Lift {
        public static final TalonSRX LIFT_LEFT_M = new TalonSRX(RobotMap.CAN.LIFT_LEFT_MOTOR);
        public static final TalonSRX LIFT_RIGHT_M = new TalonSRX(RobotMap.CAN.LIFT_RIGHT_MOTOR);
        public static final DigitalInput BOTTOM_SWITCH = new DigitalInput(RobotMap.DIO.LIFT_BOTTOM_MICRO_SWITCH);
        public static final DigitalInput TOP_SWITCH = new DigitalInput(RobotMap.DIO.LIFT_TOP_MICRO_SWITCH);
        public static final AnalogPotentiometer POT = new AnalogPotentiometer(RobotMap.ANALOG_INPUT.LIFT_POTENTIOMETER,
                RobotConstants.Sensors.LIFT_POTENTIOMETER_SCALE_FACTOR,
                RobotConstants.Sensors.LIFT_POTENTOIMETER_OFFSET);
    }

    public static class DriveTrain {
        public final static TalonSRX REAR_LEFT_M = new TalonSRX(RobotMap.CAN.REAR_LEFT_MOTOR);
        public final static TalonSRX FRONT_LEFT_M = new TalonSRX(RobotMap.CAN.FRONT_LEFT_MOTOR);
        public final static TalonSRX REAR_RIGHT_M = new TalonSRX(RobotMap.CAN.REAR_RIGHT_MOTOR);
        public final static TalonSRX FRONT_RIGHT_M = new TalonSRX(RobotMap.CAN.FRONT_RIGHT_MOTOR);

        public final static Encoder DRIVETRAIN_ENCODER_RIGHT = new Encoder(
                RobotMap.DIO.DRIVE_TRAIN_RIGHT_ENCODER_CHANNEL_A, RobotMap.DIO.DRIVE_TRAIN_RIGHT_ENCODER_CHANNEL_B);
        public final static Encoder DRIVETRAIN_ENCODER_LEFT = new Encoder(
                RobotMap.DIO.DRIVE_TRAIN_LEFT_ENCODER_CHANNEL_A, RobotMap.DIO.DRIVE_TRAIN_LEFT_ENCODER_CHANNEL_B);
        public final static ADXRS450_Gyro DRIVETRAIN_GYRO = new ADXRS450_Gyro(Port.kOnboardCS0);
    }
}