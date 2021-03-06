package frc.robot;

import frc.robot.RobotConstants.LiftHeight;
import frc.robot.RobotConstants.OneEightyAngle;

/**
 * listeninng to the statse of the robot
 */
public class RobotStates {
    static OneEightyAngle desireOneEightyAngle = OneEightyAngle.kStraight;
    static boolean hasCargo = false;
    static boolean driveInverted = false;
    static boolean oneEightyOverride = false;
    static boolean LiftOverride = false;
    static boolean isCollected = false;
    static int heightIndex = -1; // The values can be 0,1,2 for rocket - low, middle and cargo ship height And -1 for none of these heights
    // high height have removed from the code from distric 4!
    static LiftHeight liftHeight = LiftHeight.kCargoCollection;
    static LiftHeight lastHeight = LiftHeight.kCargoCollection;

    public static void increaseHeight() {
        if (RobotStates.heightIndex < 2)
            RobotStates.heightIndex++;
    }

    public static void decreaseHeight() {
        if (RobotStates.heightIndex > 0)
            RobotStates.heightIndex--;
    }

    public static int getHeightIndex() {
        return RobotStates.heightIndex;
    }

    public static void setHeightIndex(int index) {
        RobotStates.heightIndex = index;
    }

    public static boolean isHasCargo() {
        return RobotStates.hasCargo;
    }

    public static void setHasCargo(boolean hasCargo) {
        RobotStates.hasCargo = hasCargo;
    }

    public static boolean isDriveInverted() {
        return RobotStates.driveInverted;
    }

    public static void setDriveInverted(boolean driveInverted) {
        RobotStates.driveInverted = driveInverted;
    }

    public static void toggleDriveInverted() {
        RobotStates.driveInverted = !RobotStates.driveInverted;
    }

    public static boolean isOneEightyOverride() {
        return RobotStates.oneEightyOverride;
    }

    public static void toggleOneEightyOverride() {
        RobotStates.oneEightyOverride = !RobotStates.oneEightyOverride;
    }

    public static boolean isLiftOverride() {
        return RobotStates.LiftOverride;
    }

    public static void toggleLiftOverride() {
        RobotStates.LiftOverride = !RobotStates.LiftOverride;
    }
    
    public static LiftHeight getLiftHeight() {
        return RobotStates.liftHeight;
    }

    public static void setLiftHeight(LiftHeight liftHeight) {
        RobotStates.liftHeight = liftHeight;
    }

    public static void setDesireOneEightyAngle(OneEightyAngle desireAngle){
        RobotStates.desireOneEightyAngle = desireAngle;
    }

    public static OneEightyAngle getDesireOneEightyAngle(){
        return RobotStates.desireOneEightyAngle;
    }

    public static boolean isCollected(){
        return RobotStates.isCollected;
    }

    public static void setIsCollected(boolean isCollected){
        RobotStates.isCollected = isCollected;
    }

    public static void toggleOneEightyDesiredAngle(){
        if(RobotStates.desireOneEightyAngle.equals(OneEightyAngle.kStraight)){
            RobotStates.desireOneEightyAngle = OneEightyAngle.kBack;
        } else if(RobotStates.desireOneEightyAngle.equals(OneEightyAngle.kBack)){
            RobotStates.desireOneEightyAngle = OneEightyAngle.kStraight;
        } else if(RobotStates.desireOneEightyAngle.equals(OneEightyAngle.kTopStraight)) {
            RobotStates.desireOneEightyAngle = OneEightyAngle.kTopBack;
        } else if(RobotStates.desireOneEightyAngle.equals(OneEightyAngle.kCargoShipForward)){
            RobotStates.desireOneEightyAngle = OneEightyAngle.kCargoShipBack;
        } else if(RobotStates.desireOneEightyAngle.equals(OneEightyAngle.kCargoShipBack)){
            RobotStates.desireOneEightyAngle = OneEightyAngle.kCargoShipForward;
        } else if(RobotStates.desireOneEightyAngle.equals(OneEightyAngle.kCargoCollection)){
            RobotStates.desireOneEightyAngle = OneEightyAngle.kBack;
        } else {
            RobotStates.desireOneEightyAngle = OneEightyAngle.kTopStraight;
        }
    }

    public static void setLastHeight(LiftHeight heightToSet){
        RobotStates.lastHeight = heightToSet; 
    }

    public static LiftHeight getLastHeight(){
        return RobotStates.lastHeight; 
    }
}
