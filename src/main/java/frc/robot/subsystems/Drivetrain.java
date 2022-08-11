package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase{
    private static Drivetrain instance;

    private static final int RIGHTM_MOTOR_ID = 0;
    private static final int LEFTM_MOTOR_ID = 1;
    private static final int RIGHTF_MOTOR_ID = 2;
    private static final int LEFTF_MOTOR_ID = 3;

    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private VictorSPX rightFollower;
    private VictorSPX leftFollower;

    private static final boolean rightMInvert = false;
    private static final boolean leftMInvert = false;
    private static final boolean rightFInvert = false;
    private static final boolean leftFInvert = false;
    

    private Drivetrain(){
        rightMaster = new HSTalon(RIGHTM_MOTOR_ID);
        leftMaster = new HSTalon(LEFTM_MOTOR_ID);
        rightFollower = new VictorSPX(RIGHTF_MOTOR_ID);
        leftFollower = new VictorSPX(LEFTF_MOTOR_ID);
        rightFollower.follow(rightMaster);
        leftFollower.follow(leftMaster);
        rightMaster.setInverted(rightMInvert);
        leftMaster.setInverted(leftMInvert);
        rightFollower.setInverted(rightFInvert);
        leftFollower.setInverted(leftFInvert);
    }

    public void setArcadeDrive(double speed, double turn){
        rightMaster.set(ControlMode.PercentOutput, speed-turn);
        leftMaster.set(ControlMode.PercentOutput, speed+turn);
    }

    public HSTalon getRightMaster(){
        return rightMaster;
    }

    public HSTalon getLeftMaster(){
        return leftMaster;
    }

    public VictorSPX getRightFollower(){
        return rightFollower;
    }

    public VictorSPX getLeftFollower(){
        return leftFollower;
    }

    public static Drivetrain getInstance(){
        if(instance == null){
            instance = new Drivetrain();
        }
        return instance;
    }
}
