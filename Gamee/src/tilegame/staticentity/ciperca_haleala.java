package tilegame.staticentity;

import gfx.Assets;
import tilegame.Handler;
import tilegame.items.Item;
import tilegame.tile.Tile;

import java.awt.*;

 public class ciperca_haleala extends StaticEntity{
    public ciperca_haleala(Handler handler, float x, float y)
    {
        super(handler, x,y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = 3;
        bounds.y = 10;
        bounds.width = 20;
        bounds.height = 10;


    }
    @Override
    public void die()
    {
        handler.getWorld().getItemManager().addItem(Item.superpower.createNew((int) x,(int) y));
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);

        g.drawImage(Assets.flame,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}
