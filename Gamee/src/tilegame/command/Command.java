package tilegame.command;

import tilegame.Handler;

public abstract class Command {

    protected Handler handler;
    public Command(Handler handler) {
        this.handler = handler;
        }
    public abstract void executeCommand();
}
