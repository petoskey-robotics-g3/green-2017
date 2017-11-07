package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Petoskey Paladins on 10/15/2017.
 */
@Autonomous ( name = "AutonRedRight")

public class AutonRedRight extends LinearOpMode {
    public DcMotor right;
    public DcMotor left;
   //public TouchSensor touch;


    public AutonRedRight(){
        

    }

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right_drive");
        left = hardwareMap.dcMotor.get("left_drive");

       //touch = hardwareMap.touchSensor.get("touch");

        goForwards(1455);

       turnLeft(800);

        goForwards(200);



        goBackwards(300);



    }

    public void turnLeft(int time) {
        right.setPower(.5);
        left.setPower(.5);
        sleep(time);
        right.setPower(.0);
        left.setPower(.0);
    }

    public void turnRight(int time) {
        right.setPower(-.5);
        left.setPower(-.5);
        sleep(time);
        right.setPower(-.0);
        left.setPower(-.0);
    }

    public void goForwards(int time) {
        right.setPower(-.5);
        left.setPower(.5);
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
