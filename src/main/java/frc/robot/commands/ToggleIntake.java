package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends InstantCommand{
    public ToggleIntake(){
        addRequirements(Intake.getInstance());
    }
    public void execute(){
        Intake.getInstance().togglePiston();
    }
}
