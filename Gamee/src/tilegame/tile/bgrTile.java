package tilegame.tile;

import gfx.Assets;

public class bgrTile extends Tile{
    public bgrTile( int id) {
        super(Assets.bgr, id);
    }
    @Override
    public boolean isSolid()
    {
        return false;
    }
}
