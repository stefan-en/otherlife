package tilegame.tile;

import gfx.Assets;

public class toxic extends Tile{
    public toxic(int id){super(Assets.toxic, id);}
    public boolean isSolid()
    {
        return true;
    }

}
