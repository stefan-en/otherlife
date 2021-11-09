package tilegame.tile;

import gfx.Assets;

public class box extends Tile{
    public box(int id){super(Assets.box, id);}

    @Override
    public boolean isSolid() {
            return true;

    }
}
