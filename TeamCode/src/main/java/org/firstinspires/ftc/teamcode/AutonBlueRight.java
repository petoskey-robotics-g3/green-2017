package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Petoskey Paladins on 10/15/2017.
 */
@Autonomous ( name = "AutonBlueRight")

public class AutonBlueRight extends LinearOpMode {
    public DcMotor right;
    public DcMotor left;
    public DcMotor grabberMotor, liftMotor;
    // public TouchSensor touch;


    public AutonBlueRight(){


    }

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        right = hardwareMap.dcMotor.get("right_drive");
        left = hardwareMap.dcMotor.get("left_drive");
        liftMotor = hardwareMap.dcMotor.get("lift");
        grabberMotor = hardwareMap.dcMotor.get("grabber");
        // touch = hardwareMap.touchSensor.get("touch");
        goForwards(1450);
        sleep(300);
        turnLeft(550);
        sleep(10);
        goForwards(1000);
        sleep(5);
        //grabber code goes here
        openGrabber();

        goBackwards(125);



    }

    public void closeGrabber() {
        grabberMotor.setPower(0.5);
        sleep(500);
    }

    public void openGrabber() {
        grabberMotor.setPower(-0.5);
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
        right.setPower(-.25);
        left.setPower(.4);
        sleep(time);
        right.setPower(-.0);
        left.setPower(.0);
    }

    public void goBackwards(int time) {
        right.setPower(.6);
        left.setPower(-.6);
        sleep(time);
        right.setPower(.0);
        left.setPower(-.0);

    }

}

