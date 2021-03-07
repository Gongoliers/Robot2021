package frc.robot.commands.autonomous;

import com.thegongoliers.commands.FollowPathCommand;
import com.thegongoliers.paths.SimplePath;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.powercell.DeployIntakePowerCell;
import frc.robot.commands.powercell.ResetPowerCellManipulator;

/**
 * Drives straight forwards to the low goal of the POWER PORT
 * and delivers the three preloaded POWER CELLs.
 */

public class GalacticSearchPathB extends CommandGroup {

    public GalacticSearchPathB(boolean red) {
        SimplePath paths1 = new SimplePath(); //paths1 = path, segment 1
        SimplePath paths2 = new SimplePath();
        SimplePath paths3 = new SimplePath();
        SimplePath paths4 = new SimplePath();

        if (red) { // Assuming that the robot starts in middle of Start zone (7'6")
            paths1.addRotation(-27);
            paths1.addStraightAway(5.59);
            paths2.addRotation(74);
            paths2.addStraightAway(7.07);
            paths3.addRotation(-95);
            paths3.addStraightAway(7.07);
            paths4.addRotation(50);
            paths4.addStraightAway(10.69);
        } else {
            paths1.addRotation(11);
            paths1.addStraightAway(12.75);
            paths2.addRotation(-56);
            paths2.addStraightAway(7.07);
            paths3.addRotation(91);
            paths3.addStraightAway(7.07);
            paths4.addStraightAway(3.64);

        }

        addSequential(new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), paths1));
        addParallel(new DeployIntakePowerCell(), 6.5);
        addSequential(new ResetPowerCellManipulator());
        addSequential(new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), paths2));
        addParallel(new DeployIntakePowerCell(), 6.5);
        addSequential(new ResetPowerCellManipulator());
        addSequential(new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), paths3));
        addParallel(new DeployIntakePowerCell(), 6.5);
        addSequential(new ResetPowerCellManipulator());
        addSequential(new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), paths4));
    }
}
