package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.util.OI;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand{
    public IntakeManual(){
        addRequirements(Intake.getInstance());
    }
    public void execute(){
        double speed = OI.getInstance().getDriver().getRightTrigger();
        if (speed>0.5){
            speed = 0.3;
        }
        else{
            speed = 0;
        }
        Intake.getInstance().setPercentOutPut(speed);
    }
    public void end(boolean interrupted){
        Intake.getInstance().setPercentOutPut(0);
    }
}
