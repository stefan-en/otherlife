package creatures;
import gfx.Assets;
import tilegame.Animation;
import tilegame.Handler;
import tilegame.items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy_b extends Enemy{

    protected final Animation walk_b_d, atk_b_d, idl_b_d, dead_b_d;
    protected final Animation walk_b_s, atk_b_s,idl_b_s,dead_b_s;
    public Enemy_b(Handler handler, float x, float y )
    {
        super(handler,x,y);
        walk_b_d = new Animation(50, Assets.walk_b_d);
        atk_b_d = new Animation(50,Assets.atk_b_d);
        idl_b_d = new Animation(50, Assets.idl_b_d);
        dead_b_d = new Animation(50,Assets.dead_b_d);

        walk_b_s = new Animation(50, Assets.walk_b_s);
        atk_b_s = new Animation(50,Assets.atk_b_s);
        idl_b_s = new Animation(50, Assets.idl_b_s);
        dead_b_s = new Animation(50,Assets.dead_b_s);
    }

    @Override
    public void tick(){
        super.tick();

        walk_b_d.tick();
        atk_b_d.tick();
        idl_b_d.tick();
        dead_b_d.tick();

        walk_b_s.tick();
        atk_b_s.tick();
        idl_b_s.tick();
        dead_b_s.tick();
    }

    @Override
    public void render(Graphics g)
    {

       // g.setColor(Color.BLACK);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    @Override
    public void die() {
        super.die();
        handler.getWorld().getItemManager().addItem(Item.haleala.createNew((int) x,(int) y+95));

    }
    private BufferedImage getCurrentAnimationFrame(){
        if(isAttacking)
        {
            if(!facing)
                return atk_b_s.getCurrentFrames();
            else
                return atk_b_d.getCurrentFrames();
        }
        if(isMoving) {
            if(!facing)
                return walk_b_s.getCurrentFrames();
            else
                return walk_b_d.getCurrentFrames();
        }
        if(!facing)
            return idl_b_s.getCurrentFrames();
        else
            return idl_b_d.getCurrentFrames();
    }

}
