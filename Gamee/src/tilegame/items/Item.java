package tilegame.items;

import gfx.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    //handler
    public static Item[] itmes = new Item[256];

    public static Item superpower = new Item(Assets.superpower,"superpower",0);

    public static Item haleala = new Item(Assets.ciperca,"haleala",1);

    //class
    public static final int ITMWidth = 32, ITMHeight = 32;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    protected Rectangle bounds;//pentru obiectul colectat

    protected int x,y,count;
    protected boolean pickup = false;

    public Item(BufferedImage texture,String name, int id)
    {
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;

        bounds = new Rectangle(x,y,ITMWidth,ITMHeight);

        itmes[id] = this;
    }

    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
            pickup = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().adderItem(this);

        }
    }
    public void render(Graphics g){
        if(handler == null)
            return;
        render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y)
    {
       g.drawImage(texture,x,y, ITMWidth, ITMHeight,null);
    }

    //creez item nou
    public Item createNew(int count) {
        Item i = new Item(texture,name,id);
        i.setPickup(true);
        i.setCount(count);
        return i;
    }
    public Item createNew(int x, int y) {
        Item i = new Item(texture,name,id);
        i.setPositon(x,y);
        return i;
    }
    //dreptunghi ptr item
    public void setPositon(int x, int y)
    {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;

    }
    //geters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;

    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }
}
