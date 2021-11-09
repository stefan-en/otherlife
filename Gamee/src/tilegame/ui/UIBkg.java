package tilegame.ui;

import java.awt.*;
import java.awt.image.BufferedImage;
//clasa imi deseneaza backgroundul jocului
public class UIBkg extends UIObject {
    private BufferedImage bkg;
    public UIBkg(float x, float y,int width, int height,BufferedImage ceva) {
        super(x, y, width, height);
        this.bkg = ceva;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bkg,(int)x,(int)y,width,height,null);

    }

    @Override
    public void onClick() {

    }
}
