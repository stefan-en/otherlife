package tilegame.command;

import states.GameState;
import tilegame.Handler;
import tilegame.ui.UIImageButton;

public class easy_command extends Command{

    public easy_command(Handler handler) {
        super(handler);
    }

    @Override
    public void executeCommand() {
        GameState.setDifficulty(false);
    }
}
