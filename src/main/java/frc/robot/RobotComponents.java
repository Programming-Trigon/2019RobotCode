package frc.robot;

import java.util.function.Supplier;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/** this class sets what all of the robot components are */
public class RobotComponents {
    public static class CargoCollector {
        public static final TalonSRX COLECTOR_MOTOR = new TalonSRX(RobotMap.CAN.CARGO_COLLECTOR_MOTOR);
        public static final BaseMotorController RIGHT_HOLDER = new VictorSPX(RobotMap.CAN.CARGO_COLLECTOR_HOLDER_RIGHT_MOTOR);
        public static final BaseMotorController LEFT_HOLDER = new VictorSPX(RobotMap.CAN.CARGO_COLLECTOR_HOLDER_LEFT_MOTOR);
        public static final DigitalInput SWITCH = new DigitalInput(RobotMap.DIO.CARGO_COLLECTOR_SWITCH);
    }

    public static class CargoFolder{
        public static final DoubleSolenoid SOLENOID = new DoubleSolenoid(RobotMap.CAN.PCM, RobotMap.PCM0.CARGO_FOLDER_SOLENOID_FORWARD, RobotMap.PCM0.CARGO_FOLDER_SOLENOID_REVERSE);
    }

    public static class OneEighty {
        public static final TalonSRX MOTOR = new TalonSRX(RobotMap.CAN.ONE_EIGHTY_MOTOR);
        public static final AnalogPotentiometer POT = new AnalogPotentiometer(
                RobotMap.ANALOG_INPUT.ONE_EIGHTY_POTENTIOMETER,
                RobotConstants.Sensors.ONE_EIGHTY_POTENTIOMETER_ANGLE_MULTIPLIER,
                RobotConstants.Sensors.ONE_EIGHTY_POTENTIOMETER_OFFSET);
    }

    public static class HatchHolder{
        public static final DoubleSolenoid PVC = new DoubleSolenoid(RobotMap.CAN.PCM, RobotMap.PCM0.HATCH_HOLDER_PVC_SOLENOID_FORWARD, RobotMap.PCM0.HATCH_HOLDER_PVC_SOLENOID_REVERSE);
        public static final DoubleSolenoid PUSH_SOLENOID = new DoubleSolenoid(RobotMap.CAN.PCM, RobotMap.PCM0.HATCH_HOLDER_PUSH_SOLENOID_FORWARD, 
        RobotMap.PCM0.HATCH_HOLDER_PUSH_SOLENOID_REVERSE);
    }

    public static class HatchCollector{
        public static final DoubleSolenoid SOLENOID = new DoubleSolenoid(RobotMap.CAN.PCM, RobotMap.PCM0.HATCH_COLLECTOR_SOLENOID_FORWARD, RobotMap.PCM0.HATCH_COLLECTOR_SOLENOID_REVERSE);

    }

    public static class Lift {
        public static final TalonSRX LIFT_LEFT_M = new TalonSRX(RobotMap.CAN.LIFT_LEFT_MOTOR);
        public static final TalonSRX LIFT_RIGHT_M = new TalonSRX(RobotMap.CAN.LIFT_RIGHT_MOTOR);
        public static final DigitalInput BOTTOM_SWITCH = new DigitalInput(RobotMap.DIO.LIFT_BOTTOM_MICRO_SWITCH);
        public static final DigitalInput TOP_SWITCH = new DigitalInput(RobotMap.DIO.LIFT_TOP_MICRO_SWITCH);
        public static final Encoder ENCODER = new Encoder(RobotMap.DIO.LIFT_ENCODER_CHANNEL_A,RobotMap.DIO.LIFT_ENCODER_CHANNEL_B);
    }
    
    public static class DriveTrain{
        public static final WPI_TalonSRX REAR_LEFT_M = new WPI_TalonSRX(RobotMap.CAN.REAR_LEFT_MOTOR);
        public static final WPI_TalonSRX FRONT_LEFT_M = new WPI_TalonSRX(RobotMap.CAN.FRONT_LEFT_MOTOR);
        public static final WPI_TalonSRX REAR_RIGHT_M = new WPI_TalonSRX(RobotMap.CAN.REAR_RIGHT_MOTOR);
        public static final WPI_TalonSRX FRONT_RIGHT_M = new WPI_TalonSRX(RobotMap.CAN.FRONT_RIGHT_MOTOR);
        public static final Encoder LEFT_ENCODER = new Encoder(RobotMap.DIO.DRIVE_TRAIN_LEFT_ENCODER_CHANNEL_A, RobotMap.DIO.DRIVE_TRAIN_LEFT_ENCODER_CHANNEL_B); 
        public static final Encoder RIGHT_ENCODER = new Encoder(RobotMap.DIO.DRIVE_TRAIN_RIGHT_ENCODER_CHANNEL_A, RobotMap.DIO.DRIVE_TRAIN_RIGHT_ENCODER_CHANNEL_B); 
        public static final ADXRS450_Gyro GYRO = new ADXRS450_Gyro();
        public static Supplier<Double> AverageDistance = () -> (DriveTrain.LEFT_ENCODER.getDistance() + DriveTrain.RIGHT_ENCODER.getDistance())/2;
    }    
}