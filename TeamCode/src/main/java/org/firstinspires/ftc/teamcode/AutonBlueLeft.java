package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Petoskey Paladins on 10/15/2017.
 */
@Autonomous ( name = "AutonBlueLeft")

public class AutonBlueLeft extends LinearOpMode {
    public DcMotor right;
    public DcMotor left;
    public TouchSensor touch;


    public AutonBlueLeft(){
        

    }

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right_drive");
        left = hardwareMap.dcMotor.get("left_drive");
        touch = hardwareMap.touchSensor.get("touch");

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
