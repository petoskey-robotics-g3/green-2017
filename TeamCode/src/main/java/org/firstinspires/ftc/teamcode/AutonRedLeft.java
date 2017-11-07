package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Petoskey Paladins on 10/15/2017.
 */
@Autonomous ( name = "AutonRedLeft")

public class AutonRedLeft extends LinearOpMode {
    public DcMotor right;
    public DcMotor left;
   // public TouchSensor touch;


    public AutonRedLeft(){
        

    }

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right_drive");
        left = hardwareMap.dcMotor.get("left_drive");
       // touch = hardwareMap.touchSensor.get("touch");

        goForwards(1455);

        turnRight(1550);

        goForwards(270);


        //grabber code goes here




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

