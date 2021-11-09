package tilegame.command;

import states.GameState;
import states.State;
import tilegame.Game;
import tilegame.Handler;

public class start_command extends Command{

    public start_command(Handler handler) {
        super(handler);
    }

    @Override
    public void executeCommand() {

        handler.getMouseManager().setUiManager(null);
        ((GameState)(handler.getGame().gameState)).loadWorld();
        State.setState(handler.getGame().gameState);

        if(handler.getKeyManager().escape) {
            State.setState(handler.getGame().meniuState);
        }
        System.out.println("Dificultate: " + GameState.isDifficulty());
    }
}
