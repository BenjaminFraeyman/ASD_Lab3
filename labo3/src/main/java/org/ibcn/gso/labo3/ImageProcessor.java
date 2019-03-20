package org.ibcn.gso.labo3;

import java.util.Stack;
import org.ibcn.gso.labo3.commands.Command;

/**
 *
 * @author tdupont
 */
public class ImageProcessor {
    // TODO: complete this class
    // COMPLETED???
    
    private Stack<Command> commands = new Stack<Command>();
    
    public void addCommand(Command command){
        commands.add(command);
        command.execute();
    }
    
    public Stack<Command> getHistory(){
        return commands;
    }
}
