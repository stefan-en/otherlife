package tilegame.command;

import states.GameState;
import tilegame.Handler;
import tilegame.ui.UIImageButton;

public class hard_command extends Command{
    public hard_command(Handler handler) {
        super(handler);
    }

    @Override
    public void executeCommand() {
        GameState.setDifficulty(true);
    }

}
