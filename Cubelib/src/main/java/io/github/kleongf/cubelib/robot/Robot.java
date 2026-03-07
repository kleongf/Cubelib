package io.github.kleongf.cubelib.robot;

import io.github.kleongf.cubelib.fsm.StateMachine;
import java.util.ArrayList;

public abstract class Robot {
    private final ArrayList<StateMachine> commands;
    private final ArrayList<Subsystem> subsystems;

    // initialize commands and subsystems
    public Robot() {
        commands = new ArrayList<>();
        subsystems = new ArrayList<>();
    }

    // You would register commands and subsystems when initializing your robot
    public void registerCommand(StateMachine command) {
        commands.add(command);
    }
    public void registerSubsystem(Subsystem subsystem) {
        subsystems.add(subsystem);
    }

    // placed in the update() method of an OpMode
    public void update() {
        for (Subsystem subsystem : subsystems) {
            subsystem.update();
        }
        for (StateMachine command : commands) {
            command.update();
        }
    }
    // placed in the start() method of an OpMode
    public void start() {
        for (Subsystem subsystem : subsystems) {
            subsystem.start();
        }
    }
}
