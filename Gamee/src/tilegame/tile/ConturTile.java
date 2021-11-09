package tilegame.tile;

import gfx.Assets;

public class ConturTile extends Tile {
    public ConturTile( int id) {
        super(Assets.baza, id);
    }
    public boolean isSolid()
    {
        return true;
    }

}
