package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class WristRoller extends SubsystemBase{
    private static WristRoller instance;

    private static final int MOTOR_ID = 0;

    private HSTalon motor;

    private static final boolean motorInvert = false;

    private WristRoller(){
        motor = new HSTalon(MOTOR_ID);
        motor.setInverted(motorInvert);
    }

    public void setPercentOutPut(double output){
        motor.set(ControlMode.PercentOutput, output);
    }
    
    public static WristRoller getInstance(){
        if (instance == null){
            instance = new WristRoller();
        }
        return instance;
    }
}
