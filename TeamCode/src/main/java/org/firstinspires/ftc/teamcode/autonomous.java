package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Petoskey Paladins on 10/15/2017.
 */
@Autonomous ( name = "Autonomous")

public class autonomous extends LinearOpMode {
    public DcMotor right;
    public DcMotor left;

    public autonomous(){

    }

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("rightMotor");
        left = hardwareMap.dcMotor.get("leftMotor");

        right.setPower(.5);
        left.setPower(-.5);

        sleep(3000);

        right.setPower(-.8);
        left.setPower(.8);

        sleep(3000);

        right.setPower(.5);
        left.setPower(.5);

        sleep(2000);

        right.setPower(.2);
        left.setPower(-.2);

        sleep(3000);

        right.setPower(0);
        left.setPower(0);
    }
}
