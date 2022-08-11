package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;

    private DoubleSolenoid flower;
    private DoubleSolenoid extender;

    private static final int FLOWER_F_ID = 0;
    private static final int FLOWER_R_ID = 1;
    private static final int EXTENDER_F_ID = 2;
    private static final int EXTENDER_R_ID = 3;

    private HatchLatcher(){
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FLOWER_F_ID, FLOWER_R_ID);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, EXTENDER_F_ID, EXTENDER_R_ID);
    }

    public void toggleFlower(){
        if (flower.get() == DoubleSolenoid.Value.kOff){
            flower.set(DoubleSolenoid.Value.kReverse);
        }
        else if (flower.get() == DoubleSolenoid.Value.kReverse){
            flower.set(DoubleSolenoid.Value.kForward);
        }
        else{
            flower.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void toggleExtender(){
        if (extender.get() == DoubleSolenoid.Value.kOff){
            extender.set(DoubleSolenoid.Value.kReverse);
        }
        else if (extender.get() == DoubleSolenoid.Value.kReverse){
            extender.set(DoubleSolenoid.Value.kForward);
        }
        else{
            extender.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public static HatchLatcher getInstance(){
        if (instance == null){
            instance = new HatchLatcher();
        }
        return instance;
    }
}
