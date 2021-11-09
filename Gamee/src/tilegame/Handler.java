package tilegame;

import gfx.GameCamera;
import tilegame.input.KeyManager;
import tilegame.input.MouseManager;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game)
    {
        this.game = game;
    }
    public GameCamera getGameCamera()
    {
        return game.getGameCamera();
    }
    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    //setters and getters
    public int getWidth()
    {
        return getGame().getWidth();
    }
    public int getHeight()
    {
        return getGame().getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
