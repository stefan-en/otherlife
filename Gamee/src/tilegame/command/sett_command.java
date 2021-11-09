package tilegame.command;

import states.State;
import tilegame.Handler;

public class sett_command extends Command{

    public sett_command(Handler handler) {
        super(handler);
    }

    @Override
    public void executeCommand() {
        handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().meniuState);

    }
}
