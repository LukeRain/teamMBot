package Command;

import java.util.ArrayList;

public interface Command {

//    private Command command;
//    private ArrayList<String> arguments;

    //        if(commandAndArgs.size() > 1){
    //            this.arguments = (ArrayList<String>) commandAndArgs.subList(1, commandAndArgs.size());
    //        }
    //
    //        switch (commandAndArgs.get(0)){
    //            case "vote":
    //
    //                break;
    //            case "help":
    //                this.command = new HelpCommand(arguments);
    //                break;
    //        }

    public void execute() throws Throwable;
}
