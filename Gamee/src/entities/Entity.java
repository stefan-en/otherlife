package entities;

import tilegame.Handler;

import java.awt.*;

public abstract class Entity {

    public static final int DEFAULT_HEALTH = 3;

    protected Handler handler;
    public float x,y;
    protected int width, height;
    protected int health;
    protected boolean active = true;

    protected  Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height)
    {

        this.handler = handler;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.health = DEFAULT_HEALTH;


        bounds = new Rectangle(0,0, width,height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void die();

    public void hurt(int amt )//metoda care imi da damage la entitiatile inamice
    {
        health -=amt;
        if(health<= 0) {
            active = false;
            die();
        }
    }
//coliziuni intre entitati
    public boolean checkEntityCollision(float xOffset, float yOffset)
    {
        for(Entity e :handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                return  true;
        }
        return  false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int)(x + bounds.x + xOffset), (int)(y+bounds.y +yOffset), bounds.width,bounds.height);
    }

    //GETERS and SETERS
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }


}
