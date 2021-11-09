package states;
import tilegame.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state)
    {
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }

    //Din aceasta clasa

    protected Handler handler;

    public State(Handler handler)
    {
        this.handler = handler;
    }

    public abstract  void tick();

    public abstract void render(Graphics g);
}
