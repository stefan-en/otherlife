package states;

import gfx.Assets;
import tilegame.Handler;
import tilegame.command.*;
import tilegame.ui.ClickLisener;
import tilegame.ui.UIBkg;
import tilegame.ui.UIImageButton;
import tilegame.ui.UIManager;

import java.awt.*;

public class MeniuState extends State {

    private final UIManager uiManager;

    public MeniuState(Handler handler)

    {
        super(handler);
        this.uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIBkg(0,0,1800,960,Assets.bkg));
        uiManager.addObject(new UIImageButton(800, 300, 150, 90, Assets.button_start, new start_command(handler)));
        uiManager.addObject(new UIImageButton(700, 400, 150, 90, Assets.button_easy, new easy_command(handler)) {
            @Override
            public void tick() {
                super.tick();
                setLocked(!GameState.isDifficulty());
            }
        });
        uiManager.addObject(new UIImageButton(900, 400, 150, 90, Assets.button_hard, new hard_command(handler)){
            @Override
            public void tick() {
                super.tick();
                setLocked(GameState.isDifficulty());
            }
        });
        uiManager.addObject(new UIImageButton(800, 500, 150, 90, Assets.button_sett, new sett_command(handler)));
        uiManager.addObject(new UIImageButton(800, 600, 150, 90, Assets.button_exit, new exit_command(handler)));

    }


    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
