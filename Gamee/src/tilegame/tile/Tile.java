package tilegame.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //tileurile si id aferent
    public static Tile[] tiles = new Tile[256];
    public static Tile ConturTile = new ConturTile(0);
    public static Tile bgrTile = new bgrTile(1);
    public static Tile acidTile = new acidTile(2);
    public static Tile box = new box(3);
    public static Tile jigsaw = new jigsaw(6);
    public static Tile tepi = new tepi(7);
    //din aceasta clasa
    public static final int TILEWIDTH = 60, TILEHEIGHT = 60;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }
    public void tick(){

    }
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture,x,y,TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid()
    {
        return false;
    }
    public int getId(){
        return  id;
    }

    public boolean doesDamage() {
        return id == 2 || id == 6;
    }
}
