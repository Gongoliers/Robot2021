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

public class GalacticSearchPathA extends CommandGroup {

    public GalacticSearchPathA(boolean red) {
        SimplePath paths1 = new SimplePath(); //paths1 = path, segment 1
        SimplePath paths2 = new SimplePath();
        SimplePath paths3 = new SimplePath();
        SimplePath paths4 = new SimplePath();

        if (red) { // Assuming that the robot starts in front of C3 (closest red ball)
            paths1.addStraightAway(5);
            paths2.addRotation(27);
            paths2.addStraightAway(5.59);
            paths3.addRotation(-99);
            paths3.addStraightAway(7.91);
            paths4.addRotation(71);
            paths4.addStraightAway(13.5);
        } else {
            paths1.addRotation(15);
            paths1.addStraightAway(13.15);
            paths2.addRotation(-88);
            paths2.addStraightAway(7.91);
            paths3.addRotation(97);
            paths3.addStraightAway(5.59);
            paths4.addRotation(-33);
            paths4.addStraightAway(6);

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
