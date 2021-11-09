package tilegame.staticentity;

import gfx.Assets;
import tilegame.Handler;
import tilegame.items.Item;
import tilegame.tile.Tile;

import java.awt.*;

public class superpower extends  StaticEntity{
    public superpower(Handler handler, float x, float y){
    super(handler,x,y, Tile.TILEWIDTH,Tile.TILEHEIGHT);

    bounds.x = 3;
    bounds.y = (int)(height/5f);
    bounds.width = width - 3;
    bounds.height = (int)(height - height/2f);
    }
    @Override
    public void die()
    {
        handler.getWorld().getItemManager().addItem(Item.haleala.createNew((int) x,(int )y));

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ciperca, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}

