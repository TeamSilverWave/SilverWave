/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorEx;



/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Arnav: AtlAtl_OP", group="Iterative Opmode")

public class AtlAtl_Auton extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx leftFrontDrive = null;
    private DcMotorEx rightFrontDrive = null;
    private DcMotorEx leftBackDrive = null;
    private DcMotorEx rightBackDrive = null;
    private DcMotorEx carousel = null;
    private DcMotorEx arm = null;
    //private Servo extender = null;

    // servo initialization
  //  public final static double EXTENDER_HOME = 0.0;  // starting position for extender, can be tuned later
   // public final static double EXTENDER_MIN_RANGE = 0.0; // min position for servo
    //public final static double EXTENDER_MAX_RANGE = 1.0; // max position for servo


    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftFrontDrive = hardwareMap.get(DcMotorEx.class, "left_front");
        rightFrontDrive = hardwareMap.get(DcMotorEx.class, "right_front");
        leftBackDrive = hardwareMap.get(DcMotorEx.class, "left_back");
        rightBackDrive = hardwareMap.get(DcMotorEx.class, "right_back");
        carousel = hardwareMap.get(DcMotorEx.class, "carousel");
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        rightBackDrive.setDirection(DcMotorEx.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotorEx.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotorEx.Direction.FORWARD);
        leftFrontDrive.setDirection(DcMotorEx.Direction.FORWARD);
        carousel.setDirection(DcMotorEx.Direction.FORWARD);
        arm.setDirection(DcMotorEx.Direction.FORWARD);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
// robot code movement
        waitForStart();
        Auton_methods.AtlAtl_Auton vector = new Auton_methods.AtlAtl_Auton();
        vector.DriveForwardTime(2.0,3);

        }
    }
