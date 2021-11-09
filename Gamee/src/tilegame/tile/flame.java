package tilegame.tile;

import gfx.Assets;

public class flame extends Tile{
    public flame(int id){super(Assets.flame,id);}
    public boolean isSolid()
    {
        return true;
    }

}
