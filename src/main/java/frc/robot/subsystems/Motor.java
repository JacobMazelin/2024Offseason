// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;

/** Add your docs here. */
public class Motor extends SubsystemBase{
    public static Motor instance;
    public CANSparkMax motor1;
    public DigitalInput proxSensor;
    BooleanSupplier proxSupplier;
    Trigger proxTrigger;

    public Motor(){
        motor1 = new CANSparkMax(Constants.OperatorConstants.motorID, MotorType.kBrushless);
        proxSensor = new DigitalInput(4);
        
        proxSupplier = new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                return proxSensor.get();
            }
        };
        proxTrigger = new Trigger(proxSupplier);
    }
    public Trigger isTripped(){
        return proxTrigger;
    }
    public static Motor getInstance(){
        if(instance == null)
            instance = new Motor();
        
        return instance;
    }
}
