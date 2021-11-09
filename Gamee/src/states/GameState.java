package states;

import creatures.Player;
import tilegame.Handler;
import tilegame.World;
import tilegame.ui.UIManager;
import tilegame.ui.UIText;

import java.awt.*;

public class GameState extends State {

    private World world;
    private UIManager uiManager;
    private static boolean difficulty = false; //false-easy // hard-true

    public GameState(Handler handler)
    {
        super(handler);

            }
    @Override
    public void tick() {
        world.tick();
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        uiManager.render(g);
    }

    public static boolean isDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(boolean difficulty) {
        GameState.difficulty = difficulty;
    }

    public  void loadWorld(){
        if(!difficulty )
            world = new World(handler,"Resurse/worlds/nivel1.txt");
        else
            world = new World(handler,"Resurse/worlds/nivel2.txt");
        handler.setWorld(world);

        this.uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIText(20, 55, "Lives: " + Player.getInstance().getHealth(), 55) {
            @Override
            public void tick() {
                setText("Lives: " + Player.getInstance().getHealth());
            }
        });

        uiManager.addObject(new UIText(20, 120, "Score: " + Player.getInstance().getScore(), 55) {
            @Override
            public void tick() {
                setText("Score: " + Player.getInstance().getScore());
            }
        });

    }
}
