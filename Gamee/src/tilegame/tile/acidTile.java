package tilegame.tile;

import gfx.Assets;

public class acidTile extends Tile{

    public acidTile(int id) {
        super(Assets.acid, id);
    }
    public boolean isSolid()
    {
        return false;
    }

}
