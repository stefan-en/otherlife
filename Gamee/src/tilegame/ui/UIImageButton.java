package tilegame.ui;

import tilegame.Handler;
import tilegame.command.Command;

import java.awt.*;
import java.awt.image.BufferedImage;
// clasa aceasta im i permite sa pun butoane pe ecranul de pornire
public class UIImageButton extends UIObject{

    private BufferedImage[] start;
    private ClickLisener clickLisener;
    private Command comanda;
    private ClickLisener click;
    private boolean locked;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, Command c) {
        super(x, y, width, height);
        this.start = images;
        this.comanda = c;
        this.click = new ClickLisener() {
            @Override
            public void onClick() {
                comanda.executeCommand();
            }
        };
        locked = false;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        if(hovering || locked)
            g.drawImage(start[1],(int) x, (int) y, width,height, null );
        else
            g.drawImage(start[0],(int) x, (int) y, width,height, null );

    }

    @Override
    public void onClick() {
        comanda.executeCommand();
        //click.onClick();

    }

    public void setClick(ClickLisener click) {
        this.click = click;
    }

    public Command getComanda() {
        return comanda;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }
}
