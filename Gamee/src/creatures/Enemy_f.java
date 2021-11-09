package creatures;

import gfx.Assets;
import tilegame.Animation;
import tilegame.Handler;
import tilegame.items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy_f extends Enemy_b{
    protected final Animation walk_f_d,atk_f_d,idl_f_d,dead_f_d;
    protected final Animation walk_f_s,atk_f_s,idl_f_s,dead_f_s;

    public Enemy_f(Handler handler,float x, float y){
        super(handler,x,y);
        walk_f_d = new Animation(50, Assets.walk_f_d);
        atk_f_d = new Animation(50,Assets.atk_f_d);
        idl_f_d = new Animation(50, Assets.idl_f_d);
        dead_f_d = new Animation(50,Assets.dead_f_d);

        walk_f_s = new Animation(50, Assets.walk_f_s);
        atk_f_s = new Animation(50,Assets.atk_f_s);
        idl_f_s = new Animation(50, Assets.idl_f_s);
        dead_f_s = new Animation(50,Assets.dead_f_s);
    }
    @Override
    public void tick(){
        super.tick();
        walk_f_d.tick();
        atk_f_d.tick();
        idl_f_d.tick();
        dead_f_d.tick();

        walk_f_s.tick();
        atk_f_s.tick();
        idl_f_s.tick();
        dead_f_s.tick();

    }
    @Override
    public void render(Graphics g)
    {
        //g.setColor(Color.BLACK);
        // g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
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
                return atk_f_s.getCurrentFrames();
            else
                return atk_f_d.getCurrentFrames();
        }
        if(isMoving) {
            if(!facing)
                return walk_f_s.getCurrentFrames();
            else
                return walk_f_d.getCurrentFrames();
        }
        if(!facing)
            return idl_f_s.getCurrentFrames();
        else
            return idl_f_d.getCurrentFrames();
    }
}
