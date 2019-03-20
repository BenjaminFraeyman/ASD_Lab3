package org.ibcn.gso.labo3.commands;

/**
 * Command Interface specifies the methods that a Command must implement.
 *
 * @author tdupont
 */
public interface Command {
    
    /**
     * Executes this Command.
     */
    void execute();
    
    /**
     * Undoes this Commands.
     */
    void undo();
}
