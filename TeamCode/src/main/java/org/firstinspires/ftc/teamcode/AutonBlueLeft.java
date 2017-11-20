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
    public DcMotor grabberMotor, liftMotor;
    // public TouchSensor touch;


    public AutonBlueLeft(){


    }

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        right = hardwareMap.dcMotor.get("right_drive");
        left = hardwareMap.dcMotor.get("left_drive");
        liftMotor = hardwareMap.dcMotor.get("lift");
        grabberMotor = hardwareMap.dcMotor.get("grabber");
        // touch = hardwareMap.touchSensor.get("touch");

        goForwards(1350);
        openGrabber();
        openGrabber();
        goBackwards(250);

    }

    public void closeGrabber() {
        grabberMotor.setPower(0.6);
        sleep(500);
    }

    public void openGrabber() {
        grabberMotor.setPower(-0.6);
        sleep(500);
    }

    public void turnLeft(int time) {
        right.setPower(-.6);
        left.setPower(-.6);
        sleep(time);
        right.setPower(.0);
        left.setPower(.0);
    }

    public void turnRight(int time) {
        right.setPower(.6);
        left.setPower(.6);
        sleep(time);
        right.setPower(-.0);
        left.setPower(-.0);
    }

    public void goForwards(int time) {
        right.setPower(-.6);
        left.setPower(.6);
        sleep(time);
        right.setPower(-.0);
        left.setPower(.0);
    }

    public void goBackwards(int time) {
        right.setPower(.5);
        left.setPower(-.5);
        sleep(time);
        right.setPower(.0);
        left.setPower(-.0);

    }
}
