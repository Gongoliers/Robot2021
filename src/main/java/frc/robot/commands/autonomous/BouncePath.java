package frc.robot.commands.autonomous;

import com.thegongoliers.commands.FollowPathCommand;
import com.thegongoliers.paths.SimplePath;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

/**
 * Drives straight forwards to the low goal of the POWER PORT
 * and delivers the three preloaded POWER CELLs.
 */

public class BouncePath extends CommandGroup {

    public BouncePath() {
        SimplePath path = new SimplePath();
        path.addRotation(-61);
        path.addStraightAway(5.59);
        path.addRotation(117);
        path.addStraightAway(11.67);
        path.addRotation(-139);
        path.addStraightAway(10.98);
        path.addRotation(161);
        path.addStraightAway(10.98);
        path.addRotation(81);
        path.addStraightAway(4.2);
        path.addRotation(-86);
        path.addStraightAway(10.05);
        path.addRotation(136);
        path.addStraightAway(5.55);

        addSequential(
        new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), path)
        // Fire
    );

    }
}
