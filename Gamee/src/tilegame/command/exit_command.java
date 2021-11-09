package tilegame.command;

import tilegame.Handler;

public class exit_command extends Command{

    public exit_command(Handler handler) {
        super(handler);
    }

    @Override
    public void executeCommand() {
        System.exit(0);
    }
}
